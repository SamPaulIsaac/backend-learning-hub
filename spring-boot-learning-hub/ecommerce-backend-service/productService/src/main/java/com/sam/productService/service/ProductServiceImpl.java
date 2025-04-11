package com.sam.productService.service;

import com.sam.productService.config.exception.CsvFileEmptyException;
import com.sam.productService.config.exception.ProductNameAlreadyExist;
import com.sam.productService.dto.request.ProductItemCSVDTO;
import com.sam.productService.dto.request.ProductRequestDTO;
import com.sam.productService.dto.response.ProductItemResponseDTO;
import com.sam.productService.dto.response.ProductResponseDTO;
import com.sam.productService.entity.Product;
import com.sam.productService.entity.ProductItem;
import com.sam.productService.repository.ProductItemRepository;
import com.sam.productService.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductItemRepository productItemRepository;
    private ModelMapper modelMapper;

    @Override
    public String addProduct(ProductRequestDTO productRequestDTO) {
        validateProductRequestDTO(productRequestDTO);
        Product product = Product.builder()
                .name(productRequestDTO.getName())
                .build();
        List<ProductItem> productItemList = productRequestDTO.getProductItemRequestDTOList().stream()
                .map(productItem -> modelMapper.map(productItem, ProductItem.class)).toList();
        product.setProductItemList(productItemList);
        productRepository.saveAndFlush(product);
        return "Product saved successfully.";
    }

    private void validateProductRequestDTO(ProductRequestDTO productRequestDTO) {
        if (productRepository.findByName(productRequestDTO.getName()).isPresent()) {
            throw new ProductNameAlreadyExist("Product Name already exist!");
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product is not found for the requested: " + id));
        return convertToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO getProductByName(String name) {
        Product product = productRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Product is not found for the requested: " + name));
        return convertToProductResponseDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToProductResponseDTO).collect(Collectors.toList());
    }

    private ProductResponseDTO convertToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = modelMapper.map(product, ProductResponseDTO.class);
        productResponseDTO.setProductItemResponseDTOS(product.getProductItemList().stream()
                .map(item -> modelMapper.map(item, ProductItemResponseDTO.class)).collect(Collectors.toList()));
        return productResponseDTO;
    }

    @Override
    @Transactional
    public String addProductFromCSV(MultipartFile productCsv) throws IOException {
        validateNonEmptyAndCheckHeaders(productCsv);
        InputStreamReader inputStreamReader = new InputStreamReader(productCsv.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String currentLine;
        boolean isHeaderSkipped = false;
        while ((currentLine = bufferedReader.readLine()) != null) {
            if (!isHeaderSkipped) {
                isHeaderSkipped = true;
                continue;
            }
            CSVParser csvParser = new CSVParser(new StringReader(currentLine), CSVFormat.DEFAULT);

            List<ProductItemCSVDTO> productItemCSVDTOS = new ArrayList<>();

            for (CSVRecord csvRecord : csvParser) {
                productItemCSVDTOS.add(ProductItemCSVDTO.builder()
                        .productName(csvRecord.get(0))
                        .itemName(csvRecord.get(1))
                        .itemQuantity(Integer.valueOf(csvRecord.get(2)))
                        .build());
            }

            for (ProductItemCSVDTO productItemCSVDTO :
                    productItemCSVDTOS) {
                saveProductAndItem(productItemCSVDTO);
            }
        }
        return "Successfully imported the data into table from CSV.";
    }

    @Override
    @Transactional
    public ProductResponseDTO updateQuantity(Long itemId, Integer quantity) {
        Optional<ProductItem> productItem = productItemRepository.findById(itemId);
        Integer calculatedQuantity = productItem.get().getQuantity() - quantity;
        productItemRepository.updateQuantity(itemId, calculatedQuantity);
        Optional<ProductItem> updatedProductItem = productItemRepository.findById(itemId);
        Product product = productRepository.findById(updatedProductItem.get().getProduct().getId()).get();
        ProductResponseDTO productResponseDTO = modelMapper.map(product, ProductResponseDTO.class);
        productResponseDTO.setProductItemResponseDTOS(product.getProductItemList().stream()
                .map(item -> modelMapper.map(item, ProductItemResponseDTO.class)).collect(Collectors.toList()));
        return productResponseDTO;
    }

    private void saveProductAndItem(ProductItemCSVDTO productItemCSVDTOS) {
        Optional<Product> existingProduct = productRepository.findByName(productItemCSVDTOS.getProductName());

        Product product = existingProduct.orElseGet(() -> productRepository.saveAndFlush(
                Product.builder()
                        .name(productItemCSVDTOS.getProductName())
                        .build()
        ));

        productItemRepository.saveAndFlush(
                ProductItem.builder()
                        .name(productItemCSVDTOS.getItemName())
                        .quantity(productItemCSVDTOS.getItemQuantity())
                        .product(product)
                        .build());
    }


    private void validateNonEmptyAndCheckHeaders(MultipartFile productCsv) throws IOException {
        if (productCsv.isEmpty())
            throw new CsvFileEmptyException("File is empty, cannot process ");
        InputStreamReader inputStreamReader = new InputStreamReader(productCsv.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String firstLine = bufferedReader.readLine();
        if (firstLine.isEmpty() ||
                !firstLine.trim().equals("product_name,item_name,quantity")) {
            throw new CsvFileEmptyException("File does not contain valid headers.");
        }

        inputStreamReader.close();
        bufferedReader.close();
    }
}

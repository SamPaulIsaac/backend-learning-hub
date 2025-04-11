package com.sam.productService.service;

import com.sam.productService.dto.request.ProductRequestDTO;
import com.sam.productService.dto.response.ProductResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    String addProduct(ProductRequestDTO productRequestDTO);

    void deleteProduct(Long productId);

    ProductResponseDTO getProductById(Long id);

    ProductResponseDTO getProductByName(String name);

    List<ProductResponseDTO> getAllProducts();

    String addProductFromCSV(MultipartFile productCsv) throws IOException;

    ProductResponseDTO updateQuantity(Long itemId, Integer quantity);

}

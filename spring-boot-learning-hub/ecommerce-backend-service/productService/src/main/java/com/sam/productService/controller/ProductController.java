package com.sam.productService.controller;

import com.sam.productService.dto.request.ProductRequestDTO;
import com.sam.productService.dto.response.ProductResponseDTO;
import com.sam.productService.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
@Slf4j
public class ProductController {
    private ProductServiceImpl productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        log.info("Requested received to add product with request body: " + productRequestDTO);
        return productService.addProduct(productRequestDTO);
    }

    @PostMapping("/file")
    public String addProductFromCSV(@RequestParam("file") MultipartFile productCsv) throws IOException {
        log.info("Requested received to add product from CSV: " + productCsv);
        return productService.addProductFromCSV(productCsv);
    }


    @GetMapping("/getAllProducts")
    public List<ProductResponseDTO> getAllProducts() {
        log.info("Requested received to get all products.");
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ProductResponseDTO getProductById(@PathVariable Long productId) {
        log.info("Requested received to get product for the product id: " + productId);
        return productService.getProductById(productId);
    }

    @GetMapping("/{name}")
    public ProductResponseDTO getProductByName(@PathVariable String name) {
        log.info("Requested received to get product for the requested product name: " + name);
        return productService.getProductByName(name);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        log.info("Requested received to delete product for the id: " + id);
        productService.deleteProduct(id);
        return "Product Successfully deleted.";
    }
}


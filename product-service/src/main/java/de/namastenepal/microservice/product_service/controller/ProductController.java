package de.namastenepal.microservice.product_service.controller;

import de.namastenepal.microservice.product_service.dto.ProductRequest;
import de.namastenepal.microservice.product_service.dto.ProductResponse;
import de.namastenepal.microservice.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Creates a new product.
     *
     * @param productRequest DTO containing product details from the request.
     * @return ResponseEntity<ProductResponse> containing the created product details.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse response = productService.createProduct(productRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED) // 201 Created
                .body(response);
    }

    /**
     * Retrieves all products.
     *
     * @return ResponseEntity<List<ProductResponse>> containing all stored products.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();

        return ResponseEntity
                .status(HttpStatus.OK) // 200 OK
                .body(products);
    }
}

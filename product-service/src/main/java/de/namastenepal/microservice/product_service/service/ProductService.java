package de.namastenepal.microservice.product_service.service;

import de.namastenepal.microservice.product_service.dto.ProductRequest;
import de.namastenepal.microservice.product_service.dto.ProductResponse;
import de.namastenepal.microservice.product_service.model.Product;
import de.namastenepal.microservice.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Creates a new product in the database and returns the created product details.
     *
     * @param productRequest DTO containing product details from the request.
     * @return ProductResponse DTO containing saved product information.
     */
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        // Save product to the database and retrieve the stored entity with generated ID
        product = productRepository.save(product);

        log.info("✅ Product created successfully: {}", product);

        // Convert and return the saved product as a DTO
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    /**
     * Retrieves all products from the database and returns them as a list of ProductResponse DTOs.
     *
     * @return List<ProductResponse> containing all stored products.
     */
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> products = productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                ))
                .toList();

        log.info("📦 Retrieved {} products from the database", products.size());
        return products;
    }
}

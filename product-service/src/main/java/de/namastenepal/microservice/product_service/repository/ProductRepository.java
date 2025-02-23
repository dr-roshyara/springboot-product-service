package de.namastenepal.microservice.product_service.repository;

import de.namastenepal.microservice.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

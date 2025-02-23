package de.namastenepal.microservice.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product") // Maps this class to the "product" collection in MongoDB
@AllArgsConstructor // Generates a constructor with all fields as parameters
@NoArgsConstructor // Generates a no-argument constructor
@Builder // Provides a builder pattern for object creation
@Data // Bundles @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor
public class Product {
   @Id // Marks this field as the primary key
   private String id; // Unique identifier for the product
   private String name; // Name of the product
   private String description; // Description of the product
   private BigDecimal price; // Price of the product
}
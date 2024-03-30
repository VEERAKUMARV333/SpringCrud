package com.example.springcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service class for managing Product entities.
@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Save a product.
    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }

    //get all products from repository
    public List<Product> getAllProducts() {return productRepository.findAll();}

    //get one product from repository
    public Optional<Product> getProductById(Long id) {return productRepository.findById(id);}

    //update the product
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    //delete the product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

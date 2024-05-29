package com.shoppingList.shoppingList.service;

import com.shoppingList.shoppingList.model.Product;
import com.shoppingList.shoppingList.model.User;
import com.shoppingList.shoppingList.repository.ProductRepository;
import com.shoppingList.shoppingList.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Product> getAllProduct(){
        String username = "abir";
        User user = userRepository.findUserByEmail(username).orElse(null);
        return productRepository.findByUser(user);
    }

    public Product getProductById(ObjectId id) {
        String username = "abir";
        User user = userRepository.findUserByEmail(username).orElse(null);
        Product product = productRepository.findById(id);
        if (product != null && product.getUser().equals(user)) {
            return product;
        }
        return null;
    }

    public Product saveProduct(Product product) {
        String username = "abir";
        User user = userRepository.findUserByEmail(username).orElse(null);
        product.setUser(user);
        return productRepository.save(product);
    }

    public void deleteProduct(ObjectId id) {
        String username = "abir";
        User user = userRepository.findUserByEmail(username).orElse(null);
        Product product = productRepository.findById(id);
        if (product != null && product.getUser().equals(user)) {
            productRepository.deleteById(id);
        }
    }
}

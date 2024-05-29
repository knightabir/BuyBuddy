package com.shoppingList.shoppingList.repository;

import com.shoppingList.shoppingList.model.Product;
import com.shoppingList.shoppingList.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByUser(User user);
    Product findById(ObjectId id);
    void deleteById(ObjectId id);
}

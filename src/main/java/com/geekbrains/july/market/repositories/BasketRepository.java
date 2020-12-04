package com.geekbrains.july.market.repositories;

import com.geekbrains.july.market.entities.Basket;
import com.geekbrains.july.market.entities.Category;
import com.geekbrains.july.market.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findAll();
    List<Product> findAllById(Long id);
    Product save(Product product);

}
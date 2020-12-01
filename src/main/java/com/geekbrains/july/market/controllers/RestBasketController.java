package com.geekbrains.july.market.controllers;

import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.entities.dtos.ProductDto;
import com.geekbrains.july.market.exceptions.ProductNotFoundException;
import com.geekbrains.july.market.services.BasketService;
import com.geekbrains.july.market.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/basket")
public class RestBasketController {
    private BasketService basketService;

    @Autowired
    public RestBasketController(BasketService basketService) {
        this.basketService = basketService;
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return basketService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneProducts(@PathVariable Long id) {
        if (!basketService.existsById(id)) {
            throw new ProductNotFoundException("Product not found, id: " + id);
        }
        return new ResponseEntity<>(basketService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping
    public String deleteAllProducts(@PathVariable Long id) {
        basketService.deleteAll();
        return "OK";
    }

    @DeleteMapping("/{id}")
    public String deleteOneProducts(@PathVariable Long id) {
        basketService.deleteById(id);
        return "OK";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveNewProduct(@RequestBody Product product) {
        if (product.getId() != null) {
            product.setId(null);
        }
        return basketService.saveOrUpdate(product);
    }

    @PutMapping
    public ResponseEntity<?> modifyProduct(@RequestBody Product product) {
        if (product.getId() == null || !basketService.existsById(product.getId())) {
            throw new ProductNotFoundException("Product not found, id: " + product.getId());
        }
        if (product.getPrice() < 0) {
            return new ResponseEntity<>("Product's price can not be negative", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(basketService.saveOrUpdate(product), HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(ProductNotFoundException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }
}
package com.geekbrains.july.market.services;

import com.geekbrains.july.market.entities.Basket;
import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.entities.dtos.ProductDto;
import com.geekbrains.july.market.exceptions.ProductNotFoundException;
import com.geekbrains.july.market.repositories.BasketRepository;
import com.geekbrains.july.market.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    private BasketRepository basketRepository;
    private ProductsService productsService;

//    @Autowired
//    public void setBasketRepository(ProductsService productsService) {
//        this.productsService = productsService;
//    }

    @Autowired
    public void setBasketRepository(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public Product saveOrUpdate(Product product) {
        return basketRepository.save(product);
    }

    public Product findById(Long id) {
        return basketRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Can't found product with id = " + id));
    }

    public List<Product> findAll() {
        return basketRepository.findAll();
    }

    public Page<Product> findAll(Specification<Product> spec, Integer page) {
        if (page < 1L) {
            page = 1;
        }
        return basketRepository.findAll(spec, PageRequest.of(page - 1, 10));
    }

    public void deleteAll() {
        basketRepository.deleteAll();
    }

    public void deleteById(Long id) {
        basketRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return basketRepository.existsById(id);
    }

//    public List<ProductDto> getDtoData() {
//        return basketRepository.findAllBy();
//    }
}

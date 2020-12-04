package com.geekbrains.july.market.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.List;

@Data
@NoArgsConstructor

public class Basket {

    List<Product> products;

    private int count;

    public int getCount() {
        return products.size();
    }

    public void addProduct(Product product){
        products.add(product);
    }



}

package com.geekbrains.july.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JulyMarketApplication {
	// Домашнее задание:
	// 1. Реализуйте корзину в виде бина (корзина не сущность, а обычный Спринг бин)
	// 2. Необходимо добавлять товары в корзину, удалять их оттуда, просматривать
	// список товаров в корзине

	public static void main(String[] args) {
		SpringApplication.run(JulyMarketApplication.class, args);
	}
}
package ru.geekbrains.happy.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class HappyMarketApplication {
	// Домашнее задание:
	// 1. Добавьте синглтон корзину
	// 2. Корзину отображаете ниже

	public static void main(String[] args) {
		SpringApplication.run(HappyMarketApplication.class, args);
	}
}

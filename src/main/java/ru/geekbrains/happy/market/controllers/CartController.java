package ru.geekbrains.happy.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.happy.market.exceptions_handling.ResourceNotFoundException;
import ru.geekbrains.happy.market.model.Cart;
import ru.geekbrains.happy.market.model.Product;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final Cart cart;

    @GetMapping
    public Map<Product,Integer> showCart(){
        return cart.showCart();
    }

    @GetMapping("/add/{id}")
    public void addProduct(@PathVariable Long id){
        try {
            cart.addProduct(id);
        } catch (ResourceNotFoundException e){}
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        try{
            cart.deleteProduct(id);
        } catch (ResourceNotFoundException e){}
    }

    @GetMapping("delete/all")
    public void clearCart(){
        cart.clearCart();
    }
}

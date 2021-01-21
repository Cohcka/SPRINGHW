package ru.geekbrains.happy.market.model;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import ru.geekbrains.happy.market.exceptions_handling.ResourceNotFoundException;
import ru.geekbrains.happy.market.services.ProductService;

import java.util.HashMap;
import java.util.Map;

@Scope ("prototype")
@RequiredArgsConstructor
public class Cart {
    private final Map<Product, Integer> cartList = new HashMap<>();
    private final ProductService productService;

    public Map<Product, Integer> showCart(){
        return cartList;
    }

    public void addProduct(Long id) throws ResourceNotFoundException {
        Product product = productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        if(!cartList.containsKey(product)){
            cartList.put(product, 1);
        } else {
            cartList.put(product,cartList.get(product)+1);
        }
    }

    public void deleteProduct(Long id) throws ResourceNotFoundException {
        Product product = productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        if(cartList.containsKey(product)){
            cartList.remove(product);
        } else {
            throw new ResourceNotFoundException(id.toString());
        }
    }

    public void clearCart(){
        cartList.clear();
    }
}

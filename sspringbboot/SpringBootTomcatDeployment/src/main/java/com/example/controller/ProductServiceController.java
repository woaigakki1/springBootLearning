package com.example.controller;

import com.example.pojo.Product;
import com.example.springBootException.productNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {
    private  static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("honey");
        productRepo.put(honey.getId(), honey);
        Product almond = new Product();
        almond.setId("2");
        almond.setId("Almond");
        productRepo.put(almond.getId(),almond);
    }
    @RequestMapping(value = "/products/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        if (!productRepo.containsKey(id)) {
            throw new productNotFoundException();
        }
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return  new ResponseEntity<>("update successfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>("getProducts", HttpStatus.OK);
    }
}

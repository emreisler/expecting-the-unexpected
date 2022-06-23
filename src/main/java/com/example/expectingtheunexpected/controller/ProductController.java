package com.example.expectingtheunexpected.controller;

import com.example.expectingtheunexpected.payload.ProductDTO;
import com.example.expectingtheunexpected.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public void createProduct(@Valid @RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") String id, @Valid @RequestBody ProductDTO productDTO){
        productService.updateProduct(id,productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") String id){
        productService.deleteProduct(id);
    }

}

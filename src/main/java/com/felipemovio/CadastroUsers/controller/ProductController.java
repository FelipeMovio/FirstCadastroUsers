package com.felipemovio.CadastroUsers.controller;

import com.felipemovio.CadastroUsers.model.Product;
import com.felipemovio.CadastroUsers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> verTodos(){
        List<Product> product = productService.verProdutos();
        return ResponseEntity.ok(product);
    }


}

package com.felipemovio.CadastroUsers.controller;

import com.felipemovio.CadastroUsers.model.Product;
import com.felipemovio.CadastroUsers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ResponseEntity<List<Product>> verTodos(){
        List<Product> product = productService.verProdutos();
        return ResponseEntity.ok(product);
    }
}

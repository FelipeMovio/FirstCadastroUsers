package com.felipemovio.CadastroUsers.controller;

import com.felipemovio.CadastroUsers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired
    private ProductService productService;
}

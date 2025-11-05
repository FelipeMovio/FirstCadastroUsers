package com.felipemovio.CadastroUsers.service;

import com.felipemovio.CadastroUsers.model.Product;
import com.felipemovio.CadastroUsers.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // ver itens listas
    public List<Product> verProdutos(){
        return repository.findAll();
    }

    // criar item
    public Product criarProduto(Product product){
        return repository.save(product);
    }
}

package com.felipemovio.CadastroUsers.controller.admin;

import com.felipemovio.CadastroUsers.dto.response.RegisterResponseDTO;
import com.felipemovio.CadastroUsers.model.Product;
import com.felipemovio.CadastroUsers.service.ProductService;
import com.felipemovio.CadastroUsers.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/panel")
    public ResponseEntity<List<RegisterResponseDTO>> allUsers(){
        List<RegisterResponseDTO> users = usersService.listarTodos();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create/product")
    public ResponseEntity<Product> criar(@RequestBody Product product){
        Product product1 = productService.criarProduto(product);
        return ResponseEntity.ok(product);
    }
}

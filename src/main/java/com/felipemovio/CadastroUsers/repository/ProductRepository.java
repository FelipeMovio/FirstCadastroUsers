package com.felipemovio.CadastroUsers.repository;

import com.felipemovio.CadastroUsers.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}

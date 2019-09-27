package br.com.alan.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alan.teste.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

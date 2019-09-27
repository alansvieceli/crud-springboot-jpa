package br.com.alan.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alan.teste.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

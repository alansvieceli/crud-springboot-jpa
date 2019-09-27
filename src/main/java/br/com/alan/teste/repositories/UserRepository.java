package br.com.alan.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alan.teste.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

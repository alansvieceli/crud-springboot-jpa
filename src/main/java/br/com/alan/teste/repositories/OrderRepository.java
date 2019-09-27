package br.com.alan.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alan.teste.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}

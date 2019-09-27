package br.com.alan.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alan.teste.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}

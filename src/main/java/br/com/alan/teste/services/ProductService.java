package br.com.alan.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alan.teste.entities.Product;
import br.com.alan.teste.repositories.ProductRepository;

//@Component //component registration
//ou
//@Repository
//ou
@Service
public class ProductService {
	
	@Autowired 
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		 Optional<Product> obj = productRepository.findById(id);
		 return obj.get();
	}

}

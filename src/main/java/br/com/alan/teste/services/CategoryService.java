package br.com.alan.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alan.teste.entities.Category;
import br.com.alan.teste.repositories.CategoryRepository;

//@Component //component registration
//ou
//@Repository
//ou
@Service
public class CategoryService {
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		 Optional<Category> obj = categoryRepository.findById(id);
		 return obj.get();
	}

}

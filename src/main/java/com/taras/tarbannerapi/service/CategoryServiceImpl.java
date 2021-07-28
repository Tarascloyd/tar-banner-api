package com.taras.tarbannerapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taras.tarbannerapi.entity.Category;
import com.taras.tarbannerapi.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	
	private CategoryRepository categoryRepository;
	
		
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Long theId) {

		return categoryRepository.findById(theId)
				.orElseThrow(() -> new RuntimeException("Did not find category id - " + theId));
	}

	@Override
	public Category save(Category theCategory) {
		return categoryRepository.save(theCategory);

	}

	@Override
	public void deleteById(Long theId) {
		categoryRepository.deleteById(theId);

	}

	@Override
	public List<Category> searchBy(String theName) {
		return categoryRepository.findByNameContainsAllIgnoreCase(theName);
	}

}

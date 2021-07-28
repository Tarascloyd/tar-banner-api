package com.taras.tarbannerapi.service;

import java.util.List;

import com.taras.tarbannerapi.entity.Category;

public interface CategoryService {

	public List<Category> findAll();
	
	public Category findById(Long theId);
	
	public Category save(Category theCategory);
	
	public void deleteById(Long theId);
	
	public List<Category> searchBy(String theName);
}

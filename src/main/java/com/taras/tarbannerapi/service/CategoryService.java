package com.taras.tarbannerapi.service;

import java.util.List;

import com.taras.tarbannerapi.entity.Category;

public interface CategoryService {

	public List<Category> findAll();
	
	public Category findById(int theId);
	
	public void save(Category theCategory);
	
	public void deleteById(int theId);
	
	public List<Category> searchBy(String theName);
}

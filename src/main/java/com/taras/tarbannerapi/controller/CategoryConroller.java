package com.taras.tarbannerapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taras.tarbannerapi.entity.Category;
import com.taras.tarbannerapi.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryConroller {

	private CategoryService categoryService;
		
	public CategoryConroller(CategoryService categoryService) {
		this.categoryService = categoryService;
		Category category1 = new Category();
	    category1.setName("music");
	    Category category2 = new Category();
	    category2.setName("movies");
	    this.categoryService.save(category1);
	    this.categoryService.save(category2);
	}



	@GetMapping({"/", ""})
	public @ResponseBody Iterable<Category> getAllCategories() {
	    
		return categoryService.findAll();
	}

}

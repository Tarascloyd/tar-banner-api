package com.taras.tarbannerapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taras.tarbannerapi.entity.Category;
import com.taras.tarbannerapi.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("api/categories")
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

	@GetMapping("/search")
	public @ResponseBody Iterable<Category> getCategoriesSearchByName(
			@RequestParam("name") String name) {
		if (name.trim().isEmpty()) {
			return categoryService.findAll();
		}
		return categoryService.searchBy(name);
	}

	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable("id") Long id) {

		return categoryService.findById(id);
	}

	@PostMapping({"/", ""})
	@ResponseStatus(HttpStatus.CREATED)
	public Category postCategory(@RequestBody final Category category) {

		return categoryService.save(category);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Category updateCategory(@PathVariable("id") Long id,
								 @RequestBody final Category category) {

		return categoryService.save(category);
	}

	@DeleteMapping("/{id}")
	public void deleteCategoryById(@PathVariable("id") Long id) {

		categoryService.deleteById(id);
	}

}

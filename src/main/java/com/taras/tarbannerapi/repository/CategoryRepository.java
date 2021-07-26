package com.taras.tarbannerapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taras.tarbannerapi.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	List<Category> findByNameContainsAllIgnoreCase(String theName);
}

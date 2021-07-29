package com.taras.tarbannerapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taras.tarbannerapi.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Modifying
	@Query("update Category c set c.deleted = true where c.id = ?1")
	void deleteById(Long id);

	List<Category> findByNameContainsAllIgnoreCase(String theName);
}

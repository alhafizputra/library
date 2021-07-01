package com.example.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.BookCategoryModel;

@Repository
public interface BookCategoryRepo extends JpaRepository<BookCategoryModel, Long>{
	public BookCategoryModel findByCategory(String name);
}

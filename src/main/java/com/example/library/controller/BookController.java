package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.BookModel;
import com.example.library.repo.BookRepo;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookRepo bookRepo;

	@GetMapping
	public List<BookModel> read() {
		return bookRepo.findAll();
	}
	
	@PostMapping()
	public BookModel create(@RequestBody BookModel bookModel) {
		return bookRepo.save(bookModel);
	}
	

	@PutMapping("/{id}")
	public BookModel update(@PathVariable(value="id") Long id, @RequestBody BookModel bookModel) throws Exception {
			BookModel book = bookRepo.findById(id).orElseThrow(() -> new Exception());
			book.setBookName(bookModel.getBookName());
			book.setBookCode(bookModel.getBookCode());
			book.setAuthor(bookModel.getAuthor());
			book.setYears(bookModel.getYears());
			return bookRepo.save(book);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		bookRepo.deleteById(id);
		return "Book with id " + id + " has been deleted";
	}
	
}

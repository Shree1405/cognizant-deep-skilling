package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayService() {

        System.out.println("BookService: Service is working.");

        bookRepository.displayBook();

    }

}
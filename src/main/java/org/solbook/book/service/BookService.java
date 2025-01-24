package org.solbook.book.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.solbook.book.controller.request.BookRequest;
import org.solbook.book.domain.Book;
import org.solbook.book.repository.BookRepository;
import org.solbook.common.exception.BookException;
import org.solbook.common.exception.ExceptionMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public void saveBook(@Valid BookRequest request) {
        if (checkBookExist(request.title(),request.author())) {
            throw new BookException(ExceptionMessage.BOOK_DUPLICATION);
        }
        Book book = new Book(request.title(), request.author(), request.image());
        bookRepository.save(book);
    }

    private boolean checkBookExist(String title, String author){
        return bookRepository.existsByTitleAndAuthor(title, author);
    }

}

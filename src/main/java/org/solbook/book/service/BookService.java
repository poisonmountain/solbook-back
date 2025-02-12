package org.solbook.book.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.solbook.book.controller.request.BookRequest;
import org.solbook.book.controller.request.BookSliceRequest;
import org.solbook.book.controller.response.BookResponse;
import org.solbook.book.controller.response.BookSliceResponse;
import org.solbook.book.domain.Book;
import org.solbook.book.repository.BookRepository;
import org.solbook.common.exception.BookException;
import org.solbook.common.exception.ExceptionMessage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public BookResponse getBook(Long bookId) {
        Book book = getBookById(bookId);
        return BookResponse.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .image(book.getImage())
                .build();
    }

    public Slice<BookSliceResponse> getBookSliceSearch(BookSliceRequest bookSliceRequest) {
        Pageable pageable = PageRequest.of(bookSliceRequest.page(), bookSliceRequest.size());
        Slice<Book> bookSlice = bookRepository
                .findByTitleOrAuthorOrderByQuizCount(bookSliceRequest.searchKeyword(), pageable);
        List<BookSliceResponse> bookSliceResponseList = bookSlice.getContent().stream()
                .map(book -> {
                    return BookSliceResponse.builder()
                            .id(book.getId())
                            .title(book.getTitle())
                            .author(book.getAuthor())
                            .image(book.getImage())
                            .build();
                })
                .toList();
        return new SliceImpl<>(bookSliceResponseList, pageable, bookSlice.hasNext());
    }

    private boolean checkBookExist(String title, String author){
        return bookRepository.existsByTitleAndAuthor(title, author);
    }

    private Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() ->
                new BookException(ExceptionMessage.BOOK_NOT_FOUND));
    }

}

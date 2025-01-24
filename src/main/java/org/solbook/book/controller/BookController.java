package org.solbook.book.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.solbook.book.controller.request.BookRequest;
import org.solbook.book.service.BookService;
import org.solbook.common.response.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public JsonResult<?> createBook(@RequestBody @Valid BookRequest request) {
        bookService.saveBook(request);
        return JsonResult.successOf();
    }
}

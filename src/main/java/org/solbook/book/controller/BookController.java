package org.solbook.book.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.solbook.book.controller.request.BookRequest;
import org.solbook.book.controller.request.BookSliceRequest;
import org.solbook.book.controller.response.BookResponse;
import org.solbook.book.controller.response.BookSliceResponse;
import org.solbook.book.service.BookService;
import org.solbook.common.response.JsonResult;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{bookId}")
    public JsonResult<?> getBook(@PathVariable("bookId") Long bookId) {
        BookResponse bookResponse = bookService.getBook(bookId);
        return JsonResult.successOf(bookResponse);
    }

    @GetMapping
    public JsonResult<?> getBookSlice(@ModelAttribute BookSliceRequest bookSliceRequest) {
        Slice<BookSliceResponse> bookSliceResponse = bookService.getBookSliceSearch(bookSliceRequest);
        return JsonResult.successOf(bookSliceResponse);
    }


}

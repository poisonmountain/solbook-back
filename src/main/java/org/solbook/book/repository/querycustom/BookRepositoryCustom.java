package org.solbook.book.repository.querycustom;

import org.solbook.book.domain.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface BookRepositoryCustom {
    Slice<Book> findByTitleOrAuthorOrderByQuizCount(String keyword, Pageable pageable);
}

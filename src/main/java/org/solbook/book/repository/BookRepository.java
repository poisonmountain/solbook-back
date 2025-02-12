package org.solbook.book.repository;

import org.solbook.book.domain.Book;
import org.solbook.book.repository.querycustom.BookRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {
    boolean existsByTitleAndAuthor(String title, String author);
}

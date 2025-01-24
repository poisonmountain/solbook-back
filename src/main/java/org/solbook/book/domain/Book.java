package org.solbook.book.domain;

import jakarta.persistence.*;
import lombok.*;
import org.solbook.common.auditing.BaseEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"title", "author"}))
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String image;

    @Builder
    public Book(String title, String author, String image){
        this.title = title;
        this.author = author;
        this.image = image;
    }
}

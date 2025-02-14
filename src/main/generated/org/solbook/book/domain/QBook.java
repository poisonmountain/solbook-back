package org.solbook.book.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = -69906675L;

    public static final QBook book = new QBook("book");

    public final org.solbook.common.auditing.QBaseEntity _super = new org.solbook.common.auditing.QBaseEntity(this);

    public final StringPath author = createString("author");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final ListPath<org.solbook.quiz.domain.Quiz, org.solbook.quiz.domain.QQuiz> quizzes = this.<org.solbook.quiz.domain.Quiz, org.solbook.quiz.domain.QQuiz>createList("quizzes", org.solbook.quiz.domain.Quiz.class, org.solbook.quiz.domain.QQuiz.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QBook(String variable) {
        super(Book.class, forVariable(variable));
    }

    public QBook(Path<? extends Book> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook(PathMetadata metadata) {
        super(Book.class, metadata);
    }

}


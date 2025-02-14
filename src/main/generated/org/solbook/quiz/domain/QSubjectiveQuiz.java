package org.solbook.quiz.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubjectiveQuiz is a Querydsl query type for SubjectiveQuiz
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubjectiveQuiz extends EntityPathBase<SubjectiveQuiz> {

    private static final long serialVersionUID = -1494005199L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubjectiveQuiz subjectiveQuiz = new QSubjectiveQuiz("subjectiveQuiz");

    public final QQuiz _super;

    public final StringPath answer = createString("answer");

    // inherited
    public final org.solbook.book.domain.QBook book;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate;

    //inherited
    public final StringPath question;

    //inherited
    public final EnumPath<QuizType> quizType;

    public QSubjectiveQuiz(String variable) {
        this(SubjectiveQuiz.class, forVariable(variable), INITS);
    }

    public QSubjectiveQuiz(Path<? extends SubjectiveQuiz> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubjectiveQuiz(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubjectiveQuiz(PathMetadata metadata, PathInits inits) {
        this(SubjectiveQuiz.class, metadata, inits);
    }

    public QSubjectiveQuiz(Class<? extends SubjectiveQuiz> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QQuiz(type, metadata, inits);
        this.book = _super.book;
        this.createdDate = _super.createdDate;
        this.id = _super.id;
        this.modifiedDate = _super.modifiedDate;
        this.question = _super.question;
        this.quizType = _super.quizType;
    }

}


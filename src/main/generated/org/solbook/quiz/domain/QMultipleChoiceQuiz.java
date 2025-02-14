package org.solbook.quiz.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultipleChoiceQuiz is a Querydsl query type for MultipleChoiceQuiz
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMultipleChoiceQuiz extends EntityPathBase<MultipleChoiceQuiz> {

    private static final long serialVersionUID = -1924225194L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMultipleChoiceQuiz multipleChoiceQuiz = new QMultipleChoiceQuiz("multipleChoiceQuiz");

    public final QQuiz _super;

    public final NumberPath<Integer> answerOption = createNumber("answerOption", Integer.class);

    // inherited
    public final org.solbook.book.domain.QBook book;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate;

    public final ListPath<String, StringPath> options = this.<String, StringPath>createList("options", String.class, StringPath.class, PathInits.DIRECT2);

    //inherited
    public final StringPath question;

    //inherited
    public final EnumPath<QuizType> quizType;

    public QMultipleChoiceQuiz(String variable) {
        this(MultipleChoiceQuiz.class, forVariable(variable), INITS);
    }

    public QMultipleChoiceQuiz(Path<? extends MultipleChoiceQuiz> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMultipleChoiceQuiz(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMultipleChoiceQuiz(PathMetadata metadata, PathInits inits) {
        this(MultipleChoiceQuiz.class, metadata, inits);
    }

    public QMultipleChoiceQuiz(Class<? extends MultipleChoiceQuiz> type, PathMetadata metadata, PathInits inits) {
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


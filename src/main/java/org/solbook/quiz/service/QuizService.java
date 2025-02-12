package org.solbook.quiz.service;

import lombok.RequiredArgsConstructor;
import org.solbook.book.domain.Book;
import org.solbook.book.repository.BookRepository;
import org.solbook.common.exception.BookException;
import org.solbook.common.exception.ExceptionMessage;
import org.solbook.common.exception.QuizException;
import org.solbook.quiz.controller.request.MultipleChoiceQuizRequest;
import org.solbook.quiz.controller.request.SubjectiveQuizRequest;
import org.solbook.quiz.controller.response.QuizResponse;
import org.solbook.quiz.domain.MultipleChoiceQuiz;
import org.solbook.quiz.domain.Quiz;
import org.solbook.quiz.domain.QuizType;
import org.solbook.quiz.domain.SubjectiveQuiz;
import org.solbook.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final BookRepository bookRepository;

    @Transactional
    public void saveSubjectiveQuiz(SubjectiveQuizRequest request) {
        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new BookException(ExceptionMessage.BOOK_NOT_FOUND));

        Quiz quiz = new SubjectiveQuiz(request.question(), QuizType.SUBJECTIVE, request.answer());

        quiz.setBook(book);

        quizRepository.save(quiz);
    }

    @Transactional
    public void saveMultipleChoiceQuiz(MultipleChoiceQuizRequest request) {
        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new BookException(ExceptionMessage.BOOK_NOT_FOUND));

        Quiz quiz = new MultipleChoiceQuiz(request.question(), QuizType.MULTIPLE_CHOICE
                , request.options(), request.answerOption());

        quiz.setBook(book);

        quizRepository.save(quiz);
    }

    public QuizResponse getQuiz(Long quizId) {
        Quiz quiz = getQuizById(quizId);

        if (quiz instanceof SubjectiveQuiz subjectiveQuiz) {
            return QuizResponse.builder()
                    .question(subjectiveQuiz.getQuestion())
                    .quizType(subjectiveQuiz.getQuizType().getDescription())
                    .options(List.of())
                    .answer(subjectiveQuiz.getAnswer())
                    .build();
        }

        if (quiz instanceof MultipleChoiceQuiz multipleChoiceQuiz) {
            return QuizResponse.builder()
                    .question(multipleChoiceQuiz.getQuestion())
                    .quizType(multipleChoiceQuiz.getQuizType().getDescription())
                    .options(multipleChoiceQuiz.getOptions())
                    .answer(String.valueOf(multipleChoiceQuiz.getAnswerOption()))
                    .build();
        }

        throw new QuizException(ExceptionMessage.UNKNOWN_QUIZ_TYPE);
    }

    private Quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId).orElseThrow(() ->
                new QuizException(ExceptionMessage.QUIZ_NOT_FOUND));
    }

}

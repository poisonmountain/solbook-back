package org.solbook.quiz.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.solbook.common.response.JsonResult;
import org.solbook.quiz.controller.request.MultipleChoiceQuizRequest;
import org.solbook.quiz.controller.request.SubjectiveQuizRequest;
import org.solbook.quiz.controller.response.QuizResponse;
import org.solbook.quiz.service.QuizService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping("/subjective")
    public JsonResult<?> createSubjectiveQuiz(@RequestBody @Valid SubjectiveQuizRequest request) {
        quizService.saveSubjectiveQuiz(request);
        return JsonResult.successOf();
    }

    @PostMapping("/multiple-choice")
    public JsonResult<?> createMultipleChoiceQuiz(@RequestBody @Valid MultipleChoiceQuizRequest request) {
        quizService.saveMultipleChoiceQuiz(request);
        return JsonResult.successOf();
    }

    @GetMapping("/{quizId}")
    public JsonResult<?> getQuiz(@PathVariable("quizId") Long quizId) {
        QuizResponse quizResponse = quizService.getQuiz(quizId);
        return JsonResult.successOf(quizResponse);
    }
}

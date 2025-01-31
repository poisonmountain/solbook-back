package org.solbook.book.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record BookRequest(
                              @NotBlank(message = "제목은 공백 일 수 없습니다.")
                              String title,
                              @NotBlank(message = "저자는 공백 일 수 없습니다.")
                              String author,
                              @NotBlank(message = "이미지는 공백 일 수 없습니다.")
                              String image
) {

}

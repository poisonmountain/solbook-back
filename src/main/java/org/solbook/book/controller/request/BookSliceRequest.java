package org.solbook.book.controller.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
public record BookSliceRequest(
        String searchKeyword,
        @NotNull(message = "유효하지 않은 값입니다.")
        @Min(value = 0, message = "음수일 수 없습니다.")
        Integer page,
        @NotNull(message = "유효하지 않은 값입니다.")
        Integer size
) {
        @Override
        public Integer page() {
                return page;
        }

        @Override
        public Integer size() {
                return size;
        }
}

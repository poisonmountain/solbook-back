package org.solbook.book.controller.response;

import lombok.Builder;

@Builder
public record BookSliceResponse(
        Long id,
        String title,
        String author,
        String image
) {
}

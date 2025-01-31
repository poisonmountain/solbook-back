package org.solbook.book.controller.response;

import lombok.Builder;

@Builder
public record BookResponse(
        String title,
        String author,
        String image
) {
}

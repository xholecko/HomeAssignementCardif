package com.capgemini.holecko.home_assignment.utils;

import java.time.LocalDateTime;

public record ErrorDTO(
        String path,
        String message,
        int statusCode,
        LocalDateTime time,
        String stackTrace
) {
}
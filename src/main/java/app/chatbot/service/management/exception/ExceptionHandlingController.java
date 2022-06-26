package app.chatbot.service.management.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlingController {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiErrorResponse> handleApiExceptions(ApiException ex) {
        ApiErrorResponse response = new ApiErrorResponse(ex.getStatusCode(), ex.getMessage(), ex.getStatus().value());
        log.error(ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(response);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApiErrorResponse {

        private String statusCode;
        private String message;
        private int status;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestBodyErrorResponse {

        private int status;
        private String message;
        private Map<String, String> errors;

    }
}

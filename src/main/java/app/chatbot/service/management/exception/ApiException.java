package app.chatbot.service.management.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApiException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private HttpStatus status;
  private String statusCode;
  private String message;

  public ApiException(String statusCode, String message, Throwable cause) {
    super(message, cause);
    this.message = message;
    this.statusCode = statusCode;
  }

  public ApiException(HttpStatus status, String statusCode, String message, Throwable cause) {
    super(message, cause);
    this.status = status;
    this.message = message;
    this.statusCode = statusCode;
  }

  public HttpStatus getStatus() {
    return Optional.ofNullable(status).orElse(HttpStatus.BAD_REQUEST);
  }
}

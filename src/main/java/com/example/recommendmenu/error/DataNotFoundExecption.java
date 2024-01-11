package com.example.recommendmenu.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundExecption extends RuntimeException {

  public DataNotFoundExecption(String message) {
    super(message);
  }
}

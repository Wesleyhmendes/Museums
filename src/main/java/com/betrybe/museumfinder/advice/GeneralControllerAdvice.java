package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller advice.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Coordenadas inválidas.
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> invalidCoordinateException(InvalidCoordinateException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("Coordenada inválida!");
  }

  /**
   * Museu não encontrado.
   */
  @ExceptionHandler(MuseumNotFoundException.class)
  public ResponseEntity<String> museumNotFoundException(MuseumNotFoundException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Museu não encontrado!");
  }

  /**
   * Tratamento de erro genérico.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Erro interno!");
  }
}

package com.betrybe.museumfinder.exception;

/**
 * Invalid Coordinate Exception.
 */
public class InvalidCoordinateException extends RuntimeException {
  public InvalidCoordinateException() {
    super();
  }

  public InvalidCoordinateException(String message) {
    super(message);
  }
}

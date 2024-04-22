package com.betrybe.museumfinder.exception;

/**
 * Museum Not Found Exception.
 */
public class MuseumNotFoundException extends RuntimeException {
  public MuseumNotFoundException() {
    super();
  }

  public MuseumNotFoundException(String message) {
    super(message);
  }
}
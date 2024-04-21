package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.stereotype.Service;

@Service
public class MuseumService implements MuseumServiceInterface {
  MuseumFakeDatabase database;
  public MuseumService(MuseumFakeDatabase database) {
    this.database = database;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    Boolean isValid = CoordinateUtil.isCoordinateValid(museum.getCoordinate());

    if (!isValid) {
      throw new InvalidCoordinateException("Invalid coordinates!");
    } else {
      return database.saveMuseum(museum);
    }
  }

  Museum getClosestMuseum(Coordinate coordinate, Double maxDistance);

  Museum getMuseum(Long id);
}

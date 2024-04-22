package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Museum service.
 */
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

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    Boolean isValid = CoordinateUtil.isCoordinateValid(coordinate);

    if (!isValid) {
      throw new InvalidCoordinateException("Invalid coordinates!");
    }

    Optional<Museum> closestMuseumOptional = database.getClosestMuseum(coordinate, maxDistance);

    if (closestMuseumOptional.isPresent()) {
      return closestMuseumOptional.get();
    } else {
      throw new MuseumNotFoundException("No museum");
    }
  }

  public Museum getMuseum(Long id) {
    Optional<Museum> museum = database.getMuseum(id);

    if (museum.isPresent()) {
      return museum.get();
    } else {
      throw new MuseumNotFoundException("No museum");
    }
  };
}

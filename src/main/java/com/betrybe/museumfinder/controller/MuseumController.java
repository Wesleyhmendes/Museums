package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller.
 */
@RestController()
@RequestMapping("/museums")
public class MuseumController {
  MuseumServiceInterface service;

  @Autowired
  public MuseumController(MuseumServiceInterface museumService) {
    this.service = museumService;
  }

  /**
   * Post museum.
   */
  @PostMapping
  public ResponseEntity<Museum> createMuseum(@RequestBody MuseumDto museumDto) {
    Museum convertedDto = ModelDtoConverter.dtoToModel(museumDto);
    Museum newMuseum = service.createMuseum(convertedDto);

    return ResponseEntity.status(HttpStatus.CREATED).body(newMuseum);
  }

  /**
   * Get closest museum.
   */
  @GetMapping("/closest")
  public ResponseEntity<Museum> closestMuseum(
      @RequestParam(name = "lat") String latitudeStr,
      @RequestParam(name = "lng") String longitudeStr,
      @RequestParam(name = "max_dist_km") Double maxDistance) {
    double latitude = Double.parseDouble(latitudeStr);
    double longitude = Double.parseDouble(longitudeStr);

    Coordinate coordinate = new Coordinate(latitude, longitude);

    Museum closest = service.getClosestMuseum(coordinate, maxDistance);

    return ResponseEntity.status(HttpStatus.OK).body(closest);
  }

}

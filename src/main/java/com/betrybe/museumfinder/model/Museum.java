package com.betrybe.museumfinder.model;

/**
 * Museum class.
 */
public class Museum {
  Long id;
  String name;
  String description;
  String address;
  String collectionType;
  String subject;
  String url;
  Coordinate coordinate;
  Long legacyId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public java.lang.String getName() {
    return name;
  }

  public void setName(java.lang.String name) {
    this.name = name;
  }

  public java.lang.String getDescription() {
    return description;
  }

  public void setDescription(java.lang.String description) {
    this.description = description;
  }

  public java.lang.String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public java.lang.String getCollectionType() {
    return collectionType;
  }

  public void setCollectionType(java.lang.String collectionType) {
    this.collectionType = collectionType;
  }

  public java.lang.String getSubject() {
    return subject;
  }

  public void setSubject(java.lang.String subject) {
    this.subject = subject;
  }

  public java.lang.String getUrl() {
    return url;
  }

  public void setUrl(java.lang.String url) {
    this.url = url;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  public Long getLegacyId() {
    return legacyId;
  }

  public void setLegacyId(Long legacyId) {
    this.legacyId = legacyId;
  }
}

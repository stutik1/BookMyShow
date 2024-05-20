package com.stuti.model;

public class Theatres {
    private Long id ;
    private String name ;
    private Location location;

    public Theatres() {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Theatres(Long id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLocation(long location_id) {
    }
}

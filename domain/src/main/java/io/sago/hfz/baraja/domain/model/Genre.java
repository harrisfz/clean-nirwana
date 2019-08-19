package io.sago.hfz.baraja.domain.model;

public class Genre {

    private String name;

    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Genre(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
            "Genre{" +
                "name = '" + name + '\'' +
                ",id = '" + id + '\'' +
                "}";
    }
}
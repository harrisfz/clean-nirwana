package io.sago.hfz.baraja.domain.model.moviedetails;

public class GenresItem {

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

    public GenresItem(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
            "GenresItem{" +
                "name = '" + name + '\'' +
                ",id = '" + id + '\'' +
                "}";
    }
}
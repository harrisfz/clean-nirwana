package io.sago.hfz.baraja.domain.model;

public class BelongToCollection {

    private String backdropPath;

    private String name;

    private int id;

    private String posterPath;

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

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

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    @Override
    public String toString() {
        return
            "BelongToCollection{" +
                "backdrop_path = '" + backdropPath + '\'' +
                ",name = '" + name + '\'' +
                ",id = '" + id + '\'' +
                ",poster_path = '" + posterPath + '\'' +
                "}";
    }
}
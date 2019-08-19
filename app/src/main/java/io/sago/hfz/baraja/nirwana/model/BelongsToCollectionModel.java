package io.sago.hfz.baraja.nirwana.model;

/**
 * @author Harris Febryaontony Z (harris.febryantony@dana.id)
 * @version BelongsToCollectionModel, v 0.1 2019-08-20 03:34 by Harris Febryaontony Z
 */
public class BelongsToCollectionModel {

    private String backdropPath;

    private String name;

    private int id;

    private String posterPath;

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @Override
    public String toString() {
        return
            "BelongsToCollectionEntity{" +
                "backdrop_path = '" + backdropPath + '\'' +
                ",name = '" + name + '\'' +
                ",id = '" + id + '\'' +
                ",poster_path = '" + posterPath + '\'' +
                "}";
    }
}

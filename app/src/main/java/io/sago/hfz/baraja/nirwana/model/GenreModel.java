package io.sago.hfz.baraja.nirwana.model;

/**
 * @author Harris Febryaontony Z (harris.febryantony@dana.id)
 * @version GenreModel, v 0.1 2019-08-20 03:29 by Harris Febryaontony Z
 */
public class GenreModel {

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

    public GenreModel(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
            "GenresItemEntity{" +
                "name = '" + name + '\'' +
                ",id = '" + id + '\'' +
                "}";
    }
}

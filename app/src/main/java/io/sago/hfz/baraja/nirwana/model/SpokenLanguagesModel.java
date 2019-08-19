package io.sago.hfz.baraja.nirwana.model;

/**
 * @author Harris Febryaontony Z (harris.febryantony@dana.id)
 * @version SpokenLanguagesModel, v 0.1 2019-08-20 03:36 by Harris Febryaontony Z
 */
public class SpokenLanguagesModel {

    private String name;

    private String iso6391;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    @Override
    public String toString() {
        return
            "SpokenLanguageEntity{" +
                "name = '" + name + '\'' +
                ",iso_639_1 = '" + iso6391 + '\'' +
                "}";
    }
}

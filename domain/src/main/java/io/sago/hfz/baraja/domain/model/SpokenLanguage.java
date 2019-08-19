package io.sago.hfz.baraja.domain.model;

public class SpokenLanguage {

    private String name;

    private String iso6391;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getIso6391() {
        return iso6391;
    }

    @Override
    public String toString() {
        return
            "SpokenLanguage{" +
                "name = '" + name + '\'' +
                ",iso_639_1 = '" + iso6391 + '\'' +
                "}";
    }
}
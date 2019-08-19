package io.sago.hfz.baraja.nirwana.model;

/**
 * @author Harris Febryaontony Z (harris.febryantony@dana.id)
 * @version ProductionCountriesModel, v 0.1 2019-08-20 03:32 by Harris Febryaontony Z
 */
public class ProductionCountriesModel {

    private String iso31661;

    private String name;

    public void setIso31661(String iso31661) {
        this.iso31661 = iso31661;
    }

    public String getIso31661() {
        return iso31661;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
            "ProductionCountriesEntity{" +
                "iso_3166_1 = '" + iso31661 + '\'' +
                ",name = '" + name + '\'' +
                "}";
    }

}

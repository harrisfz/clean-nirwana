package io.sago.hfz.baraja.nirwana.model;

/**
 * @author Harris Febryaontony Z (harris.febryantony@dana.id)
 * @version ProductionCompaniesModel, v 0.1 2019-08-20 03:34 by Harris Febryaontony Z
 */
public class ProductionCompaniesModel {

    private String logoPath;

    private String name;

    private int id;

    private String originCountry;

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
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

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    @Override
    public String toString() {
        return
            "ProductionCompanyEntity{" +
                "logo_path = '" + logoPath + '\'' +
                ",name = '" + name + '\'' +
                ",id = '" + id + '\'' +
                ",origin_country = '" + originCountry + '\'' +
                "}";
    }
}

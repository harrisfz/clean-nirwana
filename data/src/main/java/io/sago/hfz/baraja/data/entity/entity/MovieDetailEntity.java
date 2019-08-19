package io.sago.hfz.baraja.data.entity.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

import io.sago.hfz.baraja.data.entity.entity.detail.BelongsToCollectionEntity;
import io.sago.hfz.baraja.data.entity.entity.detail.ProductionCompaniesEntity;
import io.sago.hfz.baraja.data.entity.entity.detail.ProductionCountriesEntity;
import io.sago.hfz.baraja.data.entity.entity.detail.SpokenLanguagesEntity;

@Generated("com.robohorse.robopojogenerator")
public class MovieDetailEntity {

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("video")
    private boolean video;

    @SerializedName("title")
    private String title;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("production_countries")
    private List<ProductionCountriesEntity> productionCountries;

    @SerializedName("id")
    private int id;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("overview")
    private String overview;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("spoken_languages")
    private List<SpokenLanguagesEntity> spokenLanguages;

    @SerializedName("production_companies")
    private List<ProductionCompaniesEntity> productionCompanies;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("belongs_to_collection")
    private BelongsToCollectionEntity belongsToCollection;

    @SerializedName("adult")
    private boolean adult;

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<ProductionCountriesEntity> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountriesEntity> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<SpokenLanguagesEntity> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguagesEntity> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public List<ProductionCompaniesEntity> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompaniesEntity> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public BelongsToCollectionEntity getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(BelongsToCollectionEntity belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    @Override
    public String toString() {
        return
            "MovieDetailEntity{" +
                "original_language = '" + originalLanguage + '\'' +
                ",video = '" + video + '\'' +
                ",title = '" + title + '\'' +
                ",backdrop_path = '" + backdropPath + '\'' +
                ",popularity = '" + popularity + '\'' +
                ",production_countries = '" + productionCountries + '\'' +
                ",id = '" + id + '\'' +
                ",vote_count = '" + voteCount + '\'' +
                ",overview = '" + overview + '\'' +
                ",original_title = '" + originalTitle + '\'' +
                ",poster_path = '" + posterPath + '\'' +
                ",spoken_languages = '" + spokenLanguages + '\'' +
                ",production_companies = '" + productionCompanies + '\'' +
                ",release_date = '" + releaseDate + '\'' +
                ",vote_average = '" + voteAverage + '\'' +
                ",belongs_to_collection = '" + belongsToCollection + '\'' +
                ",adult = '" + adult + '\'' +
                "}";
    }
}
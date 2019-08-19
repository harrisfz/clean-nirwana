package io.sago.hfz.baraja.nirwana.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieModel {

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("imdb_id")
    private String imdbId;

    @SerializedName("video")
    private boolean video;

    @SerializedName("title")
    private String title;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("revenue")
    private int revenue;

    @SerializedName("genres")
    private List<GenreModel> genres;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("production_countries")
    private List<ProductionCountriesModel> productionCountries;

    @SerializedName("id")
    private int id;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("budget")
    private int budget;

    @SerializedName("overview")
    private String overview;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("runtime")
    private int runtime;

    @SerializedName("poster_path")
    private Object posterPath;

    @SerializedName("spoken_languages")
    private List<SpokenLanguagesModel> spokenLanguages;

    @SerializedName("production_companies")
    private List<ProductionCompaniesModel> productionCompanies;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("belongs_to_collection")
    private CollectionModel belongsToCollection;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("status")
    private String status;

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
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

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
//
//	public void setGenres(List<GenreEntity> genres){
//		this.genres = genres;
//	}
//
//	public List<GenreEntity> getGenres(){
//		return genres;
//	}

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<ProductionCountriesModel> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountriesModel> productionCountries) {
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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
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

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Object getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(Object posterPath) {
        this.posterPath = posterPath;
    }

    public List<SpokenLanguagesModel> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguagesModel> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public List<ProductionCompaniesModel> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompaniesModel> productionCompanies) {
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

    public Object getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(CollectionModel belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MovieModel && this.id == ((MovieModel) obj).id;
    }

    @Override
    public String toString() {
        return
            "MovieModel{" +
                "original_language = '" + originalLanguage + '\'' +
                ",imdb_id = '" + imdbId + '\'' +
                ",video = '" + video + '\'' +
                ",title = '" + title + '\'' +
                ",backdrop_path = '" + backdropPath + '\'' +
                ",revenue = '" + revenue + '\'' +
//			",genres = '" + genres + '\'' +
                ",popularity = '" + popularity + '\'' +
//			",production_countries = '" + productionCountries + '\'' +
                ",id = '" + id + '\'' +
                ",vote_count = '" + voteCount + '\'' +
                ",budget = '" + budget + '\'' +
                ",overview = '" + overview + '\'' +
                ",original_title = '" + originalTitle + '\'' +
                ",runtime = '" + runtime + '\'' +
                ",poster_path = '" + posterPath + '\'' +
//			",spoken_languages = '" + spokenLanguages + '\'' +
//			",production_companies = '" + productionCompanies + '\'' +
                ",release_date = '" + releaseDate + '\'' +
                ",vote_average = '" + voteAverage + '\'' +
                ",belongs_to_collection = '" + belongsToCollection + '\'' +
                ",tagline = '" + tagline + '\'' +
                ",adult = '" + adult + '\'' +
                ",homepage = '" + homepage + '\'' +
                ",status = '" + status + '\'' +
                "}";
    }
}
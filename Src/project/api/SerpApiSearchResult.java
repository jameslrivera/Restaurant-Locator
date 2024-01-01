package project.api;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/**
 * This class respresents a search result from the SerpAPI service.
 */
public class SerpApiSearchResult {

    /**
     * This field represents the result contained within the search result.
     */
    @SerializedName("place_results")
    private PlaceResult placeResult;

    /**
     * This method returns the place result contained within the search result.
     *
     * @return the place result contained within the search result.
     */
    public PlaceResult getPlaceResults() {
        return placeResult;
    }

    /**
     * This method sets the place result contained within the search result.
     *
     * @param placeResult the place result to set.
     */
    public void setPlaceResults(PlaceResult placeResult) {
        this.placeResult = placeResult;
    }

    /**
     * This class represents a place result contained within a SerpApi search result.
     */
    public static class PlaceResult {
        @SerializedName("title")
        private String title;
        @SerializedName("thumbnail")
        private String thumbnail;
        @SerializedName("rating")
        private double rating;
        @SerializedName("reviews")
        private int reviews;
        @SerializedName("price")
        private String price;
        @SerializedName("type")
        private String[] type;
        @SerializedName("description")
        private String description;

        /**
         * This method returns the title of the place result.
         *
         * @return the title of the place result.
         */
        public String getTitle() {
            return title;
        }

        /**
         * This method sets the title of the place result.
         *
         * @param title the title to set.
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * This method returns the thumbnail image URL of the place result.
         *
         * @return the thumbnail image URL of the place result.
         */
        public String getThumbnail() {
            return thumbnail;
        }

        /**
         * This method sets the thumbnail image URL of the place result.
         *
         * @param thumbnail the thumbnail image URL to set.
         */
        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        /**
         * This method returns the rating of the place result.
         *
         * @return the rating of the place result.
         */
        public double getRating() {
            return rating;
        }

        /**
         * This method sets the rating of the place result.
         *
         * @param rating the rating to set.
         */
        public void setRating(double rating) {
            this.rating = rating;
        }

        /**
         * This method returns the number of reviews for the place result.
         *
         * @return the number of reviews for the place result.
         */
        public int getReviews() {
            return reviews;
        }

        /**
         * Sets the number of reviews for this place result.
         *
         * @param reviews the number of reviews for this place result.
         */
        public void setReviews(int reviews) {
            this.reviews = reviews;
        }

        /**
         * Returns the price of this place result.
         *
         * @return the price of this place result.
         */
        public String getPrice() {
            return price;
        }

        /**
         * Sets the price of this place result.
         *
         * @param price the price of this place result.
         */
        public void setPrice(String price) {
            this.price = price;
        }

        /**
         * Returns the description of this place result.
         *
         * @return the description of this place result.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the description of this place result.
         *
         * @param description the description of this place result.
         */
        public void setDescription(String description) {
            this.description = description;
        }

    }

}

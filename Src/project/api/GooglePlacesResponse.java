package project.api;

import java.util.List;

/**
 * This class is used to take the google api response and list the restaurants in the city
 * specified.
 *
 */

public class GooglePlacesResponse {

    private List<GooglePlace> results;

/**
 * Getter for the list of google api call restaurants.
 * @return List a list of restaurants
 */

    public List<GooglePlace> getResults() {
        return results;
    } // getResults

    /**
     * Setter for the list of google api call restaurants.
     * @param results
     */

    public void setResults(List<GooglePlace> results) {
        this.results = results;
    } // setResults

} // GooglePlaceResponse

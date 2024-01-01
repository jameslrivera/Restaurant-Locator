package project.api;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * This class is used to create an object of the response that is recieved from the SerpApi call.
 *
 */

class SerpApiResponse {

    @SerializedName("images_results")
    private List<ImageResult> imagesResults;


    /**
     * Getter for images results.
     * @return list of image results
     */

    public List<ImageResult> getImagesResults() {
        return imagesResults;
    } // getImageResults

/**
 * Setter for the image results.
 * @param imagesResults
 */

    public void setImagesResults(List<ImageResult> imagesResults) {
        this.imagesResults = imagesResults;
    } // setImageResults

} // SerpApitResponse

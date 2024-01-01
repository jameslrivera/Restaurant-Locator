package project.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;


/**
 * This class is used to process the restaurant response from SerpApi.
 *
 *
 */

public class RestaurantService {

    // SerpAPI Key
    private static final String SERP_API_KEY =
        "545733c99a4113d14f96aecdf11b9fdffb8831e9e6630ba4ab56a528b2f06d6c";

    // Base URL for SerpAPI
    private static final String SERP_API_BASE_URL = "https://serpapi.com/search.json";

    // HttpClient
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();
/**
 * This method uses the HTTP response from SerpApi to create a parsed api response String.
 * @param restaurantName
 * @return String
 *
 */

    public static String fetchRestaurantImage(String restaurantName)
        throws IOException, InterruptedException {
        // Construct the SerpAPI query URL
        String serpapiQuery =
            SERP_API_BASE_URL + "?q=" + restaurantName + "&tbm=isch&key=" + SERP_API_KEY;

        // Create an HTTP request to SerpAPI
        HttpRequest serpapiRequest = HttpRequest.newBuilder()
                .uri(URI.create(serpapiQuery))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // Send the HTTP request and get the response
        HttpResponse<String> serpapiResponse =
            HTTP_CLIENT.send(serpapiRequest, HttpResponse.BodyHandlers.ofString());

        // Extract the image URL from the SerpAPI response
        return parseImageUrlFromSerpApiResponse(serpapiResponse.body());
    } // fetchRestaurantImage

    /**
     * This method parses the image url from the SerpApi response.
     * @return String
     * @param jsonResponse
     *
     */

    private static String parseImageUrlFromSerpApiResponse(String jsonResponse) {
        try {
            // Find the start and end indices of the image URL within the JSON response.
            int startIndex = jsonResponse.indexOf("\"original\":\"") + "\"original\":\"".length();
            int endIndex = jsonResponse.indexOf("\"", startIndex);

            if (startIndex >= 0 && endIndex > startIndex) {
                return jsonResponse.substring(startIndex, endIndex);
            } // if
        } catch (Exception e) {
            e.printStackTrace();
        } // catch
        return null;
    } // parseImageUrlFrom SerpApiResponse
} // RestaurantService

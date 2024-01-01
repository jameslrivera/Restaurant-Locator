package project.api;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.lang.Exception;
import javafx.scene.layout.BorderPane;
import java.io.InputStream;
import java.net.URI;

import java.net.http.HttpClient;
import javafx.scene.text.TextAlignment;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;


import javafx.scene.layout.GridPane;
import java.io.UnsupportedEncodingException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.net.URL;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ComboBox;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;
import javafx.scene.control.Alert;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;
import javafx.scene.control.Alert;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.FileInputStream;
import java.nio.file.StandardCopyOption;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import java.util.stream.Collectors;
import javafx.geometry.Insets;


import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

/**
 * This app uses google's map api and serpapi's search api to find restaurants in a specified US
 * city then return a picture of the restaurant and information about it.
 *
 *
 */

public class ApiApp extends Application {



    private static final String GOOGLE_API_KEY = "AIzaSyCYL6ZHyMxeLxwYEADzrbs7oOI1SD-lRCY";
    private static final String SERPAPI_API_KEY =
        "545733c99a4113d14f96aecdf11b9fdffb8831e9e6630ba4ab56a528b2f06d6c";

    private HttpClient httpClient = HttpClient.newHttpClient();
    private Gson gson = new Gson();

    Stage stage;
    VBox root;
    Scene scene1, scene2, scene3; // Scenes for each screen

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        // Screen 1: User Input
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Label welcomeLabel = new Label("Hello, welcome to the restaurant locator app");
        welcomeLabel.setStyle("-fx-font-size: 18px;"); // Adjust font size if needed
        VBox.setMargin(welcomeLabel, new Insets(0, 0, 10, 0)); // Add top margin for spacing


        Label instructionLabel =
            new Label("Please enter the US City you want to find restaurants in:");
        TextField cityInputField = new TextField();
        cityInputField.setMaxWidth(200);
        Button submitButton = new Button("Search");


        submitButton.setOnAction(event -> {
            String city = cityInputField.getText();
            searchRestaurants(city); // Updated to search for restaurants
        });
        root.getChildren().addAll(welcomeLabel, instructionLabel, cityInputField, submitButton);
        scene1 = new Scene(root, 640, 480);

        // Set initial scene
        stage.setTitle("Restaurant Locator");
        stage.setScene(scene1);
        stage.show();
    } // start
/**
 * This method searches for the restaurants using the location specified and google maps api.
 * @param location
 */

    private void searchRestaurants(String location) {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json";
        String parameters =
            "?query=restaurants+in+" + URLEncoder.encode(location, StandardCharsets.UTF_8)
            + "&key=" + GOOGLE_API_KEY;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endpoint + parameters))
            .GET()
            .build();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(responseBody -> {
                List<Restaurant> restaurants = parseRestaurants(responseBody);
                Platform.runLater(() -> stage.setScene(createRestaurantListScene(restaurants)));
            })
            .exceptionally(e -> {
                e.printStackTrace();
                return null;
            });
    } // searchRestaurants

/**
 * This method takes the google response and creates a new button obect for each of the restaunts
 * in the response.
 * @param responseBody
 * @return Restaurant
 **/

    private List<Restaurant> parseRestaurants(String responseBody) {
        GooglePlacesResponse response = gson.fromJson(responseBody, GooglePlacesResponse.class);
        return response.getResults().stream()
            .map(place ->
            new Restaurant(place.getName(), place.getFormattedAddress(), place.getPlaceId()))
            .collect(Collectors.toList());
    } // parseRestaurants

    /**
     *This method takes the google response and creates a new button obect for each of the restaunts
     * in the response.
     * @param restaurants
     * @return Scene
     */

    private Scene createRestaurantListScene(List<Restaurant> restaurants) {
        ScrollPane scrollPane = new ScrollPane();
        BorderPane borderPane = new BorderPane();
        TilePane tilePane = new TilePane();
        tilePane.setVgap(8);
        tilePane.setHgap(8);
        tilePane.setPadding(new Insets(8));
        tilePane.setPrefColumns(3);




        for (Restaurant restaurant : restaurants) {
            Button restaurantButton = new Button(restaurant.getName());
            restaurantButton.setPrefWidth(150);

            restaurantButton.setOnAction(event -> fetchImageForRestaurant(restaurant));

            tilePane.getChildren().add(restaurantButton);
        } // for

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> stage.setScene(scene1)); // Go back to the first scene


        BorderPane.setAlignment(backButton, Pos.BOTTOM_LEFT);
        borderPane.setCenter(tilePane);
        borderPane.setBottom(backButton);
        return scene2 = new Scene(borderPane, 640, 400);
    } // createRestaurantListScene

/**
   * This method takes the restaurants name and address and adds them to the scene.
   * @param restaurant
   *
   */

    private void showRestaurantDetails(Restaurant restaurant) {
        VBox detailRoot = new VBox(10); // VBox with spacing
        detailRoot.setPadding(new Insets(10)); // Padding around the VBox

        Label nameLabel = new Label("Name: " + restaurant.getName());
        Label addressLabel = new Label("Address: " + restaurant.getAddress());


        Button backButton = new Button("Back");
        backButton.setOnAction(event -> stage.setScene(scene2)); // Go back to the list scene

        detailRoot.getChildren().addAll(nameLabel, addressLabel, backButton);

        Scene detailScene = new Scene(detailRoot, 640, 480);
        Platform.runLater(() -> stage.setScene(detailScene));
    } // showRestaurantDetails

/**
 * This method updates the scene with restaurant name, address, and a image of the restaurant.
 * @param restaurant
 * @param imageUrl
 *
 */

    private void updateRestaurantDetailsScene(Restaurant restaurant, String imageUrl) {
        VBox detailsRoot = new VBox(10);
        detailsRoot.setPadding(new Insets(10));

        Label nameLabel = new Label("Name: " + restaurant.getName());
        Label addressLabel = new Label("Address: " + restaurant.getAddress());

        if (imageUrl != null && !imageUrl.isEmpty()) {
            Image image = new Image(imageUrl, true);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(350);
            imageView.setFitHeight(250);

            detailsRoot.getChildren().addAll(nameLabel, addressLabel, imageView);
        } else {
            detailsRoot.getChildren().addAll(nameLabel, addressLabel);
            Label missingImageLabel = new Label("Image not available");
            detailsRoot.getChildren().add(missingImageLabel);
        } // else

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> stage.setScene(scene2)); // Scene with restaurant list

        detailsRoot.getChildren().add(backButton);
        Scene detailScene = new Scene(detailsRoot, 540, 380);
        Platform.runLater(() -> stage.setScene(detailScene));




    } // updateRestaurantDetailsScene

    /**
     *  This method sends the HTTP request to the serpapi server and returns the response.
     * @param restaurantName
     * @return CompletableFuture
     */

    private CompletableFuture<String> fetchRestaurantImage(String restaurantName) {
        String encodedQuery = URLEncoder.encode(restaurantName, StandardCharsets.UTF_8);

        String serpApiUrl =
            "https://serpapi.com/search.json?q=" + encodedQuery +
            "&tbm=isch&key=" + SERPAPI_API_KEY;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(serpApiUrl))
            .GET()
            .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenApply(this::parseImageUrlFromSerpApiResponse)
            .exceptionally(ex -> {
                ex.printStackTrace();
                return null;
            });

    } // fetchRestaurantImage

    /**
     * This method allows use to handle errors and print them to the screen.
     * @param title
     * @param content
     */

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    } // alert

/**
 * Parses jsonResponse from the SerpApi.
 * @param jsonResponse
 * @return String
 */

    private String parseImageUrlFromSerpApiResponse(String jsonResponse) {
        try {
            SerpApiResponse response = gson.fromJson(jsonResponse, SerpApiResponse.class);
            if (response.getImagesResults() != null && !response.getImagesResults().isEmpty()) {
                return response.getImagesResults().get(0).getOriginal();
            } // try
        } catch (Exception e) {
            e.printStackTrace();
        } // catch
        return null;
    } // parseImageUrlFromSerpApiResponse

    /**
     * This method takes the image url and restraunt object and updates the scene.
     * @param restaurant
     */
    private void fetchImageForRestaurant(Restaurant restaurant) {
        fetchRestaurantImage(restaurant.getName())
            .thenAccept(imageUrl -> {
                if (imageUrl != null && !imageUrl.isEmpty()) {
                    Platform.runLater(() -> updateRestaurantDetailsScene(restaurant, imageUrl));
                } else {
                    String errorMessage =
                        "The restaurant you are looking for can't be found right now. Try again.";
                    Platform.runLater(() -> showAlert("Error", errorMessage));

                   //System.err.println("Invalid or empty image URL");
                } // else
            });
    } // fetchImageForRestaurant
} // apiapp

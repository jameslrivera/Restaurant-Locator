package project.api;


/**
 * This class is used to create a restraunt object with information about its name and address
 * that will be displayed in the application.
 *
 */

public class Restaurant {
    private String name;
    private String address;
    private String placeId;

/**
 * Constructor for each instance of a restaurant.
 * @param name
 * @param address
 * @param placeId
 */

    public Restaurant(String name, String address, String placeId) {
        this.name = name;
        this.address = address;
        this.placeId = placeId;
    } // Restaurant

    /**
     * Getter for the name of the restaurant.
     * @return String
     */

    public String getName() {
        return name;
    } // getName

    /**
     * Getter for the address of the restaurant.
     * @return String
     */

    public String getAddress() {
        return address;
    } // getAddress

    /**
     * Getter for the placeId of the restaurant.
     * @return String
     */

    public String getPlaceId() {
        return placeId;
    } // getPlaceId

} // Restaurant

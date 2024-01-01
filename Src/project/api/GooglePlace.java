package project.api;

import com.google.gson.annotations.SerializedName;

/**
 *  This class is used to create a object that contains the name and
 * and address for each of the restaurant.
 *
 *
 */

public class GooglePlace {
    private String name;

    // private String formattedAddress;
    @SerializedName("formatted_address")
    private String formattedAddress;

    private String placeId;
/**
 * Getter for the restraunt name.
 * @return String
 */

    public String getName() {
        return name;
    } // getName

    /**
 * Setter for the restraunt name.
 * @param name
 */

    public void setName(String name) {
        this.name = name;
    } // setName

/**
 * Getter for the restraunt name.
 * @return String
 */

    public String getFormattedAddress() {
        return formattedAddress;
    } // getFormattedAddress


    /**
 * Setter for the address.
 * @param formattedAddress
 */

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    } // setFormattedAddress

/**
 * Getter for the place id.
 * @return String
 */

    public String getPlaceId () {
        return placeId;
    } // getPlace_id

/**
 * Setter for the place idea of each restaurant.
 * @param placeId
 */

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    } // setPlaceId
} // googlePlace

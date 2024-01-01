package project.api;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;


/** Container Class for loader. */
public class ImageLoader extends VBox {
    /** The container for the url textfield and the load image button. */
    HBox urlLayer;
    TextField urlField;
    Button loadImage;

    /** The container for the loaded image. */
    ImageView imgView;


    /** A default image which loads when the application starts. */
    protected static final String DEFAULT_IMG =
        "http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png";


    /** Default height and width for Images. */
    protected static final int DEF_HEIGHT = 100;

    /** Default height and width for Images. */
    protected static final int DEF_WIDTH = 100;

    /**
     * Default Constructore for ImageLoader Class.
     */
    public ImageLoader() {
        super();
        // Load the default image with the default dimensions
        Image img = new Image(DEFAULT_IMG, DEF_HEIGHT, DEF_WIDTH, false, false);

        // Add the image to its container and preserve the aspect ratio if resized
        imgView = new ImageView(img);
        imgView.setPreserveRatio(true);

        // create url textfield and load image button
        urlField = new TextField(DEFAULT_IMG);
        loadImage = new Button("Load Image");

        // set event handler for button
        loadImage.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    loadImage();
                } // handle
            }); // setOnAction

        // add textfield and button to the url layer
        urlLayer = new HBox(urlField, loadImage);
        urlLayer.setHgrow(urlField, Priority.ALWAYS);
        this.getChildren().addAll(urlLayer, imgView);
    } // ImageLoader

    /**
     * Overridden Constructor for ImageLoader Class.
     * @param imgLink the String URL source of the image.
     */
    public ImageLoader(String imgLink) {
        super();
        // Load the default image with the default dimensions
        Image img = new Image(imgLink, DEF_HEIGHT, DEF_WIDTH, false, false);

        // Add the image to its container and preserve the aspect ratio if resized
        imgView = new ImageView(img);
        imgView.setPreserveRatio(true);

        urlField = new TextField(imgLink);
        loadImage = new Button("Load Image");

        // set event handler for button
        loadImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                loadImage();
            } // handle
        }); // setOnAction

        // add textfield and button to the url layer
        urlLayer = new HBox(urlField, loadImage);
        urlLayer.setHgrow(urlField, Priority.ALWAYS);
        this.getChildren().addAll(urlLayer, imgView);
    } // ImageLoader


    /**
     * Loads the image if a valid url is given.
     */
    public void loadImage() {

        try {
            Image newImg = new Image(urlField.getText(), DEF_HEIGHT, DEF_WIDTH, false, false);
            imgView.setImage(newImg);
        } catch (IllegalArgumentException iae) {
            System.out.println("The supplied URL is invalid");
        } // try

    } // loadImage

}

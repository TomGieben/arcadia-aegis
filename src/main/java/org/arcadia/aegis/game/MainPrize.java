package org.arcadia.aegis.game;

public class MainPrize {
    private String imagePath;

    /*
    * Constructor
    *
    * @param imagePath The image path of the main prize
    */
    public MainPrize(String imagePath) {
        this.imagePath = imagePath;
    }

    /*
    * Get the image path of the main prize
    *
    * @return String The image path of the main prize
    */
    public String getImagePath() {
        return imagePath;
    }
}

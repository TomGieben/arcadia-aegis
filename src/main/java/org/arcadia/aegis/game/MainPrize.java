package org.arcadia.aegis.game;

import org.arcadia.aegis.enums.PrizeType;

public class MainPrize extends Prize {
    private String imagePath;

    /*
    * Constructor
    *
    * @param imagePath The image path of the main prize
    */
    public MainPrize(String imagePath) {
        super(PrizeType.MAINPRIZE, "MainPrize");
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

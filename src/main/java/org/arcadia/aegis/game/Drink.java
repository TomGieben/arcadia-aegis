package org.arcadia.aegis.game;

import org.arcadia.aegis.enums.InfluenceType;

public class Drink {
    private String name;
    private float influenceAmount;
    private InfluenceType influenceType;
    private float price;
    private String imagePath;

    /*
    * Constructor
    *
    * @param name The name of the drink
    * @param influenceAmount The amount of influence the drink has
    * @param influenceType The type of influence the drink has
    * @param price The price of the drink
    */
    public Drink(String name, float influenceAmount, InfluenceType influenceType, float price) {
        this.name = name;
        this.influenceAmount = influenceAmount;
        this.influenceType = influenceType;
        this.price = price;
    }

    /*
    * Constructor
    *
    * @param name The name of the drink
    * @param influenceAmount The amount of influence the drink has
    * @param influenceType The type of influence the drink has
    * @param price The price of the drink
    * @param imagePath The image path of the drink
    */
    public InfluenceType getType() {
        return this.influenceType;
    }

    /*
    * Get the price of the drink
    *
    * @return float The price of the drink
    */
    public float getPrice() {
        return this.price;
    }

    /*
    * Get the influence amount of the drink
    *
    * @return float The influence amount of the drink
    */
    public float getInfluenceAmount() {
        return this.influenceAmount;
    }

    /*
    * Get the name of the drink
    *
    * @return String The name of the drink
    */
    public String getName() {
        return this.name;
    }

    /*
    * Get the image path of the drink
    *
    * @return String The image path of the drink
    */
    public String getImagePath() {
        return imagePath;
    }
}

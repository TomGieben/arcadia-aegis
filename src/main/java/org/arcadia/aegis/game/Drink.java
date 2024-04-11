package org.arcadia.aegis.game;

import org.arcadia.aegis.enums.InfluenceType;

public class Drink {
    private String name;
    private float influenceAmount;
    private InfluenceType influenceType;
    private float price;
    private String imagePath;

    public Drink(String name, float influenceAmount, InfluenceType influenceType, float price) {
        this.name = name;
        this.influenceAmount = influenceAmount;
        this.influenceType = influenceType;
        this.price = price;
    }

    public InfluenceType getType() {
        return this.influenceType;
    }

    public float getPrice() {
        return this.price;
    }

    public float getInfluenceAmount() {
        return this.influenceAmount;
    }

    public String getName() {
        return this.name;
    }

    public String getImagePath() {
        return imagePath;
    }
}

package org.arcadia.aegis.game;

import java.util.ArrayList;

public class Minigame  {
    private String name;
    private String slug;
    private float price;
    private String imagePath;
    private ArrayList<Prize> prizes;

    /*
    * Constructor
    *
    * @param name The name of the minigame
    * @param price The price of the minigame
    * @param imagePath The image path of the minigame
    */
    public Minigame(String name, float price, String imagePath) {
        this.name = name;
        this.slug = name.toLowerCase().replace(" ", "-");
        this.price = price;
        this.imagePath = imagePath;
    }

    /*
    * Set the prizes of the minigame
    *
    * @param prizes The prizes of the minigame
    * @return void
    */
    public float getPrice() {
        return this.price;
    }

    /*
    * Get the price of the minigame
    *
    * @return float The price of the minigame
    */
    public ArrayList<Prize> getPrizes() {
        return this.prizes;
    }

    /*
    * Get the image path of the minigame
    *
    * @return String The image path of the minigame
    */
    public String getImagePath() {
        return this.imagePath;
    }

    /*
    * Add a prize to the minigame
    *
    * @param prize The prize to add
    * @return void
    */
    public void addPrize(Prize prize) {
        this.prizes.add(prize);
    }

    /*
    * Get a prize from the minigame
    *
    * @param index The index of the prize
    * @return Prize The prize
    */
    public Prize getPrize(int index) {
        return this.prizes.get(index);
    }

    public void start() {
        // Start the minigame
    }

    public void end() {
        // End the minigame
    }
}

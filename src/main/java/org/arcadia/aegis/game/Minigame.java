package org.arcadia.aegis.game;

import org.arcadia.aegis.App;

import java.util.ArrayList;

public class Minigame  {
    private App app;
    private String name;
    private float price;
    private String imagePath;
    private int sceneIndex;
    private ArrayList<Prize> prizes;

    /*
    * Constructor
    *
    * @param name The name of the minigame
    * @param price The price of the minigame
    * @param imagePath The image path of the minigame
    */
    public Minigame(App app, String name, float price, String imagePath, int sceneIndex) {
        this.app = app;
        this.name = name;
        this.sceneIndex = sceneIndex;
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
     * Get the name of the minigame
     *
     * @return String The name of the minigame
     */
    public String getName() {
        return this.name;
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
        this.app.setActiveScene(this.sceneIndex);
    }

    public void end() {
        // End the minigame
    }
}

package org.arcadia.aegis.objects;

import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.Node;
import org.arcadia.aegis.inventory.Inventory;

import java.util.List;
import java.util.Optional;

public class Bar implements Collided {
    private Inventory inventory;
    private String imagePath;
    private int locationX;
    private int locationY;

    /*
    * Constructor
    *
    * @param imagePath The path to the image of the bar
    * @param x The x-coordinate of the bar
    * @param y The y-coordinate of the bar
    */
    public Bar(String imagePath, int x, int y) {
        this.imagePath = imagePath;
        this.locationX = x;
        this.locationY = y;
    }

    /*
    * Constructor
    *
    * @param imagePath The path to the image of the bar
    * @param x The x-coordinate of the bar
    * @param y The y-coordinate of the bar
    * @param inventory The inventory of the bar
    */
    public Bar(String imagePath, int x, int y, Inventory inventory) {
        this.imagePath = imagePath;
        this.locationX = x;
        this.locationY = y;
        this.inventory = inventory;
    }

    /*
    * Get the inventory of the bar
    *
    * @return Inventory The inventory of the bar
    */
    public Inventory getInventory() {
        return inventory;
    }

    /*
    * Get the path to the image of the bar
    *
    * @return String The path to the image of the bar
    */
    public String getImagePath() {
        return imagePath;
    }

    /*
    * Get the x-coordinate of the bar
    *
    * @return int The x-coordinate of the bar
    */
    public int getLocationX() {
        return locationX;
    }

    /*
    * Get the y-coordinate of the bar
    *
    * @return int The y-coordinate of the bar
    */
    public int getLocationY() {
        return locationY;
    }

    /*
    * Set the inventory of the bar
    *
    * @param inventory The inventory of the bar
    * @return void
    */
    public void viewBar(){
        return;
    }

    /*
    * Set the path to the image of the bar
    *
    * @param imagePath The path to the image of the bar
    * @return void
    */
    @Override
    public void onCollision(List<Collider> list) {

    }

    /*
    * Set the x-coordinate of the bar
    *
    * @param x The x-coordinate of the bar
    * @return void
    */
    @Override
    public Optional<? extends Node> getNode() {
        return Optional.empty();
    }
}


package org.arcadia.aegis.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import javafx.scene.Node;
import org.arcadia.aegis.App;
import org.arcadia.aegis.enums.InfluenceType;
import org.arcadia.aegis.game.Drink;
import org.arcadia.aegis.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bar extends DynamicSpriteEntity implements Collided {
    private Inventory inventory;
    private String imagePath;
    private App app;
    private int sceneIndex = 5;

    /*
    * Constructor
    *
    * @param imagePath The path to the image of the bar
    * @param x The x-coordinate of the bar
    * @param y The y-coordinate of the bar
     * @param inventory The inventory of the bar
    */
    public Bar(String imagePath, Coordinate2D location, App app) {
        super(imagePath, location, new Size(200, 140));

        this.imagePath = imagePath;
        this.inventory = new Inventory();
        this.app = app;

        this.initDrinks();
    }

    /*
    * Constructor
    *
    * @param imagePath The path to the image of the bar
    * @param x The x-coordinate of the bar
    * @param y The y-coordinate of the bar
    * @param inventory The inventory of the bar
    */
    public Bar(String imagePath, Coordinate2D location, App app, Inventory inventory) {
        super(imagePath, location, new Size(200, 140));

        this.imagePath = imagePath;
        this.inventory = new Inventory();
        this.app = app;

        this.initDrinks();
    }

    private void initDrinks() {
        List<Drink> drinks = new ArrayList<>();
        drinks.add(new Drink("Cola", 250, InfluenceType.POSITIVE, 2.5f, "images/drinks/cola.png"));
        drinks.add(new Drink("Beer", 250, InfluenceType.NEGATIVE, 2.5f, "images/drinks/beer.png"));
        drinks.add(new Drink("Orange Juice", 250, InfluenceType.POSITIVE, 2.5f, "images/drinks/orange_juice.png"));

        for (Drink drink : drinks) {
            this.getInventory().store(drink);
        }
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
    * Set the inventory of the bar
    *
    * @param inventory The inventory of the bar
    * @return void
    */
    public void viewBar(){
        this.app.setActiveScene(this.sceneIndex);
    }

    /*
    * Set the path to the image of the bar
    *
    * @param imagePath The path to the image of the bar
    * @return void
    */
    @Override
    public void onCollision(List<Collider> list) {
        this.app.getPlayer().setSpeed(0);
        this.viewBar();
    }
}


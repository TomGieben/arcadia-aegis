package org.arcadia.aegis.objects;

import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.Node;
import org.arcadia.aegis.enums.InfluenceType;
import org.arcadia.aegis.game.Wallet;
import org.arcadia.aegis.inventory.Inventory;

import java.util.Optional;

public class Player implements Collider {

    private String name;
    private Wallet wallet;
    private Inventory inventory;
    private String avatarPath;
    private int locationX;
    private int locationY;
    private float influence;

    /*
    * Constructor
    *
    * @param name The name of the player
    * @param avatarPath The path to the avatar of the player
    * @param wallet The wallet of the player
    * @param inventory The inventory of the player
    */
    public Player(String name, String avatarPath) {
        this.name = name;
        this.avatarPath = avatarPath;
        this.wallet = new Wallet(0);
        this.inventory = new Inventory();
    }

    /*
    * Constructor
    *
    * @param name The name of the player
    * @param avatarPath The path to the avatar of the player
    * @param wallet The wallet of the player
    * @param inventory The inventory of the player
    */
    public Player(String name, String avatarPath, Wallet wallet, Inventory inventory) {
        this.name = name;
        this.avatarPath = avatarPath;
        this.wallet = wallet;
        this.inventory = inventory;
    }

    /*
    * Set the location of the player
    *
    * @param x The x-coordinate of the player
    * @param y The y-coordinate of the player
    * @return void
    */
    public void setLocation(int x, int y) {
        this.setLocationX(x);
        this.setLocationY(y);
    }

    /*
    * Set the x-coordinate of the player
    *
    * @param locationX The x-coordinate of the player
    * @return void
    */
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    /*
    * Set the y-coordinate of the player
    *
    * @param locationY The y-coordinate of the player
    * @return void
    */
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    /*
    * Set the wallet of the player
    *
    * @param wallet The wallet of the player
    * @return void
    */
    public int getLocationX() {
        return locationX;
    }

    /*
    * Get the x-coordinate of the player
    *
    * @return int The x-coordinate of the player
    */
    public int getLocationY() {
        return locationY;
    }

    /*
    * Get the y-coordinate of the player
    *
    * @return int The y-coordinate of the player
    */
    public String getAvatarPath() {
        return avatarPath;
    }

    /*
    * Get the path to the avatar of the player
    *
    * @return String The path to the avatar of the player
    */
    public Inventory getInventory() {
        return inventory;
    }

    /*
    * Get the inventory of the player
    *
    * @return Inventory The inventory of the player
    */
    public Wallet getWallet() {
        return wallet;
    }

    /*
    * Get the wallet of the player
    *
    * @return Wallet The wallet of the player
    */
    public float updateInfluence(float influence, InfluenceType influenceType) {
        if (influenceType == InfluenceType.NEGATIVE) {
            this.influence -= influence;
        }else if (influenceType == InfluenceType.POSITIVE) {
            this.influence += influence;
        }

        return this.influence;
    }

    /*
    * Update the influence of the player
    *
    * @param influence The influence to update the player with
    * @param influenceType The type of influence to update the player with
    * @return float The updated influence of the player
    */
    public float getInfluence() {
        return influence;
    }

    /*
    * Get the influence of the player
    *
    * @return float The influence of the player
    */
    @Override
    public Optional<? extends Node> getNode() {
        return Optional.empty();
    }
}

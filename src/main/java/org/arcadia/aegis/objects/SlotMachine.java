package org.arcadia.aegis.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import javafx.scene.Node;
import org.arcadia.aegis.game.Minigame;

import java.util.Optional;

public class SlotMachine extends DynamicSpriteEntity {
    private double locationX;
    private double locationY;
    private float bet;
    private Minigame minigame;

    /*
    * Constructor
    *
    * @param x The x-coordinate of the slot machine
    * @param y The y-coordinate of the slot machine
    * @param minigame The minigame the slot machine is part of
    */
    public SlotMachine(double x, double y, Minigame minigame) {
        super(minigame.getImagePath(), new Coordinate2D(x, y), new Size(60, 70));

        this.locationX = x;
        this.locationY = y;
        this.minigame = minigame;
    }

    /*
    * Set the bet of the slot machine
    *
    * @param bet The bet of the slot machine
    * @return void
    */
    public void setBet(float bet) {
        this.bet = bet;
    }

    /*
    * Get the bet of the slot machine
    *
    * @return float The bet of the slot machine
    */
    public float getBet() {
        return this.bet;
    }

    /*
    * Get the multiplier of the slot machine
    *
    * @param bet The bet of the slot machine
    * @param price The price of the slot machine
    * @return float The multiplier of the slot machine
    */
    public float getMultiplier(float bet, float price) {
        return bet / price;
    }

    /*
    * Get the location of the slot machine
    *
    * @return int The y-coordinate of the slot machine
    */
    public double getLocationY() {
        return locationY;
    }

    /*
    * Get the location of the slot machine
    *
    * @return int The x-coordinate of the slot machine
    */
    public double getLocationX() {
        return locationX;
    }

    /*
    * Set the location of the slot machine
    *
    * @param x The x-coordinate of the slot machine
    * @return void
    */
    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }

    /*
    * Set the location of the slot machine
    *
    * @param y The y-coordinate of the slot machine
    * @return void
    */
    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }

    /*
    * Get the minigame the slot machine is part of
    *
    * @return Minigame The minigame the slot machine is part of
    */
    public void viewSlotMachine() {

    }
}

package org.arcadia.aegis.objects;

import org.arcadia.aegis.game.Minigame;

public class SlotMachine {
    private int locationX;
    private int locationY;
    private float bet;
    private Minigame minigame;

    /*
    * Constructor
    *
    * @param x The x-coordinate of the slot machine
    * @param y The y-coordinate of the slot machine
    * @param minigame The minigame the slot machine is part of
    */
    public SlotMachine(int x, int y, Minigame minigame) {
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
    public int getLocationY() {
        return locationY;
    }

    /*
    * Get the location of the slot machine
    *
    * @return int The x-coordinate of the slot machine
    */
    public int getLocationX() {
        return locationX;
    }

    /*
    * Set the location of the slot machine
    *
    * @param x The x-coordinate of the slot machine
    * @return void
    */
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    /*
    * Set the location of the slot machine
    *
    * @param y The y-coordinate of the slot machine
    * @return void
    */
    public void setLocationX(int locationX) {
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

package org.arcadia.aegis.objects;

import org.arcadia.aegis.game.Minigame;

public class SlotMachine {
    private int locationX;
    private int locationY;

    private float bet;

    private Minigame minigame;

    public SlotMachine(int x, int y, Minigame minigame) {
        this.locationX = x;
        this.locationY = y;
        this.minigame = minigame;
    }

    public void setBet(float bet) {
        this.bet = bet;
    }

    public float getBet() {
        return this.bet;
    }

    public float getMultiplier(float bet, float price) {
        return bet / price;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public void viewSlotMachine() {

    }
}

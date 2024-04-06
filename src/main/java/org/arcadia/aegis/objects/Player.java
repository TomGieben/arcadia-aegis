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

    public Player(String name, String avatarPath) {
        this.name = name;
        this.avatarPath = avatarPath;
    }

    public Player(String name, String avatarPath, Wallet wallet, Inventory inventory) {
        this.name = name;
        this.avatarPath = avatarPath;
        this.wallet = wallet;
        this.inventory = inventory;
    }

    public void setLocation(int x, int y) {
        this.setLocationX(x);
        this.setLocationY(y);
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public float updateInfluence(float influence, InfluenceType influenceType) {
        if (influenceType == InfluenceType.NEGATIVE) {
            this.influence -= influence;
        }else if (influenceType == InfluenceType.POSITIVE) {
            this.influence += influence;
        }

        return this.influence;
    }

    public float getInfluence() {
        return influence;
    }

    @Override
    public Optional<? extends Node> getNode() {
        return Optional.empty();
    }
}

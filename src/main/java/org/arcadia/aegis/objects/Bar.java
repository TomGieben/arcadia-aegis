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

    public Bar(String imagePath, int x, int y) {
        this.imagePath = imagePath;
        this.locationX = x;
        this.locationY = y;
    }
    public Bar(String imagePath, int x, int y, Inventory inventory) {
        this.imagePath = imagePath;
        this.locationX = x;
        this.locationY = y;
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void viewBar(){
        return;
    }

    @Override
    public void onCollision(List<Collider> list) {

    }

    @Override
    public Optional<? extends Node> getNode() {
        return Optional.empty();
    }
}


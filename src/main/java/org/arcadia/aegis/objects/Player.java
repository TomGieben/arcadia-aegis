package org.arcadia.aegis.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import org.arcadia.aegis.enums.InfluenceType;
import org.arcadia.aegis.game.Wallet;
import org.arcadia.aegis.inventory.Inventory;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import java.util.Optional;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements Collider, KeyListener, SceneBorderTouchingWatcher {

    private Wallet wallet;
    private Inventory inventory;
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
    public Player(Coordinate2D location) {
        super("sprites/idle.png", location, new Size(20,40), 1, 2);
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
    public Player(Coordinate2D location, Wallet wallet, Inventory inventory) {
        super("sprites/idle.png", location, new Size(20,40), 1, 2);
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
    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(3,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(3,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(3,0d);
        } else if(pressedKeys.isEmpty()){
            setSpeed(0);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        setSpeed(0);

        switch(sceneBorder){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }
}

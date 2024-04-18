package org.arcadia.aegis.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import org.arcadia.aegis.entities.text.MoneyText;
import org.arcadia.aegis.enums.InfluenceType;
import org.arcadia.aegis.game.Wallet;
import org.arcadia.aegis.inventory.Inventory;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import java.util.Optional;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements Collider, KeyListener, SceneBorderTouchingWatcher {

    private Wallet wallet;
    private Inventory inventory;
    private float influence;

    private String playerName;

    private MoneyText moneyText;
    /*
    * Constructor
    *
    * @param name The name of the player
    * @param avatarPath The path to the avatar of the player
    * @param wallet The wallet of the player
    * @param inventory The inventory of the player
    */
    public Player(Coordinate2D location, MoneyText moneyText, String playerName) {
        super("sprites/player.png", location, new Size(50, 60));
        this.moneyText = moneyText;
        moneyText.setMoneyText(0);

        this.playerName = playerName;
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
    public Player(Coordinate2D location, MoneyText moneyText, String playerName, Wallet wallet, Inventory inventory) {
        super("sprites/idle.png", location, new Size(50,60));
        this.moneyText = moneyText;
        moneyText.setMoneyText(wallet.getAmount());

        this.playerName = playerName;
        this.wallet = wallet;
        this.inventory = inventory;
    }

    /*
     * Get the inventory of the player
     *
     * @return Inventory The inventory of the player
     */

    public Inventory getInventory() {
        return inventory;
    }


    /*
     * Get the wallet of the player
     *
     * @return Wallet The wallet of the player
     */
    public Wallet getWallet() {
        return wallet;
    }


    /*
     * Update the influence of the player
     *
     * @param influence The influence to update the player with
     * @param influenceType The type of influence to update the player with
     * @return float The updated influence of the player
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
     * Get the influence of the player
     *
     * @return float The influence of the player
     */

    public float getInfluence() {
        return influence;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A)){
            setMotion(3,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D)){
            setMotion(3,90d);
        } else if(pressedKeys.contains(KeyCode.UP) || pressedKeys.contains(KeyCode.W)){
            setMotion(3,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN) || pressedKeys.contains(KeyCode.S)){
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

package org.arcadia.aegis.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import javafx.scene.Node;
import org.arcadia.aegis.App;
import org.arcadia.aegis.game.Minigame;

import java.util.List;
import java.util.Optional;

public class SlotMachine extends DynamicSpriteEntity implements Collided {
    private float bet;
    private Minigame minigame;
    private App app;
    private int sceneIndex;

    /*
    * Constructor
    *
    * @param minigame The minigame the slot machine is part of
    */
    public SlotMachine(Coordinate2D locationSlotMachine, Minigame minigame, App app, int sceneIndex) {
        super(minigame.getImagePath(), locationSlotMachine, new Size(60, 70));

        this.minigame = minigame;
        this.app = app;
        this.sceneIndex = sceneIndex;
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
    public float getMultiplier() {

        return this.bet / this.minigame.getPrice();
    }

    /*
    * Get the minigame of the slot machine
    *
    * @return Minigame The minigame of the slot machine
    */
    public Minigame getMinigame() {
        return this.minigame;
    }

    /*
    * Get the app of the slot machine
    *
    * @return App The app of the slot machine
    */
    public void askForBet() {
        this.app.setActiveScene(this.sceneIndex);
    }

    /*
    * Get the app of the slot machine
    *
    * @return App The app of the slot machine
    */
    @Override
    public void onCollision(List<Collider> list) {
        this.app.getPlayer().setSpeed(0);

        this.askForBet();
    }
}

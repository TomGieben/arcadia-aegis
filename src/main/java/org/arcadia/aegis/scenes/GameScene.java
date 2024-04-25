package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.arcadia.aegis.entities.buttons.InventoryButton;
import org.arcadia.aegis.App;

public class GameScene extends DynamicScene {
    final private App app;
    final private String backgroundPath = "backgrounds/carpet_casino.png";

    /*
     * Constructor
     *
     * @param app The app
     */
    public GameScene(App app){
        this.app = app;
    }

    /*
     * Setup the scene
     */
    @Override
    public void setupScene() {
        setBackgroundImage(this.backgroundPath);
    }

    /*
     * Setup the entities
     */
    @Override
    public void setupEntities() {
        this.loadSlotMachines();
        this.renderBar();
        this.renderInventoryButton();
        this.renderPlayer();
    }

    /*
     * Render the inventory button
     */
    private void renderInventoryButton() {
        InventoryButton inventoryButton = new InventoryButton(
                this.app,
                new Coordinate2D(getWidth() - 140, getHeight() - 40),
                6
        );

        addEntity(inventoryButton);
    }

    /*
     * Render the player
     */
    private void renderPlayer() {
        addEntity(this.app.getPlayer());
        this.app.getMoneyText().setMoneyText(this.app.getPlayer().getWallet().getAmount());
        addEntity(this.app.getMoneyText());
    }

    /*
     * Load the slot machines
     */
    private void loadSlotMachines() {
        this.app.getSlotMachines().forEach(this::addEntity);
    }

    /*
     * Render the bar
     */
    private void renderBar() {
        addEntity(this.app.getBar());
    }
}

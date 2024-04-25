package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.arcadia.aegis.entities.buttons.InventoryButton;
import org.arcadia.aegis.App;
import org.arcadia.aegis.entities.text.MoneyText;
import org.arcadia.aegis.game.Wallet;
import org.arcadia.aegis.objects.Player;

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
        double buttonX = getWidth() - 140;
        double buttonY = getHeight() - 40;

        InventoryButton inventoryButton = new InventoryButton(
                this.app,
                new Coordinate2D(buttonX, buttonY),
                6
        );

        addEntity(inventoryButton);
    }

    /*
     * Render the player
     */
    private void renderPlayer() {
        Player player = this.app.getPlayer();
        MoneyText moneyText = this.app.getMoneyText();
        Wallet playerWallet = player.getWallet();

        moneyText.setMoneyText(playerWallet.getAmount());

        addEntity(player);
        addEntity(moneyText);
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

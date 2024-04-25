package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.entities.buttons.BuyButton;
import org.arcadia.aegis.entities.buttons.ReturnButton;
import org.arcadia.aegis.entities.buttons.UseButton;
import org.arcadia.aegis.game.Drink;
import org.arcadia.aegis.game.MainPrize;
import org.arcadia.aegis.game.Prize;
import org.arcadia.aegis.inventory.Inventory;
import org.arcadia.aegis.inventory.InventoryItem;
import org.arcadia.aegis.objects.Bar;
import org.arcadia.aegis.objects.DrinkEnitity;
import org.arcadia.aegis.objects.InventoryItemEntity;

import java.util.ArrayList;

public class InventoryScene extends DynamicScene {
    final private String backgroundPath = "backgrounds/inventory.jpg";
    final private String title = "Inventory";
    final private App app;
    final private Inventory inventory;
    
    /*
     * Constructor
     *
     * @param app The app
     */
    public InventoryScene(App app) {
        this.app = app;
        this.inventory = app.getPlayer().getInventory();
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
        this.renderTitle();
        this.renderReturnButton();

        this.renderItems();
    }

    /*
     * Render the drinks
     */
    private void renderItems() {
        ArrayList<InventoryItem> items = this.inventory.all();
        int counter = 0;

        for (InventoryItem item : items) {
            this.renderUseButton(item, counter);

            counter++;
        }
    }

    /*
     * Render the buy button
     *
     * @param drink The drink
     * @param counter The counter
     */
    private void renderUseButton(InventoryItem item, int counter) {
        int padding = 60;
        double baseX = padding + (counter * 100);
        double baseY = padding + 30;
        InventoryItemEntity inventoryItemEntity = null;

        if (item instanceof Drink) {
            Drink drink = (Drink) item;
            inventoryItemEntity = new InventoryItemEntity(
                    baseX,
                    baseY,
                    drink.getImagePath()
            );
        } else if (item instanceof MainPrize) {
            MainPrize mainPrize = (MainPrize) item;
            inventoryItemEntity = new InventoryItemEntity(
                    baseX,
                    baseY,
                    mainPrize.getImagePath()
            );
        }

        UseButton useButton = new UseButton(
                item,
                this.app,
                new Coordinate2D(baseX, baseY)
        );

        addEntity(useButton);
        addEntity(inventoryItemEntity);
    }

    /*
     * Render the title
     */
    private void renderTitle() {
        double textX  = getWidth() / 2;
        double textY = 5;

        TextEntity title = new TextEntity(
            new Coordinate2D(textX, textY),
            this.title
        );

        title.setAnchorPoint(AnchorPoint.TOP_CENTER);
        title.setFill(Color.WHITESMOKE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 40));

        addEntity(title);
    }

    /*
     * Render the return button
     */
    private void renderReturnButton() {
        double buttonX = getWidth() - 120;
        double buttonY = getHeight() - 40;
        int sceneId = 1;

        ReturnButton returnButton = new ReturnButton(
                this.app,
                new Coordinate2D(buttonX, buttonY),
                sceneId

        );
        addEntity(returnButton);
    }
}

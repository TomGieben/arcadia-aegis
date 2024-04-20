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
    public InventoryScene(App app) {
        this.app = app;
        this.inventory = app.getPlayer().getInventory();
    }
    @Override
    public void setupScene() {
        setBackgroundImage(this.backgroundPath);
    }

    @Override
    public void setupEntities() {
        this.renderTitle();
        this.renderReturnButton();

        this.renderItems();
    }

    private void renderItems() {
        ArrayList<InventoryItem> items = this.inventory.all();
        int counter = 0;

        for (InventoryItem item : items) {
            this.renderUseButton(item, counter);

            counter++;
        }
    }

    private void renderUseButton(InventoryItem item, int counter) {
        int padding = 60;
        double baseX = padding + (counter * 100);
        double baseY = padding;
        InventoryItemEntity inventoryItemEntity = null;

        if (item instanceof Drink) {
            Drink drink = (Drink) item;
            inventoryItemEntity = new InventoryItemEntity(
                    baseX,
                    baseY + 30,
                    drink.getImagePath()
            );
        } else if (item instanceof MainPrize) {
            MainPrize mainPrize = (MainPrize) item;
            inventoryItemEntity = new InventoryItemEntity(
                    baseX,
                    baseY + 30,
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

    private void renderTitle() {
        TextEntity title = new TextEntity(
            new Coordinate2D(getWidth() / 2, 5),
            this.title
        );

        title.setAnchorPoint(AnchorPoint.TOP_CENTER);
        title.setFill(Color.WHITESMOKE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 40));

        addEntity(title);
    }

    private void renderReturnButton() {
        ReturnButton returnButton = new ReturnButton(this.app, new Coordinate2D(getWidth() - 120, getHeight() - 40), 1);
        addEntity(returnButton);
    }
}
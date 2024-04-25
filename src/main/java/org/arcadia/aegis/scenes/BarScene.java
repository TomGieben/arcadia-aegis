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
import org.arcadia.aegis.game.Drink;
import org.arcadia.aegis.inventory.Inventory;
import org.arcadia.aegis.inventory.InventoryItem;
import org.arcadia.aegis.objects.Bar;
import org.arcadia.aegis.objects.DrinkEnitity;

import java.util.ArrayList;

public class BarScene extends DynamicScene {
    final private String backgroundPath = "backgrounds/bar.jpg";
    final private String title = "The bar";
    final private App app;
    final private Bar bar;

    /*
     * Constructor
     *
     * @param app The app
     */
    public BarScene(App app) {
        this.app = app;
        this.bar = app.getBar();
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
        this.renderDrinks();

        addEntity(this.app.getMoneyText());
    }

    /*
     * Render the drinks
     */
    private void renderDrinks() {
        Inventory inventory = this.bar.getInventory();
        ArrayList<InventoryItem> items = inventory.all();
        int counter = 0;

        for (InventoryItem item : items) {
            if(item instanceof Drink) {
                Drink drink = (Drink) item;

                this.renderBuyButton(drink, counter);

                counter++;
            }
        }
    }

    /*
     * Render the buy button
     *
     * @param drink The drink
     * @param counter The counter
     */
    private void renderBuyButton(Drink drink, int counter) {
        int padding = 60;
        double baseX = padding + (counter * 100);
        double baseY = padding;
        DrinkEnitity drinkEnitity = new DrinkEnitity(baseX, (baseY + 30), drink.getImagePath());
        TextEntity price = new TextEntity(
                new Coordinate2D(baseX, (baseY + 130)),
                Double.toString(drink.getPrice())
        );

        price.setFill(Color.DARKGOLDENROD);
        price.setFont(Font.font("Roboto", FontWeight.BOLD, 30));

        BuyButton buyButton = new BuyButton(
                drink,
                this.app,
                new Coordinate2D(baseX, baseY)
        );

        addEntity(buyButton);
        addEntity(drinkEnitity);
        addEntity(price);
    }

    /*
     * Render the title
     */
    private void renderTitle() {
        double textX = getWidth() / 2;
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
        int buttonWidth = 120;
        int buttonHeight = 40;
        double buttonX = getWidth() - buttonWidth;
        double buttonY = getHeight() - buttonHeight;

        Coordinate2D buttonPosition = new Coordinate2D(buttonX, buttonY);
        ReturnButton returnButton = new ReturnButton(app, buttonPosition, 1);

        addEntity(returnButton);
    }
}

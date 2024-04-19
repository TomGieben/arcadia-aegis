package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.entities.buttons.ReturnButton;
import org.arcadia.aegis.entities.buttons.SpinButton;
import org.arcadia.aegis.game.Drink;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.inventory.Inventory;
import org.arcadia.aegis.inventory.InventoryItem;
import org.arcadia.aegis.objects.Bar;
import org.arcadia.aegis.objects.Fruit;

import java.util.ArrayList;
import java.util.Random;

public class BarScene extends DynamicScene {
    final private String backgroundPath = "backgrounds/bar.png";
    final private App app;
    final private Bar bar;
    public BarScene(App app) {
        this.app = app;
        this.bar = app.getBar();
    }
    @Override
    public void setupScene() {
        setBackgroundImage(this.backgroundPath);
    }

    @Override
    public void setupEntities() {
        this.renderTitle();
        this.renderReturnButton();

        this.renderDrinks();
    }

    private void renderDrinks() {
        Inventory inventory = this.bar.getInventory();
        ArrayList<InventoryItem> items = inventory.all();

        for (InventoryItem item : items) {
            if(item instanceof Drink) {
                Drink drink = (Drink) item;
                String name = drink.getName();

                //TODO maak hier een text enitity van en weergeef het zodat de user het kan kopen
                System.out.println(name);
            }
        }
    }

    private void renderTitle() {
        TextEntity title = new TextEntity(
            new Coordinate2D(getWidth() / 2, 5),
            "The bar"
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

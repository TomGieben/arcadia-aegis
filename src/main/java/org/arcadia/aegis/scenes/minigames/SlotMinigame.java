package org.arcadia.aegis.scenes.minigames;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.entities.buttons.PlayAgainButton;
import org.arcadia.aegis.entities.buttons.ReturnButton;
import org.arcadia.aegis.entities.buttons.SpinButton;
import org.arcadia.aegis.entities.text.MoneyText;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.game.Wallet;
import org.arcadia.aegis.objects.Fruit;
import org.arcadia.aegis.objects.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class SlotMinigame extends DynamicScene {
    final private String backgroundPath = "backgrounds/blank_slot_machine.png";
    final private String spinSound = "sounds/spin_music.mp3";
    final private App app;
    final private Minigame minigame;

    /*
     * Constructor
     *
     * @param app The app
     * @param minigame The minigame
     */
    public SlotMinigame(App app, Minigame minigame) {
        this.app = app;
        this.minigame = minigame;
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
        this.renderSpinButton();
        this.renderReturnButton();

        addEntity(this.app.getMoneyText());
    }

    /*
     * Render the title
     */
    private void renderTitle() {
        double textX = getWidth() / 2;
        double textY = 5;

        TextEntity title = new TextEntity(
                new Coordinate2D(textX, textY),
                this.minigame.getName()
        );

        title.setAnchorPoint(AnchorPoint.TOP_CENTER);
        title.setFill(Color.WHITESMOKE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 40));

        addEntity(title);
    }

    /*
     * Render the spin button
     */
    private void renderSpinButton() {
        double buttonX = getWidth() / 2;
        double buttonY = getHeight() - 5;
        SpinButton button = new SpinButton(this, new Coordinate2D(buttonX, buttonY));

        button.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        button.setFill(Color.WHITESMOKE);
        button.setFont(Font.font("Roboto", FontWeight.BOLD, 40));

        addEntity(button);
    }

    /*
     * Spin the slot machine
     */
    public void spin() {
        this.playSpinSound();

        Random random = new Random();
        String[] items = this.getItems();

        int randomIndex1 = random.nextInt(items.length);
        int randomIndex2 = random.nextInt(items.length);
        int randomIndex3 = random.nextInt(items.length);

        String item1 = items[randomIndex1];
        String item2 = items[randomIndex2];
        String item3 = items[randomIndex3];

        this.renderItems(randomIndex1, randomIndex2, randomIndex3);

        Player player = this.app.getPlayer();
        Wallet playerWallet = player.getWallet();
        MoneyText moneyText = this.app.getMoneyText();
        float costAmount = minigame.getPrice() * minigame.getSlotmachine().getMultiplier();
        
        if (item1.equals(item2) && item2.equals(item3)) {
            playerWallet.deposit(costAmount);
        } else if (item1.equals(item2) || item1.equals(item3) || item2.equals(item3)) {
            playerWallet.deposit((float) (costAmount * 0.5));
        } else {
            playerWallet.withdraw(costAmount);
        }

        moneyText.setMoneyText(playerWallet.getAmount());
    }

    /*
     * Render the items
     *
     * @param index1 The index of the first item
     * @param index2 The index of the second item
     * @param index3 The index of the third item
     */
    private void renderItems(int index1, int index2, int index3) {
        String[] images = this.getItems();
        int itemsX = 250;

        addEntity(new Fruit(90, itemsX, images[index1]));
        addEntity(new Fruit(350, itemsX, images[index2]));
        addEntity(new Fruit(620, itemsX, images[index3]));

    }

    /*
     * Play the spin sound
     */
    private void playSpinSound() {
        SoundClip sound = new SoundClip(this.spinSound);
        sound.setVolume(0.5);

        sound.play();
    }

    /*
     * Get the items
     *
     * @return String[] The items
     */
    private String[] getItems() {
        String basePath = "images/fruits/";
        return new String[] {
            basePath + "apple.png",
            basePath + "banana.png",
            basePath + "cherry.png",
            basePath + "grape.png",
            basePath + "lemon.png",
            basePath + "peer.png",
            basePath + "strawberry.png",
            basePath + "tangerine.png",
            basePath + "watermelon.png",
        };
    }

    /*
     * Render the return button
     */
    private void renderReturnButton() {
        int buttonWidth = 120;
        int buttonHeight = 40;
        double buttonX = getWidth() - buttonWidth;
        double buttonY = getHeight() - buttonHeight;

        ReturnButton returnButton = new ReturnButton(this.app,  new Coordinate2D(buttonX, buttonY), 1);

        addEntity(returnButton);
    }
}

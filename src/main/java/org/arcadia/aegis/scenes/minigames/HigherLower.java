package org.arcadia.aegis.scenes.minigames;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.entities.buttons.HigherButton;
import org.arcadia.aegis.entities.buttons.LowerButton;
import org.arcadia.aegis.entities.buttons.ReturnButton;
import org.arcadia.aegis.entities.buttons.StartButton;
import org.arcadia.aegis.entities.text.HigherLowerText;
import org.arcadia.aegis.entities.text.MoneyText;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.objects.Player;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HigherLower extends DynamicScene {
    final private App app;
    final private Minigame minigame;
    private HigherLowerText higherLowerText;
    private int currentNumber;
    public HigherLower(App app, Minigame minigame){
        this.app = app;
        this.minigame = minigame;
        this.currentNumber = 0;
    }

    @Override
    public void setupScene() {
    }

    @Override
    public void setupEntities() {
        this.renderText();

        currentNumber = generateRandomNumber();
        this.higherLowerText.setHigherLowerText("Current number: " + currentNumber);
        addEntity(this.app.getPlayer().getMoneyText());
    }

    private void renderText() {
        double defaultWidth = getWidth() / 2;
        double defaultHeight = getHeight() / 2;

        HigherLowerText higherLowerText = new HigherLowerText(new Coordinate2D(defaultWidth - 100, defaultHeight - 100));
        addEntity(higherLowerText);
        this.higherLowerText = higherLowerText;

        this.renderHigerLowerButtons(defaultWidth, defaultHeight);
        this.renderReturnButton();
    }

    private void renderReturnButton() {
        ReturnButton returnButton = new ReturnButton(this.app, new Coordinate2D(getWidth() - 120, getHeight() - 40), 1);
        addEntity(returnButton);
    }

    private void renderHigerLowerButtons(double defaultWidth, double defaultHeight) {
        HigherButton higherButton = new HigherButton(
                this.app,
                new Coordinate2D(defaultWidth, defaultHeight),
                this
        );

        higherButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(higherButton);

        LowerButton lowerButton = new LowerButton(
                this.app,
                new Coordinate2D(defaultWidth, defaultHeight + 50),
                this
        );

        lowerButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(lowerButton);
    }

    public void runGame(boolean higher) {
        int randomNumber = generateRandomNumber();

        boolean won = false;
        if (higher) {
            if (randomNumber > currentNumber) {
                won = true;
            }
        } else {
            if (randomNumber < currentNumber) {
                won = true;
            }
        }

        if (won) {
            this.app.getPlayer().getWallet().deposit(minigame.getPrice());
        } else {
            this.app.getPlayer().getWallet().withdraw(minigame.getPrice());
        }

        this.app.getPlayer().getMoneyText().setMoneyText(this.app.getPlayer().getWallet().getAmount());
        this.currentNumber = this.generateRandomNumber();
        this.higherLowerText.setHigherLowerText("Current number: " + this.currentNumber);
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Random number between 1 and 100
    }
    public Minigame getMinigame() {
        return this.minigame;
    }
}

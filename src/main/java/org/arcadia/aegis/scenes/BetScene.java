package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.entities.buttons.StartButton;
import org.arcadia.aegis.entities.buttons.StartMinigameButton;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.objects.SlotMachine;
import org.arcadia.aegis.scenes.minigames.SlotMinigame;

import java.util.Set;

public class BetScene extends DynamicScene implements KeyListener {
    final private String backgroundPath = "backgrounds/ask_bet_background.png";
    final private String title = "Fill in your bet";
    private boolean prevWasEmpty = true;
    final private SlotMachine slotMachine;
    private TextEntity betText;

    /*
     * Constructor
     *
     * @param slotMachine The slot machine
     */
    public BetScene(SlotMachine slotMachine){
        this.slotMachine = slotMachine;
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
        this.renderStartMinigameButton();
        this.renderTitle();
        this.renderBetInput();
        this.renderBetAmount();
    }

    /*
     * Render the start minigame button
     */
    private void renderStartMinigameButton() {
        StartMinigameButton startButton = new StartMinigameButton(
                this.slotMachine,
                new Coordinate2D(getWidth() / 2, getHeight() / 2)
        );

        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);
    }

    /*
    * Render the title
    */
    private void renderTitle() {
        TextEntity title = new TextEntity(
            new Coordinate2D(getWidth() / 2, getHeight() / 3),
            this.title
        );

        title.setAnchorPoint(AnchorPoint.TOP_CENTER);
        title.setFill(Color.WHITESMOKE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 60));

        addEntity(title);
    }

    /*
     * Render the bet amount
     */
    private void renderBetAmount() {
        TextEntity betText = new TextEntity(
                new Coordinate2D(getWidth() / 2, 550),
                ""
        );

        betText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        betText.setFill(Color.GOLD);
        betText.setFont(Font.font("Roboto", FontWeight.BOLD, 20));

        this.betText = betText;

        addEntity(betText);
    }

    /*
     * Render the bet input
     */
    private void renderBetInput() {
        TextEntity input = new TextEntity(
            new Coordinate2D(getWidth() / 2, 500),
            "Amount:"
        );

        input.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        input.setFill(Color.WHITESMOKE);
        input.setFont(Font.font("Roboto", FontWeight.BOLD, 20));

        addEntity(input);
    }

    /*
     * Handle the key pressed event
     *
     * @param set The set of keys that are pressed
     */
    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        String currentBet = this.betText.getText();
        StringBuilder currentBetBuilder = new StringBuilder(currentBet);

        if (!this.prevWasEmpty) {
            this.prevWasEmpty = set.isEmpty();
        }

        boolean hasDecimal = currentBetBuilder.indexOf(".") != -1;

        for (KeyCode keyCode : set) {
            String keyName = keyCode.getName();

            if (keyCode != KeyCode.BACK_SPACE) {
                if (this.prevWasEmpty) {
                    Character key = keyName.charAt(0);

                    if (key == 'P') {
                        if (hasDecimal) {
                            return;
                        }

                        hasDecimal = true;
                        key = (".").charAt(0);
                    }

                    currentBetBuilder.append(key);
                    this.prevWasEmpty = false;
                }
            }  else {
                if (currentBetBuilder.length() > 0) {
                    currentBetBuilder.deleteCharAt(currentBetBuilder.length() - 1);
                }
            }
        }

        String bet = currentBetBuilder.toString();

        if(!bet.isEmpty()) {
            this.slotMachine.setBet(Float.parseFloat(bet));
        }

        this.betText.setText(bet);
    }
}

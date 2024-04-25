package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.entities.buttons.StartButton;

import java.util.Set;

public class TitleScene extends DynamicScene implements KeyListener {
    final private String backgroundPath = "backgrounds/titlescreen.jpg";
    private boolean prevWasEmpty = true;
    final private App app;
    private TextEntity nameText;

    /*
     * Constructor
     *
     * @param app The app
     */
    public TitleScene(App app){
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
        this.renderStartButton();
        this.renderTitle();
        this.renderNameInput();
        this.renderPlayerName();
    }

    /*
     * Render the start button
     */
    private void renderStartButton() {
        double buttonY = getHeight() / 2;
        double buttonX = getWidth() / 2;

        StartButton startButton = new StartButton(
                this.app,
                new Coordinate2D(buttonX, buttonY)
        );

        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);
    }

    /*
     * Render the title
     */
    private void renderTitle() {
        double textY = getHeight() / 3;
        double textX = getWidth() / 2;

        TextEntity title = new TextEntity(
            new Coordinate2D(textX, textY),
            getStage().getTitle()
        );

        title.setAnchorPoint(AnchorPoint.TOP_CENTER);
        title.setFill(Color.WHITESMOKE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 60));

        addEntity(title);
    }

    /*
     * Render the name input
     */
    private void renderNameInput() {
        double textY = 500;
        double textX = getWidth() / 2;

        TextEntity input = new TextEntity(
            new Coordinate2D(textX, textY),
            "Voer je naam in:"
        );

        input.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        input.setFill(Color.WHITESMOKE);
        input.setFont(Font.font("Roboto", FontWeight.BOLD, 20));

        addEntity(input);
    }

    /*
     * Render the player name
     */
    private void renderPlayerName() {
        double textY = 550;
        double textX = getWidth() / 2;

        TextEntity nameText = new TextEntity(
            new Coordinate2D(textX, textY),
            ""
        );

        nameText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        nameText.setFill(Color.BLACK);
        nameText.setFont(Font.font("Roboto", FontWeight.BOLD, 20));

        this.nameText = nameText;

        addEntity(nameText);
    }

    /*
     * Handle the key presses
     *
     * @param set The set of key codes
     */
    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        String currentName = this.app.getPlayerName();
        StringBuilder playerNameBuilder = new StringBuilder(currentName);

        if(!this.prevWasEmpty) {
            this.prevWasEmpty = set.isEmpty();
        }

        for (KeyCode keyCode : set) {
            if (keyCode != KeyCode.BACK_SPACE) {
                if(this.prevWasEmpty) {
                    playerNameBuilder.append(keyCode);
                    this.prevWasEmpty = false;
                }
            } else {
                if (playerNameBuilder.length() > 0) {
                    playerNameBuilder.deleteCharAt(playerNameBuilder.length() - 1);
                }
            }
        }

        String playerName = playerNameBuilder.toString();

        this.app.setPlayerName(playerName);

        this.nameText.setText(playerName);
    }
}

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

    public TitleScene(App app){
        this.app = app;
    }
    @Override
    public void setupScene() {
        setBackgroundImage(this.backgroundPath);
    }

    @Override
    public void setupEntities() {
        this.renderStartButton();
        this.renderTitle();
        this.renderNameInput();
        this.renderPlayerName();
    }

    private void renderStartButton() {
        StartButton startButton = new StartButton(
                this.app,
                new Coordinate2D(getWidth() / 2, getHeight() / 2)
        );

        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);
    }

    private void renderTitle() {
        TextEntity title = new TextEntity(
            new Coordinate2D(getWidth() / 2, getHeight() / 3),
            getStage().getTitle()
        );

        title.setAnchorPoint(AnchorPoint.TOP_CENTER);
        title.setFill(Color.WHITESMOKE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 60));

        addEntity(title);
    }

    private void renderNameInput() {
        TextEntity input = new TextEntity(
            new Coordinate2D(getWidth() / 2, 500),
            "Voer je naam in:"
        );

        input.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        input.setFill(Color.WHITESMOKE);
        input.setFont(Font.font("Roboto", FontWeight.BOLD, 20));

        addEntity(input);
    }

    private void renderPlayerName() {
        TextEntity nameText = new TextEntity(
            new Coordinate2D(getWidth() / 2, 550),
            ""
        );

        nameText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        nameText.setFill(Color.BLACK);
        nameText.setFont(Font.font("Roboto", FontWeight.BOLD, 20));

        this.nameText = nameText;

        addEntity(nameText);
    }

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

package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.entities.buttons.StartButton;

public class TitleScene extends DynamicScene {
    final private String audioPath = "sounds/background_music.mp3";
    final private String backgroundPath = "backgrounds/titlescreen.jpg";
    final private App app;

    public TitleScene(App app){
        this.app = app;
    }
    @Override
    public void setupScene() {
        setBackgroundAudio(this.audioPath);
        setBackgroundImage(this.backgroundPath);
    }

    @Override
    public void setupEntities() {
        this.renderStartButton();
        this.renderTitle();
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
            new Coordinate2D(getWidth() / 2, getHeight()/ 3),
            getStage().getTitle()
        );

        title.setAnchorPoint(AnchorPoint.TOP_CENTER);
        title.setFill(Color.WHITESMOKE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 60));

        addEntity(title);
    }
}

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
import org.arcadia.aegis.entities.buttons.PlayAgainButton;
import org.arcadia.aegis.entities.buttons.StartButton;

public class EndScene extends DynamicScene {
    final private String audioPath = "sounds/background_music.mp3";
    final private String backgroundPath = "backgrounds/car.jpg";
    final private String carSoundPath = "sounds/car_rev.wav";
    final private String title = "You won";
    final private App app;

    public EndScene(App app){
        this.app = app;
    }
    @Override
    public void setupScene() {
        setBackgroundAudio(this.audioPath);
        setBackgroundImage(this.backgroundPath);
    }

    @Override
    public void setupEntities() {
        this.renderTitle();
        this.renderPlayAgainButton();
        this.playRandomSound();
    }

    private void renderTitle() {
        TextEntity title = new TextEntity(
            new Coordinate2D(getWidth() / 2, getHeight()/ 3),
            this.title
        );

        title.setAnchorPoint(AnchorPoint.TOP_CENTER);
        title.setFill(Color.WHITESMOKE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 60));

        addEntity(title);
    }

    private void renderPlayAgainButton() {
        PlayAgainButton playAgainButton = new PlayAgainButton(
                this.app,
                new Coordinate2D(getWidth() / 2, getHeight() / 2)
        );

        playAgainButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(playAgainButton);
    }

    private void playRandomSound() {
        SoundClip sound = new SoundClip(this.carSoundPath);
        sound.setVolume(50);

        sound.play();
    }
}

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

    /*
     * Constructor
     *
     * @param app The app
     */
    public EndScene(App app){
        this.app = app;
    }

    /*
     * Setup the scene
     */
    @Override
    public void setupScene() {
        setBackgroundAudio(this.audioPath);
        setBackgroundImage(this.backgroundPath);
    }

    /*
     * Setup the entities
     */
    @Override
    public void setupEntities() {
        this.renderTitle();
        this.renderPlayAgainButton();
        this.playRandomSound();
    }

    /*
     * Render the title
     */
    private void renderTitle() {
        double textX = getWidth() / 2;
        double textY = getHeight() / 3;

        TextEntity title = new TextEntity(
            new Coordinate2D(textX, textY),
            this.title
        );

        title.setAnchorPoint(AnchorPoint.TOP_CENTER);
        title.setFill(Color.WHITESMOKE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 60));

        addEntity(title);
    }

    /*
     * Render the play again button
     */
    private void renderPlayAgainButton() {
        double buttonX = getWidth() / 2;
        double buttonY = getHeight() / 2;

        PlayAgainButton playAgainButton = new PlayAgainButton(
                this.app,
                new Coordinate2D(buttonX, buttonY)
        );

        playAgainButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(playAgainButton);
    }

    /*
     * Play a random sound
     */
    private void playRandomSound() {
        SoundClip sound = new SoundClip(this.carSoundPath);
        sound.setVolume(1);

        sound.play();
    }
}

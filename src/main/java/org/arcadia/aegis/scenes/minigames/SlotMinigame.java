package org.arcadia.aegis.scenes.minigames;

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

public class SlotMinigame extends DynamicScene {
    final private String audioPath = "sounds/background_music.mp3";
    final private String backgroundPath = "backgrounds/car.jpg";
    final private String carSoundPath = "sounds/car_rev.wav";
    final private String title = "Floenk";
    final private App app;

    public SlotMinigame(App app){
        this.app = app;
    }
    @Override
    public void setupScene() {
//        setBackgroundAudio(this.audioPath);
//        setBackgroundImage(this.backgroundPath);
    }

    @Override
    public void setupEntities() {
        this.renderTitle();
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
}

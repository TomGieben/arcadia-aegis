package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.geometry.Point2D;
import org.arcadia.aegis.entities.buttons.StartButton;

public class TitleScene extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundAudio("sounds/background-music.mp3");
        setBackgroundImage("backgrounds/titlescreen.jpg");
    }

    @Override
    public void setupEntities() {
        Coordinate2D cords = new Coordinate2D(10, 10);
        StartButton startButton = new StartButton(cords);
        addEntity(startButton);
    }
}

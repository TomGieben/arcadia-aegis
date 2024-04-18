package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.arcadia.aegis.entities.buttons.StartButton;
import org.arcadia.aegis.objects.Player;

public class GameScene extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/titlescreen.jpg");
    }

    @Override
    public void setupEntities() {
        Coordinate2D location = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        addEntity(new Player(location));
    }
}

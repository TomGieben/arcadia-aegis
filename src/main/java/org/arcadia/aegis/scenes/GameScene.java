package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.arcadia.aegis.objects.Player;
import com.github.hanyaeger.api.AnchorPoint;
import org.arcadia.aegis.App;

public class GameScene extends DynamicScene {
    final private App app;

    public GameScene(App app){
        this.app = app;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/titlescreen.jpg");
    }
    }

    @Override
    public void setupEntities() {
        Coordinate2D location = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        addEntity(new Player(location));
    }
}

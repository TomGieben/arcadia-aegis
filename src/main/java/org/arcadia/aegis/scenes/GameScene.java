package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.arcadia.aegis.entities.text.MoneyText;
import org.arcadia.aegis.App;
import org.arcadia.aegis.objects.Player;

public class GameScene extends DynamicScene {
    final private App app;
    final private String audioPath = "sounds/game_music.wav";

    public GameScene(App app){
        this.app = app;
    }
    @Override
    public void setupScene() {
        SoundClip sound = new SoundClip(this.audioPath, -1);
        sound.setVolume(0.1);
        sound.play();

        setBackgroundImage("backgrounds/carpet_casino.png");
    }

    @Override
    public void setupEntities() {
        MoneyText moneyText = new MoneyText(new Coordinate2D(1, 5));
        addEntity(moneyText);

        Coordinate2D locationPlayer = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        Player player = new Player(locationPlayer, moneyText, "TEMPPLAYERNAME");
        addEntity(player);
    }
}

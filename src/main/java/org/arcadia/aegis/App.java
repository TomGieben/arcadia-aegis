package org.arcadia.aegis;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.arcadia.aegis.objects.Player;
import org.arcadia.aegis.scenes.EndScene;
import org.arcadia.aegis.scenes.GameScene;
import org.arcadia.aegis.scenes.TitleScene;

/**
 * Hello world!
 *
 */
public class App extends YaegerGame
{
    private String playerName = "";
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Arcadia Aegis");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene(this));
        addScene(2, new EndScene(this));
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return this.playerName;
    }
}

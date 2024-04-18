package org.arcadia.aegis;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.arcadia.aegis.entities.text.MoneyText;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.objects.Player;
import org.arcadia.aegis.objects.SlotMachine;
import org.arcadia.aegis.scenes.EndScene;
import org.arcadia.aegis.scenes.GameScene;
import org.arcadia.aegis.scenes.TitleScene;
import org.arcadia.aegis.scenes.minigames.HigherLower;
import org.arcadia.aegis.scenes.minigames.SlotMinigame;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App extends YaegerGame
{
    private String playerName = "";
    private Player player;
    private ArrayList<Minigame> minigames = new ArrayList<Minigame>();
    final private String audioPath = "sounds/background_music.mp3";    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Arcadia Aegis");
        setSize(new Size(800, 600));
        setBackgroundAudio(this.audioPath);
        setBackgroundAudioVolume(0.2);
        this.renderPlayer();
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene(this));
        addScene(2, new EndScene(this));

        this.renderSlotmachines();
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    private void renderSlotmachines() {
        Minigame slotMinigame = new Minigame(
                this,
                "Slot machine",
                50,
                "images/slot_machine.png",
                3
        );

        this.minigames.add(slotMinigame);
        addScene(3, new SlotMinigame(this, slotMinigame));

        Minigame higherLower = new Minigame(
                this,
                "HigherLower",
                50,
                "images/slot_machine.png",
                4
        );

        this.minigames.add(higherLower);
        addScene(4, new HigherLower(this, higherLower));
    }

    private void renderPlayer() {
        MoneyText moneyText = new MoneyText(new Coordinate2D(1, 5));
        Coordinate2D locationPlayer = new Coordinate2D(400, 300);
        this.player = new Player(locationPlayer, moneyText, this.getPlayerName());
    }

    public Player getPlayer() {
        return this.player;
    }

    public ArrayList<Minigame> getMinigames() {
        return this.minigames;
    }
}

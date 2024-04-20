package org.arcadia.aegis;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.arcadia.aegis.entities.text.MoneyText;
import org.arcadia.aegis.enums.InfluenceType;
import org.arcadia.aegis.game.Drink;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.objects.Bar;
import org.arcadia.aegis.objects.Player;
import org.arcadia.aegis.objects.SlotMachine;
import org.arcadia.aegis.scenes.*;
import org.arcadia.aegis.scenes.BarScene;
import org.arcadia.aegis.scenes.EndScene;
import org.arcadia.aegis.scenes.GameScene;
import org.arcadia.aegis.scenes.TitleScene;
import org.arcadia.aegis.scenes.minigames.HigherLower;
import org.arcadia.aegis.scenes.minigames.WheelOfFate;
import org.arcadia.aegis.scenes.minigames.SlotMinigame;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App extends YaegerGame
{
    private String playerName = "";
    private Player player;
    private Bar bar;
    private ArrayList<Minigame> minigames = new ArrayList<Minigame>();

    private Minigame mainPrizeMiniGame;

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

        this.renderMinigames();
        this.renderBar();
        this.renderInventory();
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    private void renderMinigames() {
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

        Minigame mainPrize = new Minigame(this, "MainPrize", 250, "images/wheel_item.png", 6);
        this.mainPrizeMiniGame = mainPrize;
        addScene(6, new WheelOfFate(this, mainPrize));
    }

    private void renderBar() {
        String imagePath = "images/bar.png";
        this.bar = new Bar(imagePath, 100, 200, this);

        addScene(5, new BarScene(this));
    }

    private void renderInventory() {
        addScene(6, new InventoryScene(this));
    }

    private void renderPlayer() {
        MoneyText moneyText = new MoneyText(new Coordinate2D(1, 5));
        Coordinate2D locationPlayer = new Coordinate2D(400, 300);
        this.player = new Player(locationPlayer, moneyText, this.getPlayerName());
    }

    public Player getPlayer() {
        return this.player;
    }

    public Bar getBar() {
        return this.bar;
    }

    public ArrayList<Minigame> getMinigames() {
        return this.minigames;
    }

    public Minigame getMainPrizeMiniGame() { return  this.mainPrizeMiniGame; }
}

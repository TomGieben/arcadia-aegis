package org.arcadia.aegis;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.arcadia.aegis.entities.text.MoneyText;
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
import java.util.Random;

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
    private ArrayList<SlotMachine> slotmachines = new ArrayList<SlotMachine>();
    private ArrayList<Coordinate2D> coordinates = new ArrayList<Coordinate2D>();
    final private int padding = 100;
    private int width = 800;
    private int height = 600;

    final private String audioPath = "sounds/background_music.mp3";    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Arcadia Aegis");
        setSize(new Size(this.width, this.height));
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
        this.renderSlotMachines();
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

        Minigame mainPrize = new Minigame(this, "MainPrize", 250, "images/wheel_item.png", 7);
        this.mainPrizeMiniGame = mainPrize;
        addScene(7, new WheelOfFate(this, mainPrize));
    }

    private void renderBar() {
        String imagePath = "images/bar.png";
        Coordinate2D locationBar = new Coordinate2D(100, 200);
        this.coordinates.add(locationBar);
        this.bar = new Bar(imagePath, locationBar, this);

        addScene(5, new BarScene(this));
    }

    private void renderInventory() {
        addScene(6, new InventoryScene(this));
    }

    private void renderPlayer() {
        MoneyText moneyText = new MoneyText(new Coordinate2D(1, 5));
        Coordinate2D locationPlayer = new Coordinate2D(400, 300);
        this.coordinates.add(locationPlayer);
        this.player = new Player(locationPlayer, moneyText, this.getPlayerName());
    }

    private void renderSlotMachines() {
        Random random = new Random();
        ArrayList<Minigame> minigames = this.getMinigames();
        Minigame mainPrize = this.getMainPrizeMiniGame();

        this.placeRandomSlotMachine(mainPrize, random);

        int amountOfSlotMachines = 4;
        for (int i = 0; i < amountOfSlotMachines; i++) {
            int randomIndex = random.nextInt(minigames.size());
            Minigame minigame = minigames.get(randomIndex);
            this.placeRandomSlotMachine(minigame, random);
        }
    }

    private void placeRandomSlotMachine(Minigame minigame, Random random) {
        double x = random.nextInt((int)this.width - this.padding);
        double y = random.nextInt((int)this.height - this.padding);
        boolean validLocation = false;

        while (!validLocation) {
            x = random.nextInt((int)this.width - this.padding);
            y = random.nextInt((int)this.height - this.padding);

            if (!isCloseToExistingLocation(x, y)) {
                validLocation = true;
            }
        }

        this.slotmachines.add(new SlotMachine(x, y, minigame, this));
    }

    private boolean isCloseToExistingLocation(double x, double y) {
        for (Coordinate2D coordinate : this.coordinates) {
            if (distance(x, y, coordinate.getX(), coordinate.getY()) < this.padding) {
                return true;
            }
        }
        return false;
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
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

    public ArrayList<SlotMachine> getSlotMachines() { return this.slotmachines; }
}

package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.arcadia.aegis.entities.text.MoneyText;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.objects.Player;
import org.arcadia.aegis.App;
import org.arcadia.aegis.objects.SlotMachine;

import java.util.Random;

public class GameScene extends DynamicScene {
    final private App app;
    final private int amountOfSlotMachines = 4;
    final private String audioPath = "sounds/game_music.mp3";
    final private String backgroundPath = "backgrounds/carpet_casino.png";
    public GameScene(App app){
        this.app = app;
    }

    @Override
    public void setupScene() {
        SoundClip sound = new SoundClip(this.audioPath, -1);
        sound.setVolume(0.1);
        sound.play();

        setBackgroundImage(this.backgroundPath);
    }

    @Override
    public void setupEntities() {
        this.renderSlotMachines();
        this.renderPlayer();
    }

    private void renderPlayer() {
        addEntity(this.app.getPlayer());
        addEntity(this.app.getPlayer().getMoneyText());
    }

    private void renderSlotMachines() {
        Random random = new Random();
        int padding = 40;

        for (int i = 0; i < this.amountOfSlotMachines; i++) {
            int x = random.nextInt((int)getWidth() - padding);
            int y = random.nextInt((int)getHeight() - padding);
            //TODO create random minigame
//            Minigame minigame = new Minigame("Test", 10, "images/slot_machine.png");
//            SlotMachine slotMachine = new SlotMachine(x, y, minigame);
//
//            addEntity(slotMachine);
        }
    }
}

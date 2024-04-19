package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.arcadia.aegis.entities.text.MoneyText;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.objects.Bar;
import org.arcadia.aegis.objects.Player;
import org.arcadia.aegis.App;
import org.arcadia.aegis.objects.SlotMachine;

import java.util.ArrayList;
import java.util.Random;

public class GameScene extends DynamicScene {
    final private App app;
    final private int amountOfSlotMachines = 4;
    final private String backgroundPath = "backgrounds/carpet_casino.png";
    final private int padding = 40;
    public GameScene(App app){
        this.app = app;
    }

    @Override
    public void setupScene() {
        setBackgroundImage(this.backgroundPath);
    }

    @Override
    public void setupEntities() {
        this.renderSlotMachines();
        this.renderBar();
        this.renderPlayer();
    }

    private void renderPlayer() {
        addEntity(this.app.getPlayer());
        addEntity(this.app.getPlayer().getMoneyText());
    }

    private void renderSlotMachines() {
        Random random = new Random();
        ArrayList<Minigame> minigames = this.app.getMinigames();

        for (int i = 0; i < this.amountOfSlotMachines; i++) {
            int x = random.nextInt((int)getWidth() - this.padding);
            int y = random.nextInt((int)getHeight() - this.padding);
            int randomIndex = random.nextInt(minigames.size());
            Minigame minigame = minigames.get(randomIndex);
            SlotMachine slotMachine = new SlotMachine(x, y, minigame, this.app);

            addEntity(slotMachine);
        }
    }

    private void renderBar() {
        addEntity(this.app.getBar());
    }
}

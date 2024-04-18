package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.objects.Player;
import org.arcadia.aegis.App;
import org.arcadia.aegis.objects.SlotMachine;

import java.util.Random;

public class GameScene extends DynamicScene {
    final private App app;
    final private int amountOfSlotMachines = 4;

    public GameScene(App app){
        this.app = app;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/carpet_casino.png");
    }

    @Override
    public void setupEntities() {
        this.renderSlotMachines();

        Coordinate2D location = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        addEntity(new Player(location));
    }

    private void renderSlotMachines() {
        Random random = new Random();
        int padding = 20;

        for (int i = 0; i < this.amountOfSlotMachines; i++) {
            int x = random.nextInt((int)getWidth() - padding);
            int y = random.nextInt((int)getHeight() - padding);
            //TODO create random minigame
            Minigame minigame = new Minigame("Test", 10, "images/slot_machine.png");
            SlotMachine slotMachine = new SlotMachine(x, y, minigame);

            addEntity(slotMachine);
        }
    }
}

package org.arcadia.aegis.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;
import org.arcadia.aegis.entities.buttons.InventoryButton;
import org.arcadia.aegis.entities.text.MoneyText;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.App;
import org.arcadia.aegis.objects.SlotMachine;

import java.util.ArrayList;
import java.util.Random;

public class GameScene extends DynamicScene {
    final private App app;
    final private int amountOfSlotMachines = 4;
    final private String backgroundPath = "backgrounds/carpet_casino.png";
    final private int padding = 50;
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
        this.renderInventoryButton();
    }

    private void renderInventoryButton() {
        InventoryButton inventoryButton = new InventoryButton(
                this.app,
                new Coordinate2D(getWidth() - 140, getHeight() - 40),
                6
        );

        addEntity(inventoryButton);
    }

    private void renderPlayer() {
        addEntity(this.app.getPlayer());
        addEntity(this.app.getPlayer().getMoneyText());
    }

    private void renderSlotMachines() {
        Random random = new Random();
        ArrayList<Minigame> minigames = this.app.getMinigames();
        Minigame mainPrize = this.app.getMainPrizeMiniGame();

        this.placeRandomSlotMachine(mainPrize, random);

        for (int i = 0; i < this.amountOfSlotMachines; i++) {
            int randomIndex = random.nextInt(minigames.size());
            Minigame minigame = minigames.get(randomIndex);
            this.placeRandomSlotMachine(minigame, random);
        }
    }

    private void placeRandomSlotMachine(Minigame minigame, Random random) {
        int x = random.nextInt((int)getWidth() - this.padding);
        int y = random.nextInt((int)getHeight() - this.padding);

        SlotMachine slotMachine = new SlotMachine(x, y, minigame, this.app);
        addEntity(slotMachine);
    }

    private void renderBar() {
        addEntity(this.app.getBar());
    }
}

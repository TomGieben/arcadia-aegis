package org.arcadia.aegis.scenes.minigames;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.entities.buttons.ReturnButton;
import org.arcadia.aegis.entities.buttons.TurnWheelButton;
import org.arcadia.aegis.entities.text.MoneyText;
import org.arcadia.aegis.entities.text.PrizeText;
import org.arcadia.aegis.enums.PrizeType;
import org.arcadia.aegis.game.*;
import org.arcadia.aegis.inventory.InventoryItem;
import org.arcadia.aegis.objects.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WheelOfFate extends DynamicScene {
    final private String backgroundPath = "backgrounds/spinning_wheel.gif";
    final private String spinSound = "sounds/prize_wheel_spin.wav";
    final private App app;
    final private Minigame minigame;
    private PrizeText prizeText;
    private Map<String, String> moneyPrizeMap = new HashMap<>();
    private ArrayList<InventoryItem> itemPrizeMap;

    /*
     * Constructor
     *
     * @param app The app
     * @param minigame The minigame
     */
    public WheelOfFate(App app, Minigame minigame) {
        this.app = app;
        this.minigame = minigame;
    }

    /*
     * Setup the scene
     */
    @Override
    public void setupScene() {
        setBackgroundImage(this.backgroundPath);
        this.createPrizeMapping();
    }

    /*
     * Setup the entities
     */
    @Override
    public void setupEntities() {
        double textX = 5;
        int textY = 50;
        PrizeText prizeText = new PrizeText(new Coordinate2D(textX, textY));

        this.prizeText = prizeText;

        addEntity(this.app.getMoneyText());
        addEntity(prizeText);

        this.renderSpinButton();
        this.renderReturnButton();
    }

    /*
     * Render the return button
     */
    private void renderReturnButton() {
        int buttonWidth = 120;
        int buttonHeight = 40;
        double buttonX = getWidth() - buttonWidth;
        double buttonY = getHeight() - buttonHeight;

        ReturnButton returnButton = new ReturnButton(this.app,  new Coordinate2D(buttonX, buttonY), 1);

        addEntity(returnButton);
    }

    /*
     * Spin the wheel
     */
    public void spin() {
        this.prizeText.setPrizeText("");
        this.playSpinSound();
        ArrayList<Prize> prizes = this.createPrizes();
        Random random = new Random();
        int randomIndex = random.nextInt(prizes.size());
        Prize winningPrize = prizes.get(randomIndex);

        Thread soundThread = new Thread(() -> {
            try {
                Thread.sleep((long) (getSpinSoundDuration() * 1000));

                awardPrize(winningPrize);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        soundThread.start();
    }

    /*
     * Get the duration of the spin sound
     *
     * @return The duration of the spin sound
     */
    private double getSpinSoundDuration() {
        return 7.0;
    }

    /*
     * Award the prize
     *
     * @param prize The prize
     */
    private void awardPrize(Prize prize) {
        this.playSound("sounds/win_sound.wav");

        if (PrizeType.MONEY == prize.getType()) {
            Player player = this.app.getPlayer();
            Wallet playerWallet = player.getWallet();
            MoneyText moneyText = this.app.getMoneyText();

            int prizeValue = Integer.parseInt(prize.getValue());
            playerWallet.deposit(prizeValue);
            moneyText.setMoneyText(playerWallet.getAmount());
            this.prizeText.setPrizeText("Congratulations! You have gained: " + prizeValue + " Bucks");

        } else if (PrizeType.DRINK == prize.getType() || PrizeType.MAINPRIZE == prize.getType()) {
            InventoryItem inventoryItem = prize;

            if (PrizeType.DRINK == prize.getType()) {
                String prizeName = prize.getName();

                for (InventoryItem item : this.itemPrizeMap) {
                    if (item instanceof Drink && ((Drink) item).getName().equals(prizeName)) {
                        inventoryItem = item;

                        this.prizeText.setPrizeText("You have won drink: " + ((Drink) inventoryItem).getName());

                        break;
                    }
                }
            } else if (PrizeType.MAINPRIZE == prize.getType()) {
                this.prizeText.setPrizeText("You have the main prize");
            }

            this.app.getPlayer().getInventory().store(inventoryItem);
        } else {
            this.prizeText.setPrizeText("You have nothing");
        }
    }

    /*
     * Create the prizes
     *
     * @return The prizes
     */
    private ArrayList<Prize> createPrizes() {
        ArrayList<Prize> prizes = new ArrayList<Prize>();
        MainPrize mainPrize = new MainPrize("images/prizes/car_prize.png");
        int maxWheelPrizes = 10;

        prizes.add(mainPrize);

        for (int i = 0; i < maxWheelPrizes; i++) {
            Prize prize = this.createRandomPrize();
            prizes.add(prize);
        }

        return prizes;
    }

    /*
     * Create the prize mapping
     */
    private void createPrizeMapping() {
        Map<String, String> moneyPrizeMap = new HashMap<>();
        moneyPrizeMap.put("Cash", "80");
        moneyPrizeMap.put("Gift Card", "200");
        moneyPrizeMap.put("Voucher", "400");
        moneyPrizeMap.put("Check", "5000");

        ArrayList<InventoryItem> items = this.app.getBar().getInventory().all();

        this.moneyPrizeMap = moneyPrizeMap;
        this.itemPrizeMap = items;
    }

    /*
     * Create a random prize
     *
     * @return The random prize
     */
    private Prize createRandomPrize() {
        Random random = new Random();
        PrizeType[] prizeTypes ={PrizeType.DRINK, PrizeType.MONEY};
        int randomIndex = random.nextInt(prizeTypes.length);
        PrizeType randomPrize = prizeTypes[randomIndex];

        String randomPrizeName = "Default Prize";
        String randomPrizeValue = "0";

        if (randomPrize == PrizeType.MONEY && !this.moneyPrizeMap.isEmpty()) {
            randomIndex = random.nextInt(this.moneyPrizeMap.size());
            randomPrizeName = (String) this.moneyPrizeMap.keySet().toArray()[randomIndex];
            randomPrizeValue = this.moneyPrizeMap.get(randomPrizeName);
        } else if (randomPrize == PrizeType.DRINK && !this.itemPrizeMap.isEmpty()) {
            randomIndex = random.nextInt(this.itemPrizeMap.size());
            InventoryItem randomItem = this.itemPrizeMap.get(randomIndex);

            if (randomItem instanceof Drink) {
                randomPrizeName = ((Drink) randomItem).getName();
                randomPrizeValue = "Drink";
            }
        }

       return new Prize(randomPrize, randomPrizeName, randomPrizeValue);
    }

    /*
     * Play the spin sound
     */
    private void playSpinSound() {
        SoundClip sound = new SoundClip(this.spinSound);
        sound.setVolume(0.5);

        sound.play();
    }

    /*
     * Play a sound
     *
     * @param path The path of the sound
     */
    private void renderSpinButton() {
        TurnWheelButton button = new TurnWheelButton(this, new Coordinate2D(getWidth() / 2, getHeight() - 5));

        button.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        button.setFill(Color.WHITESMOKE);
        button.setFont(Font.font("Roboto", FontWeight.BOLD, 40));

        addEntity(button);
    }

    /*
     * Get the minigame
     *
     * @return The minigame
     */
    public Minigame getMinigame() {
        return this.minigame;
    }

    /*
     * Get the app
     *
     * @return The app
     */
    public App getApp() {
        return this.app;
    }

    /*
     * Play a sound
     *
     * @param path The path of the sound
     */
    private void playSound(String path) {
        SoundClip sound = new SoundClip(path);
        sound.setVolume(0.5);

        sound.play();
    }
}

package org.arcadia.aegis.scenes.minigames;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.entities.buttons.ReturnButton;
import org.arcadia.aegis.entities.buttons.TurnWheelButton;
import org.arcadia.aegis.enums.PrizeType;
import org.arcadia.aegis.game.MainPrize;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.game.Prize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WheelOfFate extends DynamicScene {
    final private String backgroundPath = "backgrounds/wheel_background.png";
    final private String spinSound = "sounds/prize_wheel_spin.wav";
    final private App app;
    final private Minigame minigame;

    private Map<String, String> moneyPrizeMap = new HashMap<>();
    private Map<String, String> drinkPrizeMap = new HashMap<>();


    public WheelOfFate(App app, Minigame minigame) {
        this.app = app;
        this.minigame = minigame;
    }

    @Override
    public void setupScene() {
        setBackgroundImage(this.backgroundPath);
        this.createPrizeMapping();
    }

    @Override
    public void setupEntities() {
        this.renderTitle();
        this.renderSpinButton();
        this.renderReturnButton();
    }
    private void renderReturnButton() {
        ReturnButton returnButton = new ReturnButton(this.app, new Coordinate2D(getWidth() - 120, getHeight() - 40), 1);
        addEntity(returnButton);
    }

    public void spin() {
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

    private double getSpinSoundDuration() {
        return 7.0;
    }

    private void awardPrize(Prize prize) {
        if (PrizeType.MONEY == prize.getType()) {
            this.app.getPlayer().getWallet().deposit(Integer.parseInt(prize.getValue()));
            this.app.getPlayer().getMoneyText().setMoneyText(this.app.getPlayer().getWallet().getAmount());
        } else if (PrizeType.DRINK == prize.getType() && PrizeType.MAINPRIZE == prize.getType()) {
            this.app.getPlayer().getInventory().store(prize);
        }
    }

    private ArrayList<Prize> createPrizes() {
        ArrayList<Prize> prizes = new ArrayList<Prize>();

        MainPrize mainPrize = new MainPrize("images/prizes/car_prize.png");
        prizes.add(mainPrize);

        int maxWheelPrizes = 10;
        for (int i = 0; i < maxWheelPrizes; i++) {
            Prize prize = this.createRandomPrize();
            prizes.add(prize);
        }

        return prizes;
    }

    private void createPrizeMapping() {
        Map<String, String> moneyPrizeMap = new HashMap<>();
        moneyPrizeMap.put("Cash", "20");
        moneyPrizeMap.put("Gift Card", "40");
        moneyPrizeMap.put("Voucher", "80");
        moneyPrizeMap.put("Check", "5000");

        Map<String, String> drinkPrizeMap = new HashMap<>();
        drinkPrizeMap.put("Wine", "2");
        drinkPrizeMap.put("Whiskey", "4");
        drinkPrizeMap.put("Cocktail", "3");
        drinkPrizeMap.put("Beer", "1");

        this.moneyPrizeMap = moneyPrizeMap;
        this.drinkPrizeMap = drinkPrizeMap;
    }
    private Prize createRandomPrize() {
        Random random = new Random();
        PrizeType[] prizeTypes ={PrizeType.DRINK, PrizeType.MONEY};
        int randomIndex = random.nextInt(prizeTypes.length);
        PrizeType randomPrize = prizeTypes[randomIndex];

        String randomPrizeName;
        String randomPrizeValue;
        if (randomPrize == PrizeType.MONEY && !this.moneyPrizeMap.isEmpty()) {
            randomIndex = random.nextInt(this.moneyPrizeMap.size());
            randomPrizeName = (String) this.moneyPrizeMap.keySet().toArray()[randomIndex];
            randomPrizeValue = this.moneyPrizeMap.get(randomPrizeName);
        } else if (randomPrize == PrizeType.DRINK && !this.drinkPrizeMap.isEmpty()) {
            randomIndex = random.nextInt(this.drinkPrizeMap.size());
            randomPrizeName = (String) this.drinkPrizeMap.keySet().toArray()[randomIndex];
            randomPrizeValue = this.drinkPrizeMap.get(randomPrizeName);
        } else {
            randomPrizeName = "Default Prize";
            randomPrizeValue = "0";
        }

       return new Prize(randomPrize, randomPrizeName, randomPrizeValue);
    }

    private void renderTitle() {
        TextEntity title = new TextEntity(
                new Coordinate2D(getWidth() / 2, 5),
                this.minigame.getName()
        );

        title.setAnchorPoint(AnchorPoint.TOP_CENTER);
        title.setFill(Color.WHITESMOKE);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 40));

        addEntity(title);
    }

    private void playSpinSound() {
        SoundClip sound = new SoundClip(this.spinSound);
        sound.setVolume(0.5);

        sound.play();
    }

    private void renderSpinButton() {
        TurnWheelButton button = new TurnWheelButton(this, new Coordinate2D(getWidth() / 2, getHeight() - 5));

        button.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        button.setFill(Color.WHITESMOKE);
        button.setFont(Font.font("Roboto", FontWeight.BOLD, 40));

        addEntity(button);
    }
}

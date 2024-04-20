package org.arcadia.aegis.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.game.Drink;
import org.arcadia.aegis.game.Wallet;
import org.arcadia.aegis.objects.Player;
import org.arcadia.aegis.scenes.minigames.SlotMinigame;

public class BuyButton extends TextEntity implements MouseButtonPressedListener {
    final private Drink drink;
    final private App app;
    final private String soundPath = "sounds/item_purchase.wav";

    public BuyButton(Drink drink, App app, Coordinate2D initialLocation) {
        super(initialLocation, drink.getName());
        setFill(Color.GOLD);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));

        this.drink = drink;
        this.app = app;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        Player player = this.app.getPlayer();
        Wallet wallet = player.getWallet();
        float walletAmount = wallet.getAmount();
        float drinkPrice = this.drink.getPrice();

        if(walletAmount < drinkPrice) {
            return;
        }

        this.playSound();
        player.getInventory().store(this.drink);
        wallet.withdraw(drinkPrice);
    }

    private void playSound() {
        SoundClip sound = new SoundClip(this.soundPath);
        sound.setVolume(0.5);

        sound.play();
    }
}

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
import org.arcadia.aegis.game.MainPrize;
import org.arcadia.aegis.game.Wallet;
import org.arcadia.aegis.inventory.InventoryItem;
import org.arcadia.aegis.objects.InventoryItemEntity;
import org.arcadia.aegis.objects.Player;

public class UseButton extends TextEntity implements MouseButtonPressedListener {
    final private InventoryItem item;
    final private App app;
    final private String soundPath = "sounds/success.wav";

    /*
     * Constructor
     *
     * @param item The item to use
     * @param app The app
     * @param initialLocation The initial location of the button
     */
    public UseButton(InventoryItem item, App app, Coordinate2D initialLocation) {
        super(initialLocation, "Use");
        setFill(Color.GOLD);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));

        this.item = item;
        this.app = app;
    }

    /*
     * Handle the mouse button pressed event
     *
     * @param button The button that was pressed
     * @param coordinate2D The coordinate of the button press
     */
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        Player player = this.app.getPlayer();

        if (this.item instanceof MainPrize) {
            this.app.setActiveScene(2);
            return;
        }

        player.getInventory().destroy(this.item);

        //TODO make the drink have influence on a minigame

        this.playSound();

        this.app.setActiveScene(6);
    }

    private void playSound() {
        SoundClip sound = new SoundClip(this.soundPath);
        sound.setVolume(0.5);

        sound.play();
    }
}

package org.arcadia.aegis.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.game.Minigame;
import org.arcadia.aegis.game.Wallet;
import org.arcadia.aegis.scenes.minigames.HigherLower;
import org.arcadia.aegis.scenes.minigames.WheelOfFate;

public class TurnWheelButton extends TextEntity implements MouseButtonPressedListener {
    final private WheelOfFate wheelOfFate;

    /*
     * Constructor
     *
     * @param wheelOfFate The wheel of fate
     * @param initialLocation The initial location of the button
     */
    public TurnWheelButton(WheelOfFate wheelOfFate, Coordinate2D initialLocation) {
        super(initialLocation, "Spin");
        setFill(Color.WHITESMOKE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

        this.wheelOfFate = wheelOfFate;
    }


    /*
     * Handle the mouse button pressed event
     *
     * @param button The button that was pressed
     * @param coordinate2D The coordinate of the button press
     */
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        Wallet wallet = this.wheelOfFate.getApp().getPlayer().getWallet();
        Minigame minigame = this.wheelOfFate.getMinigame();

//        if(wallet.getAmount() >= minigame.getPrice()) {
//            wallet.withdraw(minigame.getPrice());
            this.wheelOfFate.getApp().getMoneyText().setMoneyText(wallet.getAmount());
            this.wheelOfFate.spin();
//        }
    }
}

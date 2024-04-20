package org.arcadia.aegis.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.scenes.minigames.HigherLower;
import org.arcadia.aegis.scenes.minigames.WheelOfFate;

public class TurnWheelButton extends TextEntity implements MouseButtonPressedListener {
    final private WheelOfFate wheelOfFate;
    public TurnWheelButton(WheelOfFate wheelOfFate, Coordinate2D initialLocation) {
        super(initialLocation, "Spin");
        setFill(Color.WHITESMOKE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

        this.wheelOfFate = wheelOfFate;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        if(this.wheelOfFate.getApp().getPlayer().getWallet().getAmount() >= this.wheelOfFate.getMinigame().getPrice()) {
            this.wheelOfFate.getApp().getPlayer().getWallet().withdraw(this.wheelOfFate.getMinigame().getPrice());
            this.wheelOfFate.getApp().getPlayer().getMoneyText().setMoneyText(this.wheelOfFate.getApp().getPlayer().getWallet().getAmount());
            this.wheelOfFate.spin();
        }
    }
}

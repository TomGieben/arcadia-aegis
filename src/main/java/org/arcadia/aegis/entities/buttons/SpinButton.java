package org.arcadia.aegis.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.scenes.minigames.SlotMinigame;

public class SpinButton extends TextEntity implements MouseButtonPressedListener {
    final private SlotMinigame slotMinigame;
    public SpinButton(SlotMinigame slotMinigame, Coordinate2D initialLocation) {
        super(initialLocation, "Spin");
        setFill(Color.WHITESMOKE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

        this.slotMinigame = slotMinigame;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        this.slotMinigame.spin();
    }
}

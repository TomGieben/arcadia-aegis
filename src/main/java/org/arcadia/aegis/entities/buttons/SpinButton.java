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

    /*
    * Constructor
    *
    * @param slotMinigame The slot minigame
    * @param initialLocation The initial location of the button
    */
    public SpinButton(SlotMinigame slotMinigame, Coordinate2D initialLocation) {
        super(initialLocation, "Spin");
        setFill(Color.WHITESMOKE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

        this.slotMinigame = slotMinigame;
    }

    /*
    * Handle the mouse button pressed event
    *
    * @param button The button that was pressed
    * @param coordinate2D The coordinate of the button press
    */
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        this.slotMinigame.spin();
    }
}

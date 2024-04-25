package org.arcadia.aegis.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.objects.SlotMachine;

public class StartMinigameButton extends TextEntity implements MouseButtonPressedListener {
    final private SlotMachine slotMachine;

    /*
     * Constructor
     *
     * @param slotMachine The slot machine
     * @param initialLocation The initial location of the button
     */
    public StartMinigameButton(SlotMachine slotMachine, Coordinate2D initialLocation) {
        super(initialLocation, "Play game");
        setFill(Color.WHITESMOKE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

        this.slotMachine = slotMachine;
    }

    /*
     * Handle the mouse button pressed event
     *
     * @param button The button that was pressed
     * @param coordinate2D The coordinate of the button press
     */
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        slotMachine.getMinigame().start();
    }
}
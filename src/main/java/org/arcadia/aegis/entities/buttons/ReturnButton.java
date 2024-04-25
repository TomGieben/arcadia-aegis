package org.arcadia.aegis.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;

public class ReturnButton extends TextEntity implements MouseButtonPressedListener {
    final private App app;
    private int sceneId;

    /*
     * Constructor
     *
     * @param app The app
     * @param initialLocation The initial location of the button
     * @param sceneId The scene id
     */
    public ReturnButton(App app, Coordinate2D initialLocation, int sceneId) {
        super(initialLocation, "Return");
        setFill(Color.BLACK);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

        this.app = app;
        this.sceneId = sceneId;
    }

    /*
     * Handle the mouse button pressed event
     *
     * @param button The button that was pressed
     * @param coordinate2D The coordinate of the button press
     */
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        this.app.getPlayer().setAnchorLocation(new Coordinate2D(400, 300));
        app.setActiveScene(this.sceneId);
        this.app.getMoneyText().setMoneyText(this.app.getPlayer().getWallet().getAmount());
    }
}

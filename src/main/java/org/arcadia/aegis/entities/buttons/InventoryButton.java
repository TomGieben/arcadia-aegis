package org.arcadia.aegis.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;

public class InventoryButton extends TextEntity implements MouseButtonPressedListener {
    final private App app;
    private int sceneId;

    public InventoryButton(App app, Coordinate2D initialLocation, int sceneId) {
        super(initialLocation, "Inventory");
        setFill(Color.BLACK);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

        this.app = app;
        this.sceneId = sceneId;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        app.setActiveScene(this.sceneId);
    }
}

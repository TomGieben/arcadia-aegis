package org.arcadia.aegis.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;
import org.arcadia.aegis.objects.Player;
import org.arcadia.aegis.scenes.minigames.HigherLower;

public class LowerButton extends TextEntity implements MouseButtonPressedListener {
    final private App app;
    final private HigherLower scene;

    public LowerButton(App app, Coordinate2D initialLocation, HigherLower scene) {
        super(initialLocation, "Lower");
        setFill(Color.DARKBLUE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

        this.app = app;
        this.scene = scene;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        if(this.app.getPlayer().getWallet().getAmount() >= scene.getMinigame().getPrice()) {
            this.scene.runGame(false);
        }
    }
}

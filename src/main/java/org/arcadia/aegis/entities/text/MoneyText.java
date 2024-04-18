package org.arcadia.aegis.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;

public class MoneyText extends TextEntity {

    public MoneyText(Coordinate2D location) {
        super(location);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.GOLD);
    }

    public void setMoneyText(float money){
        setText("Money: " + money);
    }
}

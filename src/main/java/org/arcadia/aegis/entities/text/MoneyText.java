package org.arcadia.aegis.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.arcadia.aegis.App;

public class MoneyText extends TextEntity {
    /*
     * Constructor
     *
     * @param location The location of the text
     */
    public MoneyText(Coordinate2D location) {
        super(location);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.GOLD);
    }

    /*
     * Set the text of the MoneyText
     *
     * @param money The money to set
     */
    public void setMoneyText(float money){
        setText("Money: " + money);
    }
}

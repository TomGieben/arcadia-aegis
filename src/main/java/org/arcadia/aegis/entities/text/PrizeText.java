package org.arcadia.aegis.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PrizeText  extends TextEntity {
    /*
     * Constructor
     *
     * @param location The location of the text
     */
    public PrizeText(Coordinate2D location) {
        super(location);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.GREENYELLOW);
    }

    /*
     * Set the text of the PrizeText
     *
     * @param text The text to set
     */
    public void setPrizeText(String text){
        setText(text);
    }
}

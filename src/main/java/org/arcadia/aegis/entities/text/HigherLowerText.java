package org.arcadia.aegis.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HigherLowerText extends TextEntity {

    /*
     * Constructor
     *
     * @param location The location of the text
     */
    public HigherLowerText(Coordinate2D location) {
        super(location);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.RED);
    }

    /*
     * Set the text of the HigherLowerText
     *
     * @param text The text to set
     */
    public void setHigherLowerText(String text){
        setText(text);
    }
}

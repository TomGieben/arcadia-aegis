package org.arcadia.aegis.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import org.arcadia.aegis.game.Minigame;

public class Fruit extends DynamicSpriteEntity {

    /*
     * Constructor
     *
     * @param x The x-coordinate of the fruit
     * @param y The y-coordinate of the fruit
     * @param imagePath The image path of the fruit
     */
    public Fruit(double x, double y, String imagePath) {
        super(imagePath, new Coordinate2D(x, y), new Size(100, 100));
    }
}

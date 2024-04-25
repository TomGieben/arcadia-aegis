package org.arcadia.aegis.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class InventoryItemEntity extends DynamicSpriteEntity {

    /*
     * Constructor
     *
     * @param x The x-coordinate of the fruit
     * @param y The y-coordinate of the fruit
     * @param imagePath The image path of the fruit
     */
    public InventoryItemEntity(double x, double y, String imagePath) {
        //Width and height of the inventoryItem = 100
        super(imagePath, new Coordinate2D(x, y), new Size(100, 100));
    }
}

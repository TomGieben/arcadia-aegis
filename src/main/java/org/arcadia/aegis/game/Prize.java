package org.arcadia.aegis.game;

import org.arcadia.aegis.enums.PrizeType;
import org.arcadia.aegis.inventory.InventoryItem;

public class Prize extends InventoryItem {
    private String name;
    private PrizeType type;
    private String value;

    /*
    * Constructor
    *
    * @param type The type of the prize
    * @param name The name of the prize
    */
    public Prize(PrizeType type, String name) {
        this.type = type;
        this.name = name;
        this.value = "";
    }

    /*
    * Constructor
    *
    * @param type The type of the prize
    * @param name The name of the prize
    * @param value The value of the prize
    */
    public Prize(PrizeType type, String name, String value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    /*
    * Get the type of the prize
    *
    * @return PrizeType The type of the prize
    */
    public PrizeType getType() {
        return type;
    }

    /*
    * Get the name of the prize
    *
    * @return String The name of the prize
    */
    public String getName() {
        return this.name;
    }

    /*
    * Get the value of the prize
    *
    * @return String The value of the prize
    */
    public String getValue() {
        return value;
    }

    /*
    * Set the value of the prize
    *
    * @param value The value of the prize
    * @return void
    */
    public void setValue(String value) {
        this.value = value;
    }
}

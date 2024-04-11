package org.arcadia.aegis.game;

import org.arcadia.aegis.enums.PrizeType;

public class Prize {
    private String name;
    private PrizeType type;

    private String value;

    public Prize(PrizeType type, String name) {
        this.type = type;
        this.name = name;
        this.value = "";
    }

    public Prize(PrizeType type, String name, String value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public PrizeType getType() {
        return type;
    }
    public String getName() {
        return this.name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

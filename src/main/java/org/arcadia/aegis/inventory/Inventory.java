package org.arcadia.aegis.inventory;

public class Inventory {
    private ArrayList<InventoryItem> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public Inventory(ArrayList<InventoryItem> items) {
        this.items = items;
    }

    public ArrayList<InventoryItem> all() {
        return this.items;
    }

    public void store(InventoryItem item) {
        this.items.add(item);
    }

    public boolean destroy(int index) {
        if (index >= 0 && index < this.items.size()) {
            this.items.remove(index);
            return true;
        }

        return false;
    }

    public InventoryItem find(int index) {
        if (index >= 0 && index < this.items.size()) {
            return this.items.get(index);
        }

        return null;
    }
}

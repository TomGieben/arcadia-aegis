package org.arcadia.aegis.inventory;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<InventoryItem> items;

    /*
    * Constructor
    */
    public Inventory() {
        this.items = new ArrayList<>();
    }

    /*
    * Constructor
    *
    * @param items List of items to initialize the inventory with
    */
    public Inventory(ArrayList<InventoryItem> items) {
        this.items = items;
    }

    /*
    * Get all items in the inventory
    *
    * @return ArrayList<InventoryItem> All items in the inventory
    */
    public ArrayList<InventoryItem> all() {
        return this.items;
    }

    /*
    * Store an item in the inventory
    *
    * @param item The item to store
    * @return void
    */
    public void store(InventoryItem item) {
        this.items.add(item);
    }

    /*
    * Destroy an item in the inventory
    *
    * @param The item to destroy
    * @return boolean True if the item was destroyed, false otherwise
    */
    public boolean destroy(InventoryItem item) {
        int index = this.items.indexOf(item);

        return this.destroy(index);
    }

    /*
     * Destroy an item in the inventory
     *
     * @param index The index of the item to destroy
     * @return boolean True if the item was destroyed, false otherwise
     */
    public boolean destroy(int index) {
        if (index >= 0 && index < this.items.size()) {
            this.items.remove(index);
            return true;
        }

        return false;
    }

    /*
    * Find an item in the inventory
    *
    * @param index The index of the item to find
    * @return InventoryItem The item at the given index, or null if the index is out of bounds
    */
    public InventoryItem find(int index) {
        if (index >= 0 && index < this.items.size()) {
            return this.items.get(index);
        }

        return null;
    }
}

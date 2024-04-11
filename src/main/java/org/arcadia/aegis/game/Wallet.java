package org.arcadia.aegis.game;

public class Wallet {
    private float amount;

    /*
    * Constructor
    *
    * @param amount The amount of the wallet
    */
    public Wallet(float amount) {
        this.amount = amount;
    }

    /*
    * Deposit money into the wallet
    *
    * @param amount The amount to deposit
    * @return float The amount of the wallet
    */
    public float deposit(float amount) {
        this.amount += amount;

        return this.amount;
    }

    /*
    * Withdraw money from the wallet
    *
    * @param amount The amount to withdraw
    * @return float The amount of the wallet
    */
    public float withdraw(float amount) {
        this.amount -= amount;

        return this.amount;
    }

    /*
    * Get the amount of the wallet
    *
    * @return float The amount of the wallet
    */
    public float getAmount() {
        return this.amount;
    }
}

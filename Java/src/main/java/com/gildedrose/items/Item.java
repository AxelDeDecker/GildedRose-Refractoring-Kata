package com.gildedrose.items;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public static int MIN_QUALITY = 0;

    public static int MAX_QUALITY = 50;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        this.sellIn -= 1;
        if (this.quality > MIN_QUALITY) {
            if (this.sellIn >= 0) {
                this.quality -= 1;
            }
            else {
                this.quality = Math.max(this.quality - 2, MIN_QUALITY);
            }
        }
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}

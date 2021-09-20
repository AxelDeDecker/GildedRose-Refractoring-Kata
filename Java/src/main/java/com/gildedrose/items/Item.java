package com.gildedrose.items;

public class Item {

    // the name of the Item
    public String name;

    // the number of days left to sell the Item
    public int sellIn;

    // the quality of the Item
    public int quality;

    // the lower threshold for the quality of an Item
    public static int MIN_QUALITY = 0;

    // the upper threshold for the quality of an Item
    public static int MAX_QUALITY = 50;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    /*
    The quality of an Item decreases by 1 each day while there are still days left to sell it.
    After the deadline has passed, it decreases by 2 each day. The quality can't drop below the lower threshold.
    The behaviour of this method needs to be different for 'special' Items, so the method is overridden
    in each subclass that inherits from the Item class.
     */
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

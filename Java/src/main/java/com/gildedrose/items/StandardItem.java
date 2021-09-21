package com.gildedrose.items;

import com.gildedrose.Item;

public class StandardItem extends Item {

    // the lower threshold for the quality of an Item
    public static int MIN_QUALITY = 0;

    // the upper threshold for the quality of an Item
    public static int MAX_QUALITY = 50;

    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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

}

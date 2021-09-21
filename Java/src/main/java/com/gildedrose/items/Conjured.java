package com.gildedrose.items;

public class Conjured extends StandardItem {

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /*
    The quality of a Conjured item decreases twice as fast as of a 'standard' Item:
    it decreases by 2 each day before the deadline to sell it; after the deadline has passed,
    it decreases by 4 each day. The quality can't drop below the lower threshold.
     */
    public void updateQuality() {
        this.sellIn -= 1;
        if (this.quality > MIN_QUALITY) {
            int decrement = 2;
            if (this.sellIn < 0) {
                decrement = 4;
            }
            this.quality = Math.max(this.quality - decrement, MIN_QUALITY);
        }
    }

}

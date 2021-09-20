package com.gildedrose.items;

public class Conjured extends Item {

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

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

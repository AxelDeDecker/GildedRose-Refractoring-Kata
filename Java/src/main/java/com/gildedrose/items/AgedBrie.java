package com.gildedrose.items;

public class AgedBrie extends StandardItem {

    private final static String NAME = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /*
    The quality of an Aged Brie item increases by 1 each day
    regardless of whether the deadline to sell it has passed or not,
    until it reaches the upper threshold.
     */
    public void updateQuality() {
        this.sellIn -= 1;
        if (this.quality < MAX_QUALITY) {
            this.quality += 1;
        }
    }

}

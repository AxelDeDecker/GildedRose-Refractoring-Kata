package com.gildedrose.items;

public class AgedBrie extends Item {

    private final static String NAME = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        this.sellIn -= 1;
        if (this.quality < MAX_QUALITY) {
            this.quality += 1;
        }
    }

}

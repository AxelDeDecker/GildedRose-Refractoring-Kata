package com.gildedrose.items;

public class BackstagePasses extends Item {

    private final static String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        this.sellIn -= 1;
        if (this.sellIn < 0) {
            this.quality = MIN_QUALITY;
        }
        else {
            if (this.quality < MAX_QUALITY) {
                int increment = 1;
                if (this.sellIn < 5) {
                    increment = 3;
                }
                else if (this.sellIn < 10) {
                    increment = 2;
                }
                this.quality = Math.min(this.quality + increment, MAX_QUALITY);
            }
        }
    }

}

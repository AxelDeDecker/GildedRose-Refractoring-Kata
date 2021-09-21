package com.gildedrose.items;

public class BackstagePasses extends StandardItem {

    private final static String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /*
    The quality of a BackstagePasses item increases by 1 each day while there are 10 or more days left to sell it,
    it increases by 2 if there are less than 10 days but more or equal to 5 days left to sell it,
    it increases by 3 if there are less than 5 days to sell it. The quality can't get higher than the upper threshold.
    If the deadline to sell the item has passed, the quality is set to the lower threshold.
     */
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

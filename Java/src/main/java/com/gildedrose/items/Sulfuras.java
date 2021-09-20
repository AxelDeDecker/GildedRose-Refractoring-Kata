package com.gildedrose.items;

public class Sulfuras extends Item {

    private final static String NAME = "Sulfuras, Hand of Ragnaros";

    private final static int MAX_QUALITY = 80;

    public Sulfuras(int sellIn) {
        super(NAME, sellIn, MAX_QUALITY);
    }

    public Sulfuras(String name, int sellIn) {
        super(name, sellIn, MAX_QUALITY);
    }

    /*
    The quality of a Sulfuras item or the deadline to sell it never change.
     */
    public void updateQuality() {

    }

}

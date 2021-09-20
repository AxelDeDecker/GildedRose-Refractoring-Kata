package com.gildedrose;

import com.gildedrose.items.*;

public class ItemFactory {

    public static String AGED_BRIE = "Aged Brie";

    public static String BACKSTAGE_PASSES = "Backstage passes";

    public static String SULFURAS = "Sulfuras";

    public static String CONJURED = "Conjured";

    public ItemFactory() {}

    /*
    The factory method instantiates an object of the appropriate subclass, based on information provided by the client.
    In this case, the information is the name of the item.
    Note that this does make some assumptions about the item names,
    for example that certain terms are mutually exclusive.
     */
    public Item createItem(String name, int sellIn, int quality) {
        Item item;
        // check for special items
        if (name.contains(AGED_BRIE)) {
            item = new AgedBrie(name, sellIn, quality);
        }
        else if (name.contains(BACKSTAGE_PASSES)) {
            item = new BackstagePasses(name, sellIn, quality);
        }
        else if (name.contains(SULFURAS)) {
            item = new Sulfuras(name, sellIn);
        }
        else if (name.contains(CONJURED)) {
            item = new Conjured(name, sellIn, quality);
        }
        // otherwise, create a standard item
        else {
            item = new Item(name, sellIn, quality);
        }
        return item;
    }

}

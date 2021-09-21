package com.gildedrose;

import com.gildedrose.items.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testStandardItem() {
        Item[] items = new Item[] {new StandardItem("Item 0", 1, 3)};
        GildedRose app = new GildedRose(items);
        // test if the quality of the item decreases by 1 if the deadline hasn't passed
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(2, items[0].quality);
        // test if the quality of the item decreases by 2 if the deadline has passed
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
        // test if the quality of the item can't become smaller than the minimum quality
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testAgedBrie() {
        Item[] items = new Item[] {new AgedBrie(1, 48)};
        GildedRose app = new GildedRose(items);
        // test if the quality of the item increases by 1 each day
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(49, items[0].quality);
        // test if the quality of the item increases by 1 each day, after the deadline has passed
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(50, items[0].quality);
        // test if the quality of the item can't become higher than the maximum quality
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void testBackStagePasses() {
        Item[] items = new Item[] {new BackstagePasses(12, 0), new BackstagePasses(1, 50)};
        GildedRose app = new GildedRose(items);
        // test if the quality of the item increases by 1 if the deadline approaches but is still more than 10 days away
        app.updateQuality();
        assertEquals(11, items[0].sellIn);
        assertEquals(1, items[0].quality);
        // test if the quality can't become higher than the maximum quality of 50
        assertEquals(0, items[1].sellIn);
        assertEquals(50, items[1].quality);
        // test if the quality of the item increases by 2 if the deadline is 10 or less but more than 5 days away
        for (int i = 0; i < 5; i++) {
            app.updateQuality();
            assertEquals(10 - i, items[0].sellIn);
            assertEquals(2 + 2 * i, items[0].quality);
        }
        // test if the quality of the item increases by 3 if the deadline is 5 or less days away
        for (int i = 0; i < 6; i++) {
            app.updateQuality();
            assertEquals(5 - i, items[0].sellIn);
            assertEquals(12 + 3 * i, items[0].quality);
        }
        // test if the quality of the item becomes 0 if the deadline has passed
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testSulfurasItem() {
        Item[] items = new Item[] {new Sulfuras(0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        // test if the deadline and quality of the item never change
        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void testConjuredItem() {
        Item[] items = new Item[] {new Conjured("Conjured Mana Cake", 1, 7)};
        GildedRose app = new GildedRose(items);
        // test if the quality of the item decreases by 2 each day if the deadline hasn't passed
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(5, items[0].quality);
        // test if the quality of the item decreases by 4 each day if the deadline has passed
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(1, items[0].quality);
        // test if the quality can't become lower than the minimum quality of 0
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

}

package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        ItemFactory factory = new ItemFactory();

        Item[] items = new Item[] {
                factory.createItem("+5 Dexterity Vest", 10, 20), //
                factory.createItem("Aged Brie", 2, 0), //
                factory.createItem("Elixir of the Mongoose", 5, 7), //
                factory.createItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                factory.createItem("Sulfuras, Hand of Ragnaros", -1, 80),
                factory.createItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                factory.createItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                factory.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                factory.createItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}

package be.xplore.kdg.checkstyle;

class MethodLength {
    /**
     * Code taken from the Gilded Rose Kata.
     * https://github.com/emilybache/GildedRose-Refactoring-Kata/tree/main/Java
     */
    class GildedRose {
        Item[] items;

        public GildedRose(MethodLength.Item[] items) {
            this.items = items;
        }

        public void updateQuality() {
            for (int i = 0; i < items.length; i++) {
                if (!items[i].name.equals("Aged Brie")
                        && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (items[i].quality > 0) {
                        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;

                        if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (items[i].sellIn < 11) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }

                            if (items[i].sellIn < 6) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }
                        }
                    }
                }

                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    items[i].sellIn = items[i].sellIn - 1;
                }

                if (items[i].sellIn < 0) {
                    if (!items[i].name.equals("Aged Brie")) {
                        if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (items[i].quality > 0) {
                                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                    items[i].quality = items[i].quality - 1;
                                }
                            }
                        } else {
                            items[i].quality = items[i].quality - items[i].quality;
                        }
                    } else {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            }
        }
    }

    class Item {

        public String name;

        public int sellIn;

        public int quality;

        public Item(String name, int sellIn, int quality) {
            this.name = name;
            this.sellIn = sellIn;
            this.quality = quality;
        }

        @Override
        public String toString() {
            return this.name + ", " + this.sellIn + ", " + this.quality;
        }
    }
}

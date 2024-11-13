package com.gildedrose;

class GildedRose {
    Item[] items;
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public GildedRose(Item[] items) {
        this.items = items;
    }
    public void decreaseQuality(Item item) {
        if (item.quality > 0 && !item.name.equals(SULFURAS)) {
            item.quality = item.quality - 1;
        }
    }
    public void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void increaseQualityIfSellInLessThan(Item item, int sellInThreshold) {
        if (item.sellIn < sellInThreshold && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void updateQualityForExpiredItem(Item item) {
        if (!item.name.equals("Aged Brie")) {
            if (!item.name.equals(BACKSTAGE)) {
                decreaseQuality(item);
            } else {
                item.quality = 0;
            }
        } else {
            increaseQuality(item);
        }
    }


    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals(BACKSTAGE)) {
                decreaseQuality(item);

            } else {
                increaseQuality(item);
                    if (item.name.equals(BACKSTAGE)) {
                        increaseQualityIfSellInLessThan(item, 11);
                        increaseQualityIfSellInLessThan(item, 6);
                    }
                }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                updateQualityForExpiredItem(item);
            }
        }
    }
}

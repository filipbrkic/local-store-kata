package org.example.store.inventory;

public class Application {

    Item[] items;

    public Application(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(items[i]);
            updateSellIn(items[i]);
            handleExpiredItem(items[i]);
        }
    }

    private void updateItemQuality(Item item) {
        if (isNormalItem(item)) {
            decreaseQuality(item);
        } else if (isAgedBrie(item) || isEventTicket(item)) {
            increaseQuality(item);
            if (isEventTicket(item)) {
                handleEventTicketQuality(item);
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!isTheBestStoreAward(item)) {
            item.sellIn--;
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.sellIn < 0) {
            if (isNormalItem(item)) {
                decreaseQuality(item);
            } else if (isAgedBrie(item)) {
                increaseQuality(item);
            } else if (isEventTicket(item)) {
                item.quality = 0;
            } else if (isPerishablePork(item)) {
                decreaseQuality(item, 4);
                if (item.quality < 0) {
                    item.quality = 0;
                }
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void handleEventTicketQuality(Item item) {
        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality -= amount;
    }

    private boolean isNormalItem(Item item) {
        return !isAgedBrie(item) && !isEventTicket(item) && !isTheBestStoreAward(item) && !isPerishablePork(item);
    }

    private boolean isAgedBrie(Item item) {
        return "Aged Brie".equals(item.name);
    }

    private boolean isEventTicket(Item item) {
        return "Event Tickets".equals(item.name);
    }

    private boolean isTheBestStoreAward(Item item) {
        return "The Best Store in Town Award".equals(item.name);
    }

    private boolean isPerishablePork(Item item) {
        return "Perishable Pork".equals(item.name);
    }
}

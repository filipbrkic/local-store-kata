package org.example.store.inventory;

public class Fixture {
    public static void main(String[] args) {
        Item[] items = new Item[] {
                new Item("Lactose-Free Milk", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Frozen Pepperoni Pizza", 5, 7), //
                new Item("The Best Store in Town Award", 0, 80), //
                new Item("The Best Store in Town Award", -1, 80),
                new Item("Event Tickets", 15, 20),
                new Item("Event Tickets", 10, 49),
                new Item("Event Tickets", 5, 49),
                // this perishable item does not work properly yet
                new Item("Perishable Pork", 3, 6) };

        Application app = new Application(items);

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

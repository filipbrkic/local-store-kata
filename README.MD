# Local Grocery Store Inventory Management
Hello and welcome to the Local Grocery Store. We are a small, neighborhood grocery store with a great reputation for providing fresh and high-quality products. We take pride in buying and selling only the finest goods. However, like any other store, our goods need careful management as they approach their sell-by date. We have a system in place that automates inventory updates for us. This system was originally developed by a pragmatic programmer Bob but he left the company recently. Your task is to enhance our system to support a new category of items we want to introduce.

### Let's begin with an overview of our inventory management system:
* Each item in our store has a "SellIn" value, indicating the number of days remaining until we can sell the item.
* All items also have a "Quality" value, representing how valuable the item is.
* At the end of each day, our system automatically reduces both the "SellIn" and "Quality" values for every item.
* Once an item's sell-by date has passed, its "Quality" degrades twice as fast.
* The "Quality" of an item is never allowed to be negative.
* For items like "Aged Brie," the older it gets, the higher its "Quality" becomes.
* However, the "Quality" of an item can never exceed 50.
* There are special items not-for-sale items, such as “The Best Store in Town Award“, which never need to be sold and maintain a constant quality.
* In addition to groceries, we also sell local event tickets. “Event Tickets”, like "Aged Brie," increase in quality as the event date approaches. The quality increases by 2 when there are 10 days or less, and by 3 when there are 5 days or less. However, the quality drops to 0 after the event.
  Now, we have recently partnered with a supplier who provides us with “Perishable" items. These items require some adjustments in our system:
* "Perishable" items degrade in quality twice as fast as normal items.
  
You are free to make any necessary changes to the "UpdateQuality" method and add new code to accommodate these rules while ensuring that everything works correctly. However, please refrain from altering the "Item" class or the "Items" property, as they are part of a third-party library which is read-only and we don't own it. If needed, you can make the "UpdateQuality" method and "Items" property static for your convenience.

For clarity, an item's quality can never exceed 50, except "The Best Store in Town Award," an item with a constant quality of 80 that never changes.

Bob also left instructions on how to test this app:
1. Run Fixture with argument 30
2. open www.diffchecker.com
3. Copy there the program output and the contents of the approval-test-expected file
4. All is well if there is no difference

Very handy, much better than manually checking line by line!

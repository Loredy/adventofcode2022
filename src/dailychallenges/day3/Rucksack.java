package dailychallenges.day3;

import java.util.ArrayList;
import java.util.List;

public class Rucksack {
    private String itemsString;
    private List<Item> items = new ArrayList<>();
    private Item item1;
    private Item item2;

    public Rucksack() {

    }

    public Rucksack(String itemsString, Item item1, Item item2) {
        this.itemsString = itemsString;
        this.item1 = item1;
        this.item2 = item2;
    }

    //region Getters/Setters
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    public Item getItem2() {
        return item2;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    public String getItemsString() {
        return itemsString;
    }

    public void setItemsString(String itemsString) {
        this.itemsString = itemsString;
    }

    //endregion
}

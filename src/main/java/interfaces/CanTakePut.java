package interfaces;

import items.Item;

public interface CanTakePut {
    String getName();
    void addItems(Item... items);
}

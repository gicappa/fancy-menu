package gk.menu;

import java.util.ArrayList;
import java.util.List;

public class RootMenuItem implements MenuItem {
    private final List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public List<MenuItem> getItems() {
        return items;
    }
}

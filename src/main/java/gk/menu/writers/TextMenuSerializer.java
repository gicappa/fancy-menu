package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuSerializer;
import gk.menu.RootItem;

public class TextMenuSerializer implements MenuSerializer {

    @Override
    public String serializeItem(MenuItem item) {
        return serializeItem(item, 0);
    }

    public String serializeItem(MenuItem item, int level) {

        if (item instanceof RootItem) {
            return serializeChildren(item, level);
        }

        // This a normal Container Menu Item or a Leaf Menu Item
        if (!item.getItems().isEmpty())
            return padding(level - 1) + " + " + serializeItemName(item) + "\n" + serializeChildren(item, level);

        return padding(level - 1) + serializeItemName(item) + "\n" + serializeChildren(item, level);
    }

    private String serializeItemName(MenuItem item) {
        return item.getName() + (item.getUrl() == null ? "" : " [" + item.getUrl() + "]");
    }

    private String serializeChildren(MenuItem item, int level) {
        // This is a Leaf Menu Item
        if (item.getItems().isEmpty()) {
            return "";
        }

        StringBuilder child = new StringBuilder();

        for (MenuItem i : item.getItems()) {
            child.append(serializeItem(i, level + 1));
        }

        return child.toString();
    }

    private String padding(int level) {
        return "   ".repeat(level);
    }
}

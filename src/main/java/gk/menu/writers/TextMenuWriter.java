package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuWriter;

public class TextMenuWriter implements MenuWriter {
    @Override
    public String writeItem(MenuItem item, int level) {

        // This a RootMenuItem
        if (item.getName().isBlank()) {
            return writeChildren(item, level);
        }

        // This a normal Container Menu Item or a Leaf Menu Item
        if (!item.getItems().isEmpty())
            return padding(level - 1) + " + " + writeItemName(item) + "\n" + writeChildren(item, level);

        return padding(level - 1) + writeItemName(item) + "\n" + writeChildren(item, level);
    }

    private String writeItemName(MenuItem item) {
        return item.getName() + (item.getUrl() == null ? "" : " [" + item.getUrl() + "]");
    }

    private String writeChildren(MenuItem item, int level) {
        // This is a Leaf Menu Item
        if (item.getItems().isEmpty()) {
            return "";
        }

        StringBuilder child = new StringBuilder();

        for (MenuItem i : item.getItems()) {
            child.append(writeItem(i, level + 1));
        }

        return child.toString();
    }

    private String padding(int level) {
        return "   ".repeat(level);
    }
}

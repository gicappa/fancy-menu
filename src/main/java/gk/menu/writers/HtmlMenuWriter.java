package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuWriter;

public class HtmlMenuWriter implements MenuWriter {

    @Override
    public String writeItem(MenuItem item, int level) {
        // This a RootMenuItem
        if (item.getName().isBlank()) {
            return writeChildren(item, level);
        }

        // This a normal Container Menu Item or a Leaf Menu Item
        return "<li>" + item.getName() + writeChildren(item, level) + "</li>";
    }

    private String writeChildren(MenuItem item, int level) {

        // This is a Leaf Mnu Item
        if (item.getItems().isEmpty()) {
            return "";
        }

        StringBuilder htmlItem = new StringBuilder();
        htmlItem.append("<ul>");

        for (MenuItem i : item.getItems()) {
            htmlItem.append(writeItem(i, level + 1));
        }

        htmlItem.append("</ul>");

        return htmlItem.toString();
    }

}


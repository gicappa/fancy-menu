package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuWriter;

public class HtmlMenuWriter implements MenuWriter {

    @Override
    public String writeItem(MenuItem item, int level) {
        StringBuilder result = new StringBuilder();

        if (!item.getName().isBlank())
            result.append("<li>").append(item.getName());

        result.append(writeChildren(item, level));

        if (!item.getName().isBlank())
            result.append("</li>");

        return result.toString();

    }

    private String writeChildren(MenuItem item, int level) {
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


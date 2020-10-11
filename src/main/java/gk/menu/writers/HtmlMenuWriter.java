package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuWriter;

public class HtmlMenuWriter implements MenuWriter {

    private String htmlMenuItem(MenuItem item, int level) {
        StringBuilder result = new StringBuilder();
        if (!item.getName().isBlank())
            result.append("<li>").append(item.getName());

        if (!item.getItems().isEmpty()) {
            result.append("<ul>");
            for (MenuItem i : item.getItems()) {
                result.append(htmlMenuItem(i, level + 1));
            }
            result.append("</ul>");
        }
        if (!item.getName().isBlank())
            result.append("</li>");
        return result.toString();
    }

    @Override
    public String writeItem(MenuItem item, int level) {

        return htmlMenuItem(item, level);
    }
}


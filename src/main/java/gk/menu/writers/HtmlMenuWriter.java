package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuWriter;

public class HtmlMenuWriter implements MenuWriter {

    @Override
    public String writeItem(MenuItem item, int level) {
        String result = "";

        if (!item.getName().isBlank())
            result += "<li>" + item.getName();

        result += writeChildren(item, level);

        if (!item.getName().isBlank())
            result += "</li>";

        return result;

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


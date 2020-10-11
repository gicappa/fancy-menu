package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuWriter;

import static java.util.stream.Collectors.joining;

public class HtmlMenuWriter implements MenuWriter {

    @Override
    public String writeItem(MenuItem item, int level) {
        return composeMenuItem(item, level) +
                item.visit(mi -> mi.getItems().stream()
                        .map(i -> writeItem(i, level + 1))
                        .collect(joining()));
    }

    private String composeMenuItem(MenuItem item, int level) {
        if (level <= 0)
            return "";

        return "<ul><li>" + item.getName() + "</li></ul>";
    }
}


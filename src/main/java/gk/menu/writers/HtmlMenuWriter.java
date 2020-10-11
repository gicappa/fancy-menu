package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuWriter;

import static java.util.stream.Collectors.joining;

public class HtmlMenuWriter implements MenuWriter {

    @Override
    public String writeItem(MenuItem item, int level) {

        return prefix(item, level) + composeMenuItem(item, level) +
                item.visit(mi -> mi.getItems().stream()
                        .map(i -> writeItem(i, level + 1))
                        .collect(joining())) + suffix(item, level);
    }

    private String suffix(MenuItem item, int level) {
        if (level <= 0)
            return "</ul>";
        return "";
    }

    private String prefix(MenuItem item, int level) {
        if (level <= 0)
            return "<ul>";
        return "";
    }

    private String composeMenuItem(MenuItem item, int level) {
        if (level <= 0)
            return "";

        return "<li>" + item.getName() + "</li>";
    }
}


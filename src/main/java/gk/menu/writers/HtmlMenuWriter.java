package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuWriter;
import gk.menu.RootItem;

import static java.util.stream.Collectors.joining;

public class HtmlMenuWriter implements MenuWriter {


    @Override
    public String writeItem(MenuItem item, int level) {
        if (item instanceof RootItem) {
            return writeRootItem(item, level);
        } else if (isLeafItem(item)) {
            return writeLeafItem(item);
        } else {
            return writeMenuItem(item, level);
        }
    }

    public String writeRootItem(MenuItem item, int level) {
        if (isLeafItem(item))
            return "";

        return writeChildren(item, level);
    }

    private String writeLeafItem(MenuItem item) {
        return "<li>" + item.getName() + "</li>";
    }

    private String writeMenuItem(MenuItem item, int level) {
        return "<li>" + item.getName() + writeChildren(item, level) + "</li>";
    }

    private String writeChildren(MenuItem item, int level) {
        return "<ul>" + htmlItemList(item, level) + "</ul>";
    }

    private String htmlItemList(MenuItem item, int level) {
        return item.getItems().stream()
                .map(i -> writeItem(i, level))
                .collect(joining());
    }

    private boolean isLeafItem(MenuItem item) {
        return item.getItems().isEmpty();
    }


}

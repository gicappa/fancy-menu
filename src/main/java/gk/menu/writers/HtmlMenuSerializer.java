package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuSerializer;
import gk.menu.RootItem;
import gk.menu.Traversal;

public class HtmlMenuSerializer implements MenuSerializer {

    private final Traversal traversal;

    public HtmlMenuSerializer(Traversal traversal) {
        this.traversal = traversal;
    }

    public String serializeItem(MenuItem item) {
        if (item instanceof RootItem)
            return serializeChildren(traversal.traverse(item.getItems(), this::serializeItem));

        return item.visit((n, c) -> "<li>" + n + serializeChildren(traversal.traverse(c, this::serializeItem)) + "</li>");
    }

    private String serializeChildren(String traverse) {
        if (traverse.isBlank())
            return "";

        return "<ul>" + traverse + "</ul>";
    }

}

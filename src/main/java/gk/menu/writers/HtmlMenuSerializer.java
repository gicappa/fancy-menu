package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuSerializer;
import gk.menu.Traversal;

public class HtmlMenuSerializer implements MenuSerializer {

    private final Traversal traversal;

    public HtmlMenuSerializer(Traversal traversal) {
        this.traversal = traversal;
    }

    public String serializeItem(MenuItem item) {
        if (item.getName().isBlank())
            return serializeChildren(traversal.traverse(item, this::serializeItem));

        return "<li>" + item.getName() + serializeChildren(traversal.traverse(item, this::serializeItem)) + "</li>";
    }

    private String serializeChildren(String traverse) {
        if (traverse.isBlank())
            return "";

        return "<ul>" + traverse + "</ul>";
    }

}

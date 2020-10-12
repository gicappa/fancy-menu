package gk.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// Design checks: get name, get url and maybe also getItems are exposing
// the internal of the class. Visitor pattern should avoid them by passing
// them to the visitor
public class MenuItem {
    private final List<MenuItem> children = new ArrayList<>();
    private final String name;
    private String url;

    public MenuItem(String name) {
        this.name = name;
    }

    public MenuItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public void addItem(MenuItem item) {
        children.add(item);
    }

    public List<MenuItem> getItems() {
        return children;
    }

    public String visit(Function<MenuItem, String> v) {
        return v.apply(this);
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return this.name + this.children;
    }
}

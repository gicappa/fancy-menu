package gk.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;

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

    public String traverse(Function<MenuItem, String> f) {
        return getItems().stream().map(f)
                .collect(joining("\n"));
    }

    public String printItem() {
        if (children.isEmpty()) {
            return label();
        } else {
            return " + " + label() + "\n";
        }
    }

    public String label() {
        return name + (url == null ? "" : " [" + url + "]");
    }

    @Override
    public String toString() {
        return printItem();
    }
}

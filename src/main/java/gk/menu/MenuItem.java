package gk.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;

public class MenuItem {
    private final String name;
    private String url;
    private final List<MenuItem> children = new ArrayList<>();

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

    @Override
    public String toString() {
        if (children.isEmpty()) {
            return label();
        } else {
            return " + " + label() + "\n";
        }
    }

    public String label() {
        return name + (url == null ? "" : " [" + url + "]");
    }
}

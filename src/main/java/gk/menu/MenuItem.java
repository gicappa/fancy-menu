package gk.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;

public class MenuItem {
    private final String folder;
    private final List<MenuItem> children = new ArrayList<>();

    public MenuItem(String folder) {
        this.folder = folder;
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
            return folder;
        } else {
            return " + " + folder + "\n";
        }

    }
}

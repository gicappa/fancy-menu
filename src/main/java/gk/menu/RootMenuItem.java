package gk.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;

public class RootMenuItem implements MenuItem {
    private final List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public List<MenuItem> getItems() {
        return items;
    }

    public String traverse(Function<MenuItem, String> f) {
        return getItems().stream().map(f)
                .collect(joining("\n"));
    }
}

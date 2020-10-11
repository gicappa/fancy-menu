package gk.menu;

import static java.util.stream.Collectors.joining;

public class Menu {

    private final MenuItem root = new MenuItem("");

    public void addItem(MenuItem item) {
        root.addItem(item);
    }

    @Override
    public String toString() {
        return root.visit(mi -> mi.getItems().stream().map(i -> printItem(i, 0)).collect(joining("\n")));
    }

    private String printItem(MenuItem item, int level) {
        return prefix(level) + item.printItem() + item.visit(mi -> mi.getItems().stream().map(i -> printItem(i, level + 1)).collect(joining("\n")));
    }

    private String prefix(int level) {
        if (level <= 0)
            return "";

        return "   ".repeat(level);
    }
}

package gk.menu;

import static java.util.stream.Collectors.joining;

public class Menu {

    private final RootMenuItem root = new RootMenuItem();

    public void addItem(MenuItem item) {
        root.addItem(item);
    }

    @Override
    public String toString() {
        return root.getItems().stream()
                .map(this::printMenuItem)
                .collect(joining("\n"));
    }

    private String printMenuItem(MenuItem item) {
        return item.toString() + printChildren(item);
    }

    private String printChildren(MenuItem folder) {
        return folder.getItems().isEmpty() ? "" : "\n" + traverse(folder);
    }

    private String traverse(MenuItem item) {
        return item.getItems().stream().map(this::printMenuItemSecondLevel)
                .collect(joining("\n"));
    }

    private String printMenuItemSecondLevel(MenuItem item) {
        if (item instanceof MenuItemLeaf) {
            return " - " + item.toString();
        }
        return "";
    }

}

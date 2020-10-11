package gk.menu;

public class Menu {

    private final MenuItem root = new MenuItem("");

    public void addItem(MenuItem item) {
        root.addItem(item);
    }

    @Override
    public String toString() {
        return root.traverse(this::printMenuItem);
    }

    private String printMenuItem(MenuItem item) {
        return item.toString() + printChildren(item);
    }

    private String printChildren(MenuItem item) {
        return item.traverse(this::printMenuItemSecondLevel);
    }

    private String printMenuItemSecondLevel(MenuItem item) {
        if (item.getItems().isEmpty()) {
            return " - " + item.toString();
        }
        return "";
    }

}

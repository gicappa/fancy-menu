package gk.menu;

public class Menu {

    private final MenuItem root = new MenuItem("");

    public void addItem(MenuItem item) {
        root.addItem(item);
    }

    @Override
    public String toString() {
        return root.traverse(i -> printItem(i, 0));
    }

    private String printItem(MenuItem item, int level) {
        return prefix(level) + item.toString() + item.traverse(i -> printItem(i, level + 1));
    }

    private String prefix(int level) {
        if (level <= 0)
            return "";

        return " - ";
    }
}

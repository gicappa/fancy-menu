package gk.menu;

public class Menu {

    private final MenuItem root = new MenuItem("");

    private final PlainTextWriter writer = new PlainTextWriter();

    public void addItem(MenuItem item) {
        root.addItem(item);
    }

    public String serialize() {
        return writer.printItem(root, 0);
    }
}

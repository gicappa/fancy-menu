package gk.menu;

public class Menu {

    private final MenuItem root = new MenuItem("");

    private final PlainTextWriter writer;

    public Menu(PlainTextWriter writer) {
        this.writer = writer;
    }

    public void addItem(MenuItem item) {
        root.addItem(item);
    }

    public String serialize() {
        return writer.printItem(root, 0);
    }
}

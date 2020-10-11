package gk.menu;

public class Menu {

    private final MenuItem root = new MenuItem("");

    private final TextMenuWriter writer;

    public Menu(TextMenuWriter writer) {
        this.writer = writer;
    }

    public void addItem(MenuItem item) {
        root.addItem(item);
    }

    public String serialize() {
        return writer.writeItem(root, 0);
    }
}

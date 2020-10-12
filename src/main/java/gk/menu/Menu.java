package gk.menu;

public class Menu {

    private final MenuItem root = new RootItem();

    private final MenuWriter writer;

    public Menu(MenuWriter writer) {
        this.writer = writer;
    }

    public void addItem(MenuItem item) {
        root.addItem(item);
    }

    public String serialize() {
        return writer.writeItem(root, 0);
    }
}

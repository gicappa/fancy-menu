package gk.menu;

public class Menu {

    private final MenuItem root = new RootItem();
    private final MenuSerializer serializer;

    public Menu(MenuSerializer serializer) {
        this.serializer = serializer;
    }

    public void addItem(MenuItem item) {
        root.addItem(item);
    }

    public String serialize() {
        return serializer.serializeItem(root);
    }
}

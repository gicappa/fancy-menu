package gk.menu;

public class MenuItemLeaf implements MenuItem {
    private final String name;

    public MenuItemLeaf(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

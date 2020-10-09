package gk.menu;

public class MenuItem {
    private final String name;

    public MenuItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

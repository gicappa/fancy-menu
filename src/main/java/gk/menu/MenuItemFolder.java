package gk.menu;

public class MenuItemFolder implements MenuItem {
    private final String submenu;

    public MenuItemFolder(String submenu) {
        this.submenu = submenu;
    }

    @Override
    public String toString() {
        return submenu;
    }
}

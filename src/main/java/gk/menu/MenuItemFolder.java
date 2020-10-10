package gk.menu;

public class MenuItemFolder implements MenuItem {
    private final String folder;

    public MenuItemFolder(String folder) {
        this.folder = folder;
    }

    @Override
    public String toString() {
        return " - " + folder;
    }
}

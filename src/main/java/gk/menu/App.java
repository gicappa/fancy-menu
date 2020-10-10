package gk.menu;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addItem(new MenuItemLeaf("item1"));
        menu.addItem(new MenuItemLeaf("item2"));

        MenuItemFolder folder1 = new MenuItemFolder("folder1");
        folder1.addItem(new MenuItemLeaf("sub item1"));
        folder1.addItem(new MenuItemLeaf("sub item2"));

        menu.addItem(folder1);

        System.out.println(menu);
    }
}

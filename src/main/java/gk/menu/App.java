package gk.menu;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addItem(new MenuItemFolder("item1"));
        menu.addItem(new MenuItemFolder("item2"));

        MenuItemFolder folder1 = new MenuItemFolder("folder1");
        folder1.addItem(new MenuItemFolder("sub item1"));
        folder1.addItem(new MenuItemFolder("sub item2"));

        menu.addItem(folder1);

        System.out.println(menu);
    }
}

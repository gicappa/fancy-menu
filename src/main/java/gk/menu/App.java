package gk.menu;

import gk.menu.writers.TextMenuWriter;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Menu menu = new Menu(new TextMenuWriter());
        menu.addItem(new MenuItem("item1"));
        menu.addItem(new MenuItem("item2"));

        MenuItem folder1 = new MenuItem("folder1");
        folder1.addItem(new MenuItem("sub item1"));
        folder1.addItem(new MenuItem("sub item2"));

        menu.addItem(folder1);

        System.out.println(menu);
    }
}

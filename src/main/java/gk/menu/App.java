package gk.menu;

import gk.menu.writers.HtmlMenuWriter;
import gk.menu.writers.TextMenuWriter;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Traversal t = new Traversal();
        Menu menu = new Menu(new HtmlMenuWriter(t));
        menu.addItem(new MenuItem("item1"));
        menu.addItem(new MenuItem("item2"));

        MenuItem folder1 = new MenuItem("folder1");
        MenuItem sub_item1 = new MenuItem("sub item1");
        folder1.addItem(sub_item1);
        folder1.addItem(new MenuItem("sub item2"));

        MenuItem folder2 = new MenuItem("folder2");
        folder2.addItem(new MenuItem("sub item1"));
        folder2.addItem(new MenuItem("sub item2"));

        sub_item1.addItem(folder2);
        menu.addItem(folder1);

        System.out.println(menu.serialize());
    }
}

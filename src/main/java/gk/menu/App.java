package gk.menu;

import gk.menu.writers.HtmlMenuSerializer;

import javax.swing.text.html.HTMLEditorKit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MenuItem root = new RootItem();
        root.addItem(new MenuItem("item1"));
        root.addItem(new MenuItem("item2"));

        MenuItem folder1 = new MenuItem("folder1");
        MenuItem sub_item1 = new MenuItem("sub item1");
        folder1.addItem(sub_item1);
        folder1.addItem(new MenuItem("sub item2"));

        MenuItem folder2 = new MenuItem("folder2");
        folder2.addItem(new MenuItem("sub item1"));
        folder2.addItem(new MenuItem("sub item2"));

        sub_item1.addItem(folder2);
        root.addItem(folder1);

        HtmlMenuSerializer serializer = new HtmlMenuSerializer(new Traversal());

        System.out.println(serializer.serializeItem(root));
    }
}

package gk.menu.writers;

import gk.menu.MenuItem;
import gk.menu.MenuWriter;
import gk.menu.Traversal;

public class HtmlMenuWriter implements MenuWriter {

    private final Traversal traversal;

    public HtmlMenuWriter(Traversal traversal) {
        this.traversal = traversal;
    }

    public String writeItem(MenuItem item) {
        if (item.getName().isBlank())
            return wrapChildren(traversal.traverse(item, this::writeItem));

        return "<li>" + item.getName() + wrapChildren(traversal.traverse(item, this::writeItem)) + "</li>";
    }

    private String wrapChildren(String traverse) {
        if (traverse.isBlank())
            return "";

        return "<ul>" + traverse + "</ul>";
    }

    //    @Override
//    public String writeItem(MenuItem item) {
//        if (item instanceof RootItem) {
//            return writeRootItem(item, level);
//        } else if (isLeafItem(item)) {
//            return writeLeafItem(item);
//        } else {
//            return writeMenuItem(item, level);
//        }
//    }

//    public String writeRootItem(MenuItem item, int level) {
//        if (isLeafItem(item))
//            return "";
//
//        return writeChildren(item, level);
//    }
//
//    private String writeLeafItem(MenuItem item) {
//        return "<li>" + item.getName() + "</li>";
//    }
//
//    private String writeMenuItem(MenuItem item, int level) {
//        return "<li>" + item.getName() + writeChildren(item, level) + "</li>";
//    }
//
//    private String writeChildren(MenuItem item, int level) {
//        return "";
//    }
//
//    private String htmlItemList(MenuItem item, int level) {
//        return item.getItems().stream()
//                .map(i -> writeItem(i, level))
//                .collect(joining());
//    }
//
//    private boolean isLeafItem(MenuItem item) {
//        return item.getItems().isEmpty();
//    }

}

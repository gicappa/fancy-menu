package gk.menu;

import static java.util.stream.Collectors.joining;

public class TextMenuWriter implements MenuWriter {

    @Override
    public String writeItem(MenuItem item, int level) {
        return prefix(level) +
                printLabel(item, level) +
                item.visit(mi -> mi.getItems().stream()
                        .map(i -> writeItem(i, level + 1))
                        .collect(joining("\n")));
    }

    private String printLabel(MenuItem item, int level) {
        if (level == 0)
            return "";

        if (item.getItems().isEmpty()) {
            return label(item);
        } else {
            return " + " + label(item) + "\n";
        }
    }

    private String label(MenuItem item) {
        return item.getName() + (item.getUrl() == null ? "" : " [" + item.getUrl() + "]");
    }


    public String prefix(int level) {
        if (level <= 1)
            return "";

        return "   ".repeat(level - 1);
    }

}

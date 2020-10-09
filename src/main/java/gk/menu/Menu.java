package gk.menu;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;

public class Menu {

    private final List<String> names = new ArrayList<>();

    public void addItem(String name) {
        this.names.add(name);
    }

    @Override
    public String toString() {
        return join("\n", names);
    }

    public void addSubmenu(String submenu, String subitem) {
        
    }
}

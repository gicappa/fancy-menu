package gk.menu;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Menu {

    private final List<MenuItem> names = new ArrayList<>();

    public void addItem(MenuItem name) {
        this.names.add(name);
    }
    
    @Override
    public String toString() {
        return names.stream()
                .map(MenuItem::toString)
                .collect(joining("\n"));
    }

}

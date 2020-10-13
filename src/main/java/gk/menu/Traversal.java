package gk.menu;

import java.util.function.Function;

import static java.util.stream.Collectors.joining;

public class Traversal {

    public String traverse(MenuItem item, Function<MenuItem, String> f) {
        return item.getItems().stream().map(f).collect(joining());
    }
}

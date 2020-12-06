package gk.menu;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;

public class Traversal {

    public String traverse(List<MenuItem> items, Function<MenuItem, String> f) {
        return items.stream().map(f).collect(joining());
    }
}

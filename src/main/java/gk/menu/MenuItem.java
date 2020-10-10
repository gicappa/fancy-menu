package gk.menu;

import java.util.List;
import java.util.function.Function;

public interface MenuItem {
    List<MenuItem> getItems();

    String traverse(Function<MenuItem, String> f);
}

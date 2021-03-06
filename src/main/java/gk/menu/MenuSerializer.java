package gk.menu;

import java.util.function.BiFunction;
import java.util.function.Function;

// The writers have specific code for:
// - root folder
// - leaf folder
// - node folder
// It could ease the design to create a strategy
// that passes the correct visitor ItemWriter to the tree and after
// collecting all the results joining them in a single string
public interface MenuSerializer {
    String serializeItem(MenuItem item);
}

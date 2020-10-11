package gk.menu;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrintingHtmlMenuTest {

    private Menu menu;

    @Before
    public void before() {
        menu = new Menu();
    }

    @Test
    public void it_should_return_an_empty_menu() {
        assertEquals("", menu.toString());
    }

    @Test
    @Ignore
    public void it_should_return_a_menu_item_name() {
        menu.addItem(new MenuItem("my item name"));

        assertEquals("<ul><li>my item name</li></ul>", menu.toString());
    }

}




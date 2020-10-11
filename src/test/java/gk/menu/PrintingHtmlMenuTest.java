package gk.menu;

import gk.menu.writers.HtmlMenuWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrintingHtmlMenuTest {

    private Menu menu;

    @Before
    public void before() {
        menu = new Menu(new HtmlMenuWriter());
    }

    @Test
    public void it_should_return_an_empty_menu() {
        assertEquals("", menu.serialize());
    }

    @Test
    public void it_should_return_a_menu_item_name() {
        menu.addItem(new MenuItem("my item name"));

        assertEquals("<ul><li>my item name</li></ul>", menu.serialize());
    }

    @Test
    public void it_should_return_two_menu_item_name() {
        menu.addItem(new MenuItem("item1"));
        menu.addItem(new MenuItem("item2"));

        assertEquals("<ul><li>item1</li><li>item2</li></ul>", menu.serialize());
    }

}




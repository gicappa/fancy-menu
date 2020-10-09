package gk.menu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {

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
    public void it_should_return_a_menu_item_name() {
        menu.addItem(new MenuItem("my item name"));

        assertEquals("my item name", menu.toString());
    }

    @Test
    public void it_should_return_two_menu_item_name() {
        menu.addItem(new MenuItem("item1"));
        menu.addItem(new MenuItem("item2"));

        assertEquals("item1\nitem2", menu.toString());
    }

    //    @Test
    public void it_should_return_two_menu_item() {
        menu.addItem(new MenuItem("item1"));
        menu.addItem(new MenuItem("item2"));
        menu.addSubmenu("submenu", "subitem1");

        assertEquals("item1\nitem2\nsubmenu\n\tsubitem1", menu.toString());
    }
}




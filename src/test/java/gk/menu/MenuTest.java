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
        menu.addItem(new MenuItemFolder("my item name"));

        assertEquals("my item name", menu.toString());
    }

    @Test
    public void it_should_return_two_menu_item_name() {
        menu.addItem(new MenuItemFolder("item1"));
        menu.addItem(new MenuItemFolder("item2"));

        assertEquals("item1\nitem2", menu.toString());
    }

    @Test
    public void it_should_return_two_menu_item() {
        menu.addItem(new MenuItemFolder("item1"));
        menu.addItem(new MenuItemFolder("item2"));
        menu.addItem(new MenuItemFolder("folder1"));

        assertEquals("item1\nitem2\nfolder1", menu.toString());
    }

    @Test
    public void it_should_return_two_menu_item_and_one_subfolder() {
        menu.addItem(new MenuItemFolder("item1"));
        menu.addItem(new MenuItemFolder("item2"));

        MenuItemFolder folder1 = new MenuItemFolder("folder1");
        folder1.addItem(new MenuItemFolder("sub item1"));
        folder1.addItem(new MenuItemFolder("sub item2"));

        menu.addItem(folder1);

        assertEquals("item1\nitem2\n + folder1\n - sub item1\n - sub item2", menu.toString());
    }
}




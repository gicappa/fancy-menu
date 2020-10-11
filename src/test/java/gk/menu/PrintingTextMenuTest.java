package gk.menu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrintingTextMenuTest {

    private Menu menu;

    @Before
    public void before() {
        menu = new Menu(new PlainTextWriter());
    }

    @Test
    public void it_should_return_an_empty_menu() {
        assertEquals("", menu.serialize());
    }

    @Test
    public void it_should_return_a_menu_item_name() {
        menu.addItem(new MenuItem("my item name"));

        assertEquals("my item name", menu.serialize());
    }

    @Test
    public void it_should_return_two_menu_item_name() {
        menu.addItem(new MenuItem("item1"));
        menu.addItem(new MenuItem("item2"));

        assertEquals("item1\nitem2", menu.serialize());
    }

    @Test
    public void it_should_return_two_menu_item() {
        menu.addItem(new MenuItem("item1"));
        menu.addItem(new MenuItem("item2"));
        menu.addItem(new MenuItem("folder1"));

        assertEquals("item1\nitem2\nfolder1", menu.serialize());
    }

    @Test
    public void it_should_return_two_menu_item_and_one_subfolder() {
        menu.addItem(new MenuItem("item1"));
        menu.addItem(new MenuItem("item2"));

        MenuItem folder1 = new MenuItem("folder1");
        folder1.addItem(new MenuItem("sub item1"));
        folder1.addItem(new MenuItem("sub item2"));

        menu.addItem(folder1);

        assertEquals("item1\nitem2\n + folder1\n   sub item1\n   sub item2", menu.serialize());
    }

    @Test
    public void it_should_return_a_three_nested_level_menu() {
        menu.addItem(new MenuItem("item Y"));
        menu.addItem(new MenuItem("item Z"));

        MenuItem containerOne = new MenuItem("containerOne");
        containerOne.addItem(new MenuItem("item one A"));
        containerOne.addItem(new MenuItem("item one B"));


        MenuItem containerTwo = new MenuItem("containerTwo");
        containerTwo.addItem(new MenuItem("item two C"));
        containerTwo.addItem(new MenuItem("item two D"));
        containerOne.addItem(containerTwo);

        menu.addItem(containerOne);

        assertEquals("item Y\nitem Z\n + containerOne\n   item one A\n   item one B" +
                "\n    + containerTwo\n      item two C\n      item two D", menu.serialize());
    }

    @Test
    public void it_should_return_two_menu_item_name_with_their_urls() {
        menu.addItem(new MenuItem("item1", "http://test.org/pippo"));
        menu.addItem(new MenuItem("item2"));

        assertEquals("item1 [http://test.org/pippo]\nitem2", menu.serialize());
    }

}




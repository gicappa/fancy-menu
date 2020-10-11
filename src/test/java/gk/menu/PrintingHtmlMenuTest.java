package gk.menu;

import org.junit.Before;
import org.junit.Ignore;
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

}




package edu.sample.jboss.resteasy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for the {@link Item}.
 * Date: 03/10/2016
 *
 * @author Andrei_Khadziukou
 */
public class ItemTest {

    private Item item = new Item("Descr1", 20);

    @Test
    public void testGetDescription() {
        Assert.assertEquals("Descr1", item.getDescription());
    }

    @Test
    public void testSetDescription() {
        item.setDescription("Descr2");
        Assert.assertEquals("Descr2", item.getDescription());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(20, item.getPrice());
    }

    @Test
    public void testSetPrice() {
        item.setPrice(30);
        Assert.assertEquals(30, item.getPrice());
    }

    @Test
    public void testDefaultConstructor() {
        Item defaultItem = new Item();
        Assert.assertNull(defaultItem.getDescription());
        Assert.assertEquals(0, defaultItem.getPrice());
    }
}

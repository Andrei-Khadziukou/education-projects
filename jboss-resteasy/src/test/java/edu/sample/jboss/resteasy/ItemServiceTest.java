package edu.sample.jboss.resteasy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for the {@link ItemService}.
 * Date: 03/10/2016
 *
 * @author Andrei_Khadziukou
 */
public class ItemServiceTest {

    private ItemService itemService = new ItemService();

    @Test
    public void testGetItem() {
        Item item = itemService.getItem();
        Assert.assertEquals("Short description", item.getDescription());
        Assert.assertEquals(20, item.getPrice());
    }

    @Test
    public void testGetItemArray() {
        Item[] items = itemService.getItemArray();
        Assert.assertEquals(2, items.length);
    }

    @Test
    public void testGetItemList() {

    }

    @Test
    public void testGetItems() {

    }

    @Test
    public void testGetJsonItems() {

    }
}

package edu.sample.jboss.resteasy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * The sample was created based on the http://www.mastertheboss.com/jboss-frameworks/resteasy/resteasy-tutorial
 * tutorial.
 * Date: 03/09/2016
 *
 * @author Andrei_Khadziukou
 */
@Path("tutorial")
public class ItemService {

    @GET
    @Path("item")
    @Produces({"application/xml"})
    public Item getItem() {
        return new Item("Short description", 20);
    }

    @GET
    @Path("itemArray")
    @Produces({"application/xml"})
    public Item[] getItemArray() {
        Item[] items = new Item[2];
        items[0] = new Item("Descr1", 200);
        items[1] = new Item("Descr2", 250);

        return items;
    }

    @GET
    @Path("itemList")
    @Produces("application/xml")
    public List<Item> getItemList() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Descr1", 200));
        items.add(new Item("Descr2", 250));
        items.add(new Item("Descr3", 350));

        return items;
    }

    @GET
    @Path("items")
    @Produces("application/xml")
    public ItemList getItems() {
        return new ItemList(getItemList());
    }

    @GET
    @Path("items")
    @Consumes("application/json")
    @Produces("application/json")
    public ItemList getJsonItems() {
        // use Content-Type: application/json in the request header to say you expect to see response in JSON
        return getItems();
    }

}

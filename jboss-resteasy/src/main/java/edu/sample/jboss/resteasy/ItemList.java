package edu.sample.jboss.resteasy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * The domain class to wrap list of {@link Item} from
 * the http://www.mastertheboss.com/jboss-frameworks/resteasy/resteasy-tutorial tutorial.
 * Date: 03/09/2016
 *
 * @author Andrei_Khadziukou
 */
@XmlRootElement(name = "items")
public class ItemList {

    // don't use @XmlElement here it leads to exception
    private List<Item> items;

    public ItemList() {
    }

    public ItemList(List<Item> items) {
        this.items = items;
    }

    @XmlElement(name = "item")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

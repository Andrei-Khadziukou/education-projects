package edu.sample.jboss.resteasy;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The additional domain class for
 * the http://www.mastertheboss.com/jboss-frameworks/resteasy/resteasy-tutorial tutorial to run samples.
 * Date: 03/09/2016
 *
 * @author Andrei_Khadziukou
 */
@XmlRootElement
public class Item {

    private String description;
    private int price;

    public Item() {
    }

    public Item(String description, int price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

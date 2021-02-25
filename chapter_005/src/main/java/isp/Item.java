package isp;

import java.util.List;

public class Item extends BaseMenuItem {

    public Item(String name, List<Item> leaves) {
        super(name, leaves);
    }

    public Item(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public List<Item> getLeaves() {
        return leaves;
    }
}

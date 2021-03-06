package isp;

import java.util.List;

public class Item extends BaseMenuItem implements Action {

    public Item(String name, List<Item> leaves) {
        super(name, leaves);
    }

    public Item(String name, String action, List<Item> leaves) {
        super(name, action, leaves);
    }

    public Item(String name) {
        super(name);
    }

    public Item(String name, String action) {
        super(name, action);
    }

    public String getName() {
        return name;
    }

    public List<Item> getLeaves() {
        return leaves;
    }

    @Override
    public void doAction() {
        System.out.println(action);
    }
}

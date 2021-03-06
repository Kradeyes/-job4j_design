package isp;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMenuItem {
    String name;
    String action;
    List<Item> leaves = new ArrayList<>();

    public BaseMenuItem(String name, List<Item> leaves) {
        this.name = name;
        this.leaves = leaves;
    }

    public BaseMenuItem(String name, String action, List<Item> leaves) {
        this.name = name;
        this.action = action;
        this.leaves = leaves;
    }

    public BaseMenuItem(String name) {
        this.name = name;
    }

    public BaseMenuItem(String name, String action) {
        this.name = name;
        this.action = action;
    }
}

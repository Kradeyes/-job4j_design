package isp;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        BaseMenu menu = new Menu(
                new Item("Menu", List.of(
                        new Item("1.1", "do something", List.of(
                                new Item("1.1.1", "do something", List.of(
                                        new Item("1.1.1.1", "do something"),
                                        new Item("1.1.1.2"))),
                                new Item("1.1.2"),
                                new Item("1.1.3"))),
                        new Item("1.2", List.of(
                                new Item("1.2.1", List.of(
                                        new Item("1.2.1.1"),
                                        new Item("1.2.1.2")))
                        ))
                ))
        );
        menu.show();
        menu.search("1.1");
        menu.search("1.1.1");
        menu.search("1.1.1.1");
        menu.search("1.1.1.2");
    }
}

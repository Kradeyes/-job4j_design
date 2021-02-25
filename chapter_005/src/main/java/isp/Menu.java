package isp;

public class Menu implements BaseMenu {
    private Item root;

    public Menu(Item root) {
        this.root = root;
    }

    private void innerPrint(Item Item, String tab) {
        tab += tab;
        for (Item e : Item.getLeaves()) {
            System.out.println(tab + " " + e.getName());
            innerPrint(e, tab);
        }
    }

    @Override
    public void show() {
        System.out.println("Menu");
        String tab = "--";
        for (Item e : root.getLeaves()) {
            System.out.println(tab + " " + e.getName());
            innerPrint(e, tab);
        }
    }
}

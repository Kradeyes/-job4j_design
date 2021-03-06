package isp;

public class Menu implements BaseMenu {
    private Item root;

    public Menu(Item root) {
        this.root = root;
    }

    private void innerPrint(Item item, String tab) {
        tab += tab;
        for (Item e : item.getLeaves()) {
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

    @Override
    public void search(String name) {
       innerSearch(root, name);
    }

    public void innerSearch(Item ex, String name) {
        for (Item e : ex.getLeaves()) {
            if (e.getName().equals(name)) {
                if (e.action != null) {
                    e.doAction();
                } else {
                    System.out.println("Empty action");
                }
            } else {
                innerSearch(e, name);
            }
        }
    }
}

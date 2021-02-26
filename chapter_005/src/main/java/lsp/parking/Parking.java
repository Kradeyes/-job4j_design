package lsp.parking;

import java.util.List;

public class Parking implements TryToPark {

    @Override
    public boolean accept(Machine machine) {
        return false;
    }

    @Override
    public boolean acceptAll(List<Machine> allMachine) {
        return false;
    }

    @Override
    public boolean remove(String number) {
        return false;
    }
}

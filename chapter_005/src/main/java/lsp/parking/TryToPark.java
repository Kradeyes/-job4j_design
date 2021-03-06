package lsp.parking;

import java.util.List;

public interface TryToPark {

    boolean accept(Machine machine);

    boolean acceptAll(List<Machine> allMachines);

    boolean remove(String number);
}

package lsp.parking;

import java.util.List;

public interface TryToPark {

    boolean accept(Machine machine);

    boolean acceptAll(List<Machine> allMachine);

    boolean remove(String number);
}

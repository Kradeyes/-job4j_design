package srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HR {
    private Store store;

    public HR(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        List<Employee> sorted = store.findBy(filter).stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                .reversed())
                .collect(Collectors.toList());
        for (Employee employee : sorted) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}

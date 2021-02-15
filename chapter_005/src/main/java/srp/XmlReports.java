package srp;

import org.apache.commons.text.StringEscapeUtils;

import java.util.function.Predicate;

public class XmlReports implements Report {
    private Store store;

    public XmlReports(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<Employees>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<Employee>")
                    .append("<Name>")
                    .append(employee.getName())
                    .append("</Name>")
                    .append("<Salary>")
                    .append(employee.getSalary())
                    .append("</Salary>")
                    .append("</Employee>");
        }
        return text.toString();
    }
}

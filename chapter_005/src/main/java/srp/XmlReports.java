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
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return StringEscapeUtils.escapeXml11(text.toString());
    }
}

package srp;

import org.apache.commons.text.StringEscapeUtils;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProgrammersTest {
    private MemStore store = new MemStore();

    @Test
    public void whenOldGenerated() {
        LocalDate now = LocalDate.now();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Programmers programmers = new Programmers(store);
        String expect = StringEscapeUtils.escapeHtml4("Name; Hired; Fired; Salary;"
                + worker.getName() + ";"
                + worker.getHired() + ";" + worker.getFired() + ";"
                + worker.getSalary() + ";");
        assertThat(programmers.generate(employee -> true), is(expect));
    }
}

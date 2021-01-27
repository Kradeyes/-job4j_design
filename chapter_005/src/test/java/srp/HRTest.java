package srp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.time.LocalDate;

public class HRTest {
    private MemStore store = new MemStore();

    @Test
    public void whenSorted() {
        LocalDate now = LocalDate.now();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee secondWorker = new Employee("Roman", now, now, 200);
        store.add(worker);
        store.add(secondWorker);
        HR hr = new HR(store);
        String expect = "Name; Salary;"
                + secondWorker.getName() + ";"
                + secondWorker.getSalary() + ";"
                + worker.getName() + ";"
                + worker.getSalary() + ";";
        assertThat(hr.generate(employee -> true), is(expect));
    }
}
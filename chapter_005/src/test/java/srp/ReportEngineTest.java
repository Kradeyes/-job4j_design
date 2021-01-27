package srp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.time.LocalDate;

public class ReportEngineTest {
    private MemStore store = new MemStore();

    @Test
    public void whenOldGenerated() {
        LocalDate now = LocalDate.now();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        String expect = "Name; Hired; Fired; Salary;"
                + worker.getName() + ";"
                + worker.getHired() + ";" + worker.getFired() + ";"
                + worker.getSalary() + ";";
        assertThat(engine.generate(employee -> true), is(expect));
    }
}

package srp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.time.LocalDate;

public class BookkeepingTest {
    private MemStore store = new MemStore();

    @Test
    public void whenRubToDollar() {
        LocalDate now = LocalDate.now();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Bookkeeping bookkeeping = new Bookkeeping(store);
        String expect = "Name; Hired; Fired; Salary;"
                + worker.getName() + ";"
                + worker.getHired() + ";" + worker.getFired() + ";"
                + worker.getSalary() / 75 + ";";
        assertThat(bookkeeping.generate(employee -> true), is(expect));
    }
}

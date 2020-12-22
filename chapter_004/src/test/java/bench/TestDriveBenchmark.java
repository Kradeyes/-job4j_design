package bench;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class TestDriveBenchmark {
    private static final String ORIGIN = "Мой дядя самых честных правил, "
            + "Когда не в шутку занемог, "
            + "Он уважать себя заставил "
            + "И лучше выдумать не мог. "
            + "Его пример другим наука; "
            + "Но, боже мой, какая скука "
            + "С больным сидеть и день и ночь, "
            + "Не отходя ни шагу прочь! "
            + "Какое низкое коварство "
            + "Полуживого забавлять, "
            + "Ему подушки поправлять, "
            + "Печально подносить лекарство, "
            + "Вздыхать и думать про себя: "
            + "Когда же черт возьмет тебя!";
    private static final String LINE = "Мой дядя мог думать про тебя и день и ночь";

    @Param({"100", "1000"})
    private int size;

    @Benchmark
    public static void benchmark() {
        Testdrive.generateBy(ORIGIN, LINE);
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(TestDriveBenchmark.class.getSimpleName())
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupIterations(3)
                .measurementIterations(5)
                .param("size", "100", "200", "300")
                .forks(1)
                .mode(Mode.AverageTime)
                .build();

        new Runner(opt).run();
    }
}

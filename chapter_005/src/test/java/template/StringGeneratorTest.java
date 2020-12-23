/*package template;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StringGeneratorTest {
    Generator generator = new  StringGenerator();
    private final String template = "I am a ${name}, Who are ${subject}?";

    @Test
    public void whenArgsEqualKeys() {
        Map<String,String> keys = new HashMap<>();
        keys.put("name", "Roma");
        keys.put("subject", "you");
        String expected = "I am a Roma, Who are you?";
        assertThat(generator.produce(template, keys), is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenKeysMoreThenArgs() {
        Map<String,String> keys = new HashMap<>();
        keys.put("name", "Roma");
        keys.put("subject", "you");
        keys.put("anotherSub", "me");
        generator.produce(template, keys);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenArgsMoreThenKeys() {
        Map<String,String> keys = new HashMap<>();
        keys.put("name", "Roma");
        generator.produce(template, keys);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenArgsNotInTemplate() {
        Map<String,String> keys = new HashMap<>();
        keys.put("name", "Roma");
        keys.put("anotherSub", "me");
        generator.produce(template, keys);
    }
}*/
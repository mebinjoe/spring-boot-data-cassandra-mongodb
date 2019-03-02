package data.mongo;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoAppTests {

    @ClassRule
    public static final OutputCapture output = new OutputCapture();

    @Test
    public void testDefaultSettings() {
        assertThat(output.toString()).contains("firstName='Dada', lastName='Saheeb'");
    }

}

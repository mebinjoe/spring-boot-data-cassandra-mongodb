package data.cassandra;

import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runners.model.Statement;
import java.io.File;
import static org.assertj.core.api.Assertions.assertThat;

@TestExecutionListeners(mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS, listeners = {
        OrderedCassandraTestExecutionListener.class})
@RunWith(SpringRunner.class)
@SpringBootTest
@CassandraDataSet(keyspace = "appkeyspace", value = "src/test/resources/script.cql")
@EmbeddedCassandra(timeout = 60000)
public class CassandraAppTests {

    @ClassRule
    public static final SkipOnWindows skipOnWindows = new SkipOnWindows();

    @ClassRule
    public static final OutputCapture output = new OutputCapture();

    @Test
    public void testDefaultSettings() {
        assertThat(output.toString()).contains("firstName='Dada', lastName='Saheeb'");
    }

    static class SkipOnWindows implements TestRule {

        @Override
        public Statement apply(Statement base, Description description) {
            return new Statement() {

                @Override
                public void evaluate() throws Throwable {
                    if (!runningOnWindows()) {
                        base.evaluate();
                    }
                }

                private boolean runningOnWindows() {
                    return File.separatorChar == '\\';
                }

            };
        }

    }

}

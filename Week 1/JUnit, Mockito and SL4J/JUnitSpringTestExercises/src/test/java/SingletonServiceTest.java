import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertSame;

@SpringJUnitConfig
@ContextConfiguration(classes = {AppConfig.class, SingletonService.class})
public class SingletonServiceTest {

    @Autowired
    private SingletonService service1;

    @Autowired
    private SingletonService service2;

    @Test
    void testSingletonScope() {

        assertSame(service1, service2);

    }
}
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotSame;

public class PrototypeServiceTest {

    @Test
    void testPrototypeScope() {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.register(PrototypeConfig.class);
        context.refresh();

        PrototypeService service1 = context.getBean(PrototypeService.class);
        PrototypeService service2 = context.getBean(PrototypeService.class);

        assertNotSame(service1, service2);

        context.close();
    }
}
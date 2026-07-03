import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
@ContextConfiguration(classes = {AppConfig.class, StudentService.class})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void testAutowiredBean() {

        assertEquals("Shubaashree",
                studentService.getStudentName());

    }
}
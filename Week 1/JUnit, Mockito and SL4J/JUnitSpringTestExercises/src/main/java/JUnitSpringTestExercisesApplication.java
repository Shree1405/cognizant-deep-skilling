import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "")
public class JUnitSpringTestExercisesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JUnitSpringTestExercisesApplication.class, args);
    }
}
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GreetingControllerTest {

    @Test
    void testGreeting() throws Exception {

        GreetingService service = mock(GreetingService.class);

        when(service.greet()).thenReturn("Hello Mockito");

        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(new GreetingController(service))
                .build();

        mockMvc.perform(get("/greet"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Mockito"));
    }
}
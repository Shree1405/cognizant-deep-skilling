import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {

    @Test
    void testGetUser() throws Exception {

        UserService userService = mock(UserService.class);

        when(userService.getUserById(1L))
                .thenReturn(new User(1L, "Shubaashree"));

        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(new UserController(userService))
                .build();

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Shubaashree"));

    }
}
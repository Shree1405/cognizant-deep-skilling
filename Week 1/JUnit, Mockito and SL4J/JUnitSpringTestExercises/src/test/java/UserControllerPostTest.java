import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerPostTest {

    @Test
    void testCreateUser() throws Exception {

        UserService service = mock(UserService.class);

        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(new UserController(service))
                .build();

        String json = """
                {
                  "id":1,
                  "name":"Shubaashree"
                }
                """;

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }
}
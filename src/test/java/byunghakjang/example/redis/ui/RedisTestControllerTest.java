package byunghakjang.example.redis.ui;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import byunghakjang.example.redis.utils.MockMvcControllerTest;

@DisplayName("컨트롤러 테스트")
@WebMvcTest(controllers = RedisTestController.class)
class RedisTestControllerTest extends MockMvcControllerTest {
    private static final String API_URL = "/api/redis";

    @Autowired
    private RedisTestController redisTestController;

    @Override
    protected Object controller() {
        return redisTestController;
    }

    @Test
    @DisplayName("컨트롤러 기본 동작 테스트")
    void controller_default_test() throws Exception {
        // then
        mockMvc.perform(get(API_URL))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

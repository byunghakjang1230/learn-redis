package byunghakjang.example.redis.ui;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;

import byunghakjang.example.redis.dto.StationRequest;
import byunghakjang.example.redis.dto.StationResponse;
import byunghakjang.example.redis.service.RedisTestService;
import byunghakjang.example.redis.utils.MockMvcControllerTest;

@ActiveProfiles("test")
@DisplayName("컨트롤러 테스트")
@WebMvcTest(controllers = RedisTestController.class)
class RedisTestControllerTest extends MockMvcControllerTest {
    private static final String API_URL = "/api/redis";

    @MockBean
    private RedisTestService redisTestService;

    @Autowired
    private RedisTestController redisTestController;

    @Override
    protected Object controller() {
        return redisTestController;
    }

    @Test
    @Disabled
    @DisplayName("컨트롤러 기본 동작 테스트")
    void controller_default_test() throws Exception {
        // then
        mockMvc.perform(get(API_URL))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("지하철 한건 조회")
    void find_one_station() throws Exception {
        // given
        StationResponse stationResponse = StationResponse.of(1L, "강남역");
        given(redisTestService.findOneStationById(anyLong())).willReturn(stationResponse);

        // then
        mockMvc.perform(get(API_URL + "/1"))
                .andDo(print())
                .andExpect(status().isOk()).
                andExpect(jsonPath("id").value(stationResponse.getId()))
        ;
    }

    @Test
    @DisplayName("지하철 전체 조회")
    void find_all_stations() throws Exception {
        // given
        given(redisTestService.findAll()).willReturn(Arrays.asList(StationResponse.of(1L, "강남역"),
                StationResponse.of(2L, "교대역")));

        // then
        mockMvc.perform(get(API_URL))
                .andDo(print())
                .andExpect(status().isOk()).
                andExpect(jsonPath(".length()").value(2))
        ;
    }

    @Test
    @DisplayName("지하철 등록")
    void save_station() throws Exception {
        // given
        StationRequest stationRequest = new StationRequest("서초역");
        StationResponse stationResponse = StationResponse.of(3L, "서초역");
        given(redisTestService.saveStation(any(StationRequest.class))).willReturn(stationResponse);

        // then
        mockMvc.perform(post(API_URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(stationRequest))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk()).
                andExpect(jsonPath("name").value(stationResponse.getName()))
        ;
    }

    @Test
    @DisplayName("지하철 수정")
    void update_station() throws Exception {
        // given
        StationRequest stationRequest = new StationRequest("방배역");
        StationResponse stationResponse = StationResponse.of(3L, "방배역");
        given(redisTestService.updateStation(anyLong(), any(StationRequest.class))).willReturn(stationResponse);

        // then
        mockMvc.perform(put(API_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(stationRequest))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk()).
                andExpect(jsonPath("name").value(stationResponse.getName()))
        ;
    }

    @Test
    @DisplayName("지하철 삭제")
    void delete_station() throws Exception {
        // then
        mockMvc.perform(delete(API_URL + "/1"))
                .andDo(print())
                .andExpect(status().isNoContent())
        ;
    }
}

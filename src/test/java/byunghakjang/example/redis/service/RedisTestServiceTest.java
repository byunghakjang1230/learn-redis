package byunghakjang.example.redis.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import byunghakjang.example.redis.domain.Station;
import byunghakjang.example.redis.domain.StationRepository;
import byunghakjang.example.redis.dto.StationRequest;
import byunghakjang.example.redis.dto.StationResponse;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class RedisTestServiceTest {
    @Mock
    private StationRepository stationRepository;
    @InjectMocks
    private RedisTestService redisTestService;

    @Test
    @DisplayName("하나의 역 조회")
    void find_one() {
        // given
        Station station = new Station("강남역");
        given(stationRepository.findById(anyLong())).willReturn(Optional.of(station));

        // when
        StationResponse stationResponse = redisTestService.findOneStationById(1L);

        // then
        assertThat(stationResponse.getName()).isEqualTo(station.getName());
    }

    @Test
    @DisplayName("전체 역 조회")
    void find_all() {
        // given
        given(stationRepository.findAll()).willReturn(Arrays.asList(new Station("강남역"), new Station("교대역")));

        // when
        List<StationResponse> stationResponses = redisTestService.findAll();

        // then
        assertThat(stationResponses).size().isEqualTo(2);
    }

    @Test
    @DisplayName("전체 역 조회")
    void save_station() {
        // given
        Station station = new Station("서초역");
        given(stationRepository.save(any(Station.class))).willReturn(station);

        // when
        StationResponse stationResponse = redisTestService.saveStation(new StationRequest("서초역"));

        // then
        assertThat(stationResponse.getName()).isEqualTo(station.getName());
    }

    @Test
    @DisplayName("역 이름 수정")
    void update_station() {
        // given
        Station station = new Station("서초역");
        given(stationRepository.findById(anyLong())).willReturn(Optional.of(station));

        // when
        StationResponse stationResponse = redisTestService.updateStation(anyLong(), new StationRequest("방배역"));

        // then
        assertThat(stationResponse.getName()).isEqualTo(station.getName());
    }

    @Test
    @DisplayName("역 삭제")
    void delete_station() {
        // when
        redisTestService.deleteStation(1L);

        // then
        verify(stationRepository).deleteById(anyLong());
    }
}

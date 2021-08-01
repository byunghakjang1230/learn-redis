package byunghakjang.example.redis.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("지하철역 Repository 테스트")
class StationRepositoryTest {
    @Autowired
    private StationRepository stationRepository;
    private Station station1;
    private Station station2;
    private Station station3;

    @BeforeEach
    void setUp() {
        station1 = stationRepository.save(new Station("교대역"));
        station2 = stationRepository.save(new Station("서초역"));
        station3 = stationRepository.save(new Station("방배역"));
    }

    @Test
    @DisplayName("지하철역 저장")
    void save_station() {
        // given
        Station station = new Station("강남역");

        // when
        Station result = stationRepository.save(station);

        // then
        assertThat(result).isSameAs(station);
    }

    @Test
    @DisplayName("지하철역 조회")
    void find_station() {
        // when
        Optional<Station> findStation = stationRepository.findById(station1.getId());

        // then
        assertThat(findStation).isNotEmpty();
    }

    @Test
    @DisplayName("지하철역 전체 조회")
    void findAll_stations() {
        // when
        List<Station> stations = stationRepository.findAll();

        // then
        assertThat(stations).size().isEqualTo(3);
    }

    @Test
    @DisplayName("지하철역 삭제")
    void delete_station() {
        // given
        stationRepository.delete(station1);

        // when
        List<Station> stations = stationRepository.findAll();

        // then
        assertThat(stations).size().isEqualTo(2);
    }
}

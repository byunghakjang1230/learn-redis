package byunghakjang.example.redis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import byunghakjang.example.redis.domain.Station;
import byunghakjang.example.redis.domain.StationRepository;
import byunghakjang.example.redis.dto.StationRequest;
import byunghakjang.example.redis.dto.StationResponse;

@Service
@Transactional
public class RedisTestService {

    private final StationRepository stationRepository;

    public RedisTestService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public StationResponse findOneStationById(Long id) {
        Station station = findStationById(id);
        return StationResponse.of(station);
    }

    public List<StationResponse> findAll() {
        return stationRepository.findAll()
                .stream()
                .map(StationResponse::of)
                .collect(Collectors.toList());
    }

    public StationResponse saveStation(StationRequest stationRequest) {
        return StationResponse.of(stationRepository.save(new Station(stationRequest.getName())));
    }

    public StationResponse updateStation(Long id, StationRequest stationRequest) {
        Station findStation = findStationById(id);
        findStation.updateStationName(stationRequest.getName());
        return StationResponse.of(findStation);
    }

    public void deleteStation(Long id) {
        stationRepository.deleteById(id);
    }

    private Station findStationById(Long id) {
        return stationRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}

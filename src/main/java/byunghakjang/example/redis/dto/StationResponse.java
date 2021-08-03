package byunghakjang.example.redis.dto;

import byunghakjang.example.redis.domain.Station;

public class StationResponse {
    private Long id;
    private String name;

    private StationResponse() {
    }

    private StationResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static StationResponse of(Long id, String name) {
        return new StationResponse(id, name);
    }

    public static StationResponse of(Station station) {
        return new StationResponse(station.getId(), station.getName());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

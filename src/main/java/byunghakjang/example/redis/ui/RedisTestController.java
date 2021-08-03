package byunghakjang.example.redis.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import byunghakjang.example.redis.dto.StationRequest;
import byunghakjang.example.redis.dto.StationResponse;
import byunghakjang.example.redis.service.RedisTestService;

@RestController
@RequestMapping("/api/redis")
public class RedisTestController {

    private final RedisTestService redisTestService;

    public RedisTestController(RedisTestService redisTestService) {
        this.redisTestService = redisTestService;
    }

    @GetMapping
    public ResponseEntity findAllStation() {
        return ResponseEntity.ok().body(redisTestService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findOneStation(@PathVariable("id") final Long id) {
        StationResponse stationResponse = redisTestService.findOneStationById(id);
        return ResponseEntity.ok().body(stationResponse);
    }

    @PostMapping
    public ResponseEntity saveStation(@RequestBody final StationRequest stationRequest) {
        return ResponseEntity.ok().body(redisTestService.saveStation(stationRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateStation(@PathVariable("id") final Long id, @RequestBody final StationRequest stationRequest) {
        return ResponseEntity.ok().body(redisTestService.updateStation(id, stationRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStation(@PathVariable("id") final Long id) {
        redisTestService.deleteStation(id);
        return ResponseEntity.noContent().build();
    }
}

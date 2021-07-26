package byunghakjang.example.redis.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/redis")
public class RedisTestController {

    @GetMapping
    public ResponseEntity connectController() {
        return ResponseEntity.ok().build();
    }
}

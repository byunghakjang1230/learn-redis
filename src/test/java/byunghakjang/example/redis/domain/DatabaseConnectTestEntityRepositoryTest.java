package byunghakjang.example.redis.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
@DisplayName("DB 연결 테스트")
class DatabaseConnectTestEntityRepositoryTest {
    @Autowired
    private DatabaseConnectTestEntityRepository repository;

    @Test
    @DisplayName("DB 연결 확인")
    void connect_db_test() {
        // when
        DatabaseConnectTestEntity save = repository.save(new DatabaseConnectTestEntity("HI!"));

        // then
        assertThat(save.getId()).isNotNull();
    }
}

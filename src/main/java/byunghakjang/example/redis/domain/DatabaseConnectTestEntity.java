package byunghakjang.example.redis.domain;

import javax.persistence.*;

@Entity
@Table(name = "db_test")
public class DatabaseConnectTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    protected DatabaseConnectTestEntity() {
    }

    public DatabaseConnectTestEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return name;
    }
}

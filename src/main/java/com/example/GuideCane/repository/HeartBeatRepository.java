package com.example.GuideCane.repository;

        import java.util.List;
        import com.example.GuideCane.model.HeartBeat;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface HeartBeatRepository extends JpaRepository<HeartBeat,Long> {
    List<HeartBeat> findAll();
    HeartBeat findByHeartBeatValue(String HeartBeatValue);
}

package koinot.com.bot.repository;

import koinot.com.bot.entity.real.RealTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RealTestRepository extends JpaRepository<RealTest, Long> {
    List<RealTest> findAllById(Long id);
}


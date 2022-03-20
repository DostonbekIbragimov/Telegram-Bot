package koinot.com.bot.repository;

import koinot.com.bot.entity.just.CheckTests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckTestsRepository extends JpaRepository<CheckTests, Long> {
    List<CheckTests> findAllById(Long id);
}


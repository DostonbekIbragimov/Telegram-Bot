package koinot.com.bot.repository;

import koinot.com.bot.entity.just.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long> {
    List<Answers> findAllById(Long id);
}

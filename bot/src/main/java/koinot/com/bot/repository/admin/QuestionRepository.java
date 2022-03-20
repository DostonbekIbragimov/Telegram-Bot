package koinot.com.bot.repository.admin;

import koinot.com.bot.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllById(Long id);

    Question findByPhotoId(String fileId);

    @Query(value = "SELECT * FROM (SELECT * FROM question WHERE active = true ORDER BY RANDOM() LIMIT ?) k ORDER BY k.id;", nativeQuery = true)
    List<Question> generation(int count);

    @Query(value = "select count(*) from question where active = true", nativeQuery = true)
    Long countList();
}

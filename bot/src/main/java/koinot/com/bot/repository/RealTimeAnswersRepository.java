package koinot.com.bot.repository;

import koinot.com.bot.entity.RealTimeAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RealTimeAnswersRepository extends JpaRepository<RealTimeAnswers, Long> {
    List<RealTimeAnswers> findAllById(Long id);

    List<RealTimeAnswers> findByRealTestIdAndUsersId(Long realTest_id, Long users_id);

    RealTimeAnswers findByRealTestIdAndUsersIdAndQuestionId(Long realTest_id, Long users_id, Long question_id);

    @Query(nativeQuery = true, value = "select *\n" +
            "from real_time_answers\n" +
            "where users_id = :users_id\n" +
            "  and real_test_id = :realTest_id\n" +
            "  and question_id > :question_id order by question_id limit 1")
    RealTimeAnswers getNext(@Param("realTest_id") Long realTest_id, @Param("users_id") Long users_id, @Param("question_id") Long question_id);

    @Query(nativeQuery = true, value = "select *\n" +
            "from real_time_answers\n" +
            "where users_id = :users_id\n" +
            "  and real_test_id = :realTest_id\n" +
            "  and question_id < :question_id order by question_id limit 1")
    RealTimeAnswers getPrevious(@Param("realTest_id") Long realTest_id, @Param("users_id") Long users_id, @Param("question_id") Long question_id);

}



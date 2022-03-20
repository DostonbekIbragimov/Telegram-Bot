package koinot.com.bot.repository;

import koinot.com.bot.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ibragimov Qudrtajon
 * @link Telegram Link https://t.me/DostonbekIbragimov
 * @since 26/08/21
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByTelegramId(Long telegramId);

    User findAllByTelegramId(Long telegramId);

    List<User> findAllByRegion(String region);

    @NotNull
    List<User> findAll();

    @Query(value = "select count(*) from users", nativeQuery = true)
    Long countList();
}

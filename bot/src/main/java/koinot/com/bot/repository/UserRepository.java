package koinot.com.bot.repository;

import koinot.com.bot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Komilov Qudrtajon
 * @link Telegram Link https://t.me/qudratjon03031999
 * @since 26/08/21
 */
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByTelegramId(Long telegramId);

    User findAllByTelegramId(Long telegramId);

    List<User> findAllByRegion(String region);
}

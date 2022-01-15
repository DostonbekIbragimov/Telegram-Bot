package koinot.com.bot.repository;

import koinot.com.bot.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Komilov Qudrtajon
 * @link Telegram Link https://t.me/qudratjon03031999
 * @since 26/08/21
 */
public interface MessagesRepository extends JpaRepository<Messages, Long> {

    Messages findByName(String name);

}

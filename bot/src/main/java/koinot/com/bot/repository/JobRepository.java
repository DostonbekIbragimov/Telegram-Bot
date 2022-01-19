package koinot.com.bot.repository;


import koinot.com.bot.entity.products.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Komilov Qudrtajon
 * @link Telegram Link https://t.me/qudratjon03031999
 * @since 26/08/21
 */

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}

package koinot.com.bot.service.DBservice;

import koinot.com.bot.entity.User;
import koinot.com.bot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: UserService  $
 * @description: TODO
 * @date: 09 January 2022 $
 * @time: 3:39 AM $
 * @author: Dostonbek Ibragimov
 */
@Service
@Slf4j
public class UserDB {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {

        return userRepository.save(user);

    }

    public boolean existsByTelegramId(Long id) {
        return userRepository.existsByTelegramId(id);
    }


    public User findAllByTelegramId(Long id) {
        return userRepository.findAllByTelegramId(id);

    }

    public List<User> findAll() {
        return userRepository.findAll();

    }

    public Long countList() {
        return userRepository.countList();
    }


}

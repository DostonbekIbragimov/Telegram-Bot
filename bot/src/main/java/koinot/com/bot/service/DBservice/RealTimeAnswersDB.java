package koinot.com.bot.service.DBservice;

import koinot.com.bot.entity.RealTimeAnswers;
import koinot.com.bot.entity.User;
import koinot.com.bot.repository.RealTimeAnswersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RealTimeAnswersDB {

    @Autowired
    RealTimeAnswersRepository realTimeAnswersRepository;

    public RealTimeAnswers saveRealTimeAnswer(RealTimeAnswers categories) {
        return realTimeAnswersRepository.save(categories);
    }

    public Optional<RealTimeAnswers> findById(Long id) {
        return realTimeAnswersRepository.findById(id);
    }


    public List<RealTimeAnswers> findAllById(Long id) {
        return realTimeAnswersRepository.findAllById(id);
    }

    public List<RealTimeAnswers> findAll() {
        return realTimeAnswersRepository.findAll();
    }

    public List<RealTimeAnswers> getAnswers(User user) {
        return realTimeAnswersRepository.findByRealTestIdAndUsersId(user.getRealTest().getId(), user.getId());
    }

    public RealTimeAnswers getAnswer(User user) {
        return realTimeAnswersRepository.findByRealTestIdAndUsersIdAndQuestionId(user.getRealTest().getId(), user.getId(), user.getQuestion().getId());
    }

    public RealTimeAnswers getNext(User user) {
        return realTimeAnswersRepository.getNext(user.getRealTest().getId(), user.getId(), user.getQuestion().getId());
    }

    public RealTimeAnswers getPrevious(User user) {
        return realTimeAnswersRepository.getPrevious(user.getRealTest().getId(), user.getId(), user.getQuestion().getId());
    }

}


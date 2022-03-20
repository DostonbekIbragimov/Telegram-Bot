package koinot.com.bot.service.DBservice;


import koinot.com.bot.entity.just.Answers;
import koinot.com.bot.repository.AnswersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AnswersDB {

    @Autowired
    AnswersRepository answersRepository;

    public Answers saveAnswer(Answers answer) {
        return answersRepository.save(answer);
    }

    public Optional<Answers> findById(Long id) {
        return answersRepository.findById(id);
    }

    public boolean existsByCheckTestId(Long id) {
        return answersRepository.existsById(id);
    }

    public List<Answers> findAllById(Long id) {
        return answersRepository.findAllById(id);
    }
}

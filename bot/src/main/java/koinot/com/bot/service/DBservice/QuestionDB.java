package koinot.com.bot.service.DBservice;

import koinot.com.bot.entity.Question;
import koinot.com.bot.repository.admin.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class QuestionDB {

    @Autowired
    QuestionRepository questionRepository;

    public Question saveQuestion(Question categories) {
        return questionRepository.save(categories);
    }

    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }


    public List<Question> findAllById(Long id) {
        return questionRepository.findAllById(id);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public List<Question> generation(int i) {
        return questionRepository.generation(i);
    }

    public Long countList() {
        return questionRepository.countList();
    }
}

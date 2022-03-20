package koinot.com.bot.service.DBservice;

import koinot.com.bot.entity.just.CheckTests;
import koinot.com.bot.repository.CheckTestsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CheckTestsDB {

    @Autowired
    CheckTestsRepository testsRepository;

    public CheckTests saveTest(CheckTests user) {

        return testsRepository.save(user);

    }

    public Optional<CheckTests> findById(Long id) {
        return testsRepository.findById(id);
    }

    public boolean existsByCheckTestId(Long id) {
        return testsRepository.existsById(id);
    }

    public List<CheckTests> findAllById(Long id) {

        return testsRepository.findAllById(id);

    }
}

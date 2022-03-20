package koinot.com.bot.service.DBservice;

import koinot.com.bot.entity.real.RealTest;
import koinot.com.bot.repository.RealTestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RealTestDB {

    @Autowired
    RealTestRepository realTestRepository;

    public RealTest saveRealTest(RealTest categories) {
        return realTestRepository.save(categories);
    }

    public Optional<RealTest> findById(Long id) {
        return realTestRepository.findById(id);
    }


    public List<RealTest> findAllById(Long id) {
        return realTestRepository.findAllById(id);
    }

    public List<RealTest> findAll() {
        return realTestRepository.findAll();
    }

}



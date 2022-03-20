package koinot.com.bot.service.DBservice;

import koinot.com.bot.entity.Categories;
import koinot.com.bot.repository.admin.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class CategoryDB {

    @Autowired
    CategoryRepository categoryRepository;

    public Categories saveCategory(Categories categories) {
        return categoryRepository.save(categories);
    }

    public Optional<Categories> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public boolean existsByCategoryName(String name) {
        return categoryRepository.existsByName(name);
    }

    public Categories findByName(String name) {
        return categoryRepository.findByName(name);
    }


    public List<Categories> findAllById(Long id) {
        return categoryRepository.findAllById(id);
    }

    public List<Categories> findAll() {
        return categoryRepository.findAll();
    }

    public List<Categories> findBySubjectName(String name) {
        return categoryRepository.findBySubjectName(name);
    }
}

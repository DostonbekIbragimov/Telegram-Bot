package koinot.com.bot.repository.admin;

import koinot.com.bot.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
    List<Categories> findAllById(Long id);

    boolean existsByName(String name);

    Categories findByName(String name);

    List<Categories> findBySubjectName(String subjectName);
}

package koinot.com.bot.entity.real;

import koinot.com.bot.entity.Question;
import koinot.com.bot.entity.User;
import koinot.com.bot.enums.Subjects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "real_test")
public class RealTest {

    @Id
    @SequenceGenerator(name = "real_test_id_sequence", sequenceName = "real_test_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "real_test_id_sequence")
    private Long id;

    @OrderBy
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    private Long closeWhenTest;

    @ManyToMany
    private List<Question> fileId;

    private int testCount;

    private String testAnswer;

    @Enumerated(EnumType.STRING)
    private Subjects subjectName = Subjects.INFORMATIKA;

    private Long expireDateTest;

    @ManyToOne
    private User users;
}
package koinot.com.bot.entity.just;

import koinot.com.bot.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "check_tests")
public class CheckTests {

    @Id
    @SequenceGenerator(name = "check_tests_id_sequence", sequenceName = "check_tests_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "check_tests_id_sequence")
    private Long id;

    @OrderBy
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @CreatedBy
    @Column(updatable = false)
    private Long createdBy;

    @OrderBy
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp closedAt;

    private boolean isActive;

    private int testCount;

    private String testAnswer;

    private String subjectName;

    @ManyToOne
    private User users;

}

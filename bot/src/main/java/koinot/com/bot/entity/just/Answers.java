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
@Entity(name = "answers")
public class Answers {

    @Id
    @SequenceGenerator(name = "answers_id_sequence", sequenceName = "answers_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answers_id_sequence")
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

    private int correctAnswer;

    private int testCount;

    private int correctRate;

    @ManyToOne
    private User users;

    @ManyToOne
    private CheckTests tests;

}

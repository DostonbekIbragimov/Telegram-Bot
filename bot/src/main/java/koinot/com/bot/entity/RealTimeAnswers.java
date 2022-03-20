package koinot.com.bot.entity;

import koinot.com.bot.entity.real.RealTest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "real_time_answers")
public class RealTimeAnswers {

    @Id
    @SequenceGenerator(name = "real_time_answers_id_sequence", sequenceName = "real_time_answers_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "real_time_answers_id_sequence")
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

    private String whichSelected;

    private boolean correct;

    private int indexation;

    @ManyToOne
    private User users;

    @ManyToOne
    private Question question;

    @ManyToOne
    private RealTest realTest;

}

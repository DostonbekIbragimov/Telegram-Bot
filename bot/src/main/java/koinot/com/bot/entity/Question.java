package koinot.com.bot.entity;

import koinot.com.bot.entity.real.RealTest;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "question")
public class Question {

    @Id
    @SequenceGenerator(name = "question_id_sequence", sequenceName = "question_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_sequence")
    private Long id;

    @OrderBy
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    private String photoId;

    private boolean active;

    private String answer;

    @ManyToOne
    private Categories category;

    @ManyToOne
    private RealTest realTest;

    private String grade;

}
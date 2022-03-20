package koinot.com.bot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "categories")
public class Categories {

    @Id
    @SequenceGenerator(name = "categories_id_sequence", sequenceName = "categories_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_id_sequence")
    private Long id;

    @OrderBy
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    private String name;

    private String subjectName;
}
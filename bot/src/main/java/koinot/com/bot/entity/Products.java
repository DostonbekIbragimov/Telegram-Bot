package koinot.com.bot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @className: BotMessage  $
 * @description: TODO
 * @date: 09 January 2022 $
 * @time: 6:35 AM $
 * @author: Qudratjon Komilov
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="products")
public class Products {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    @OrderBy @CreationTimestamp @Column(nullable=false, updatable=false) private Timestamp createdAt;

    @UpdateTimestamp @Column(nullable=false) private Timestamp updatedAt;

    @CreatedBy @Column(updatable=false) private Long createdBy;

    @LastModifiedBy private Long updatedBy;

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionUz;//default use

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionRu;

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionEn;

    @Column(nullable=false) private String nameUz;//default use

    @Column(nullable=false) private String nameRu;

    @Column(nullable=false) private String nameEn;

    @OneToMany private List<Attachment> image;

    @ManyToOne private Categories categories;

}

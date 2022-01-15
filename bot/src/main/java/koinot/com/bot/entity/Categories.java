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
@Entity(name="categories")
public class Categories {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    @OrderBy @CreationTimestamp @Column(nullable=false, updatable=false) private Timestamp createdAt;

    @UpdateTimestamp @Column(nullable=false) private Timestamp updatedAt;

    @CreatedBy @Column(updatable=false) private Long createdBy;

    @LastModifiedBy private Long updatedBy;

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionUz;

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionRu;

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionEn;

    @Column(nullable=false) private String nameUz;

    @Column(nullable=false) private String nameRu;

    @Column(nullable=false) private String nameEn;

    @Column(nullable=false) private String iconCategory;

    @ManyToOne private Attachment image;

    @ManyToOne private Categories categoriesParent;



}

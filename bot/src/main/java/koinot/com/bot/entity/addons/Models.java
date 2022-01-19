package koinot.com.bot.entity.addons;

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
 * @className: Brands  $
 * @description: TODO
 * @date: 15 January 2022 $
 * @time: 12:42 PM $
 * @author: Qudratjon Komilov
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Models")
public class Models {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;

    @OrderBy @CreationTimestamp @Column(nullable=false, updatable=false) private Timestamp createdAt;

    @UpdateTimestamp @Column(nullable=false) private Timestamp updatedAt;

    @CreatedBy @Column(updatable=false) private Long createdBy;

    @LastModifiedBy private Long updatedBy;

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionUz;//default use

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionRu;

    @Column(columnDefinition="TEXT", nullable=false) private String descriptionEn;

    @Column(nullable=false) private String name;

    @Column(nullable=false) private String iconCategory;

    @OneToOne private Attachment image;

    @ManyToOne
    private Brands brands;
}

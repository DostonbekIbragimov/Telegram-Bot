package koinot.com.bot.entity.products.template;

import koinot.com.bot.entity.Attachment;
import koinot.com.bot.entity.Currency;
import koinot.com.bot.entity.products.Brands;
import koinot.com.bot.entity.products.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ReadyProduct {

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

    @ManyToOne private Categories categories;

    @ManyToOne private Brands brands;

    @OneToMany private List<Attachment> image;

    private String address;

    private Double longitude;

    private Double latitude;

    /*
     *
     * kelishiladi ikkinchi tomon fikri ham inobatga olinadi
     * agar false bo'sa kelishilmaydi
     *
     * */
    private Boolean agreement=false;

    /*
     *
     * jismoniy yokiy yuridik shaxs tanlov uchun
     * agar false jismoniy shaxs bo'ladi
     *
     * */
    private Boolean legalEntity=false;

    @ManyToOne
    private Currency currency;

}
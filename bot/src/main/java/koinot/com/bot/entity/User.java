package koinot.com.bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import koinot.com.bot.entity.enums.Family;
import koinot.com.bot.entity.enums.Gender;
import koinot.com.bot.entity.enums.UserState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author Komilov Qudrtajon
 * @link Telegram Link https://t.me/qudratjon03031999
 * @since 26/08/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Users")
public class User implements UserDetails {
    @Id @GeneratedValue(strategy=GenerationType.AUTO) private Long id;

    @OrderBy @CreationTimestamp @Column(nullable=false, updatable=false) private Timestamp createdAt;

    @UpdateTimestamp @Column(nullable=false) private Timestamp updatedAt;

    @CreatedBy @Column(updatable=false) private Long createdBy;

    @LastModifiedBy private Long updatedBy;

    @Column(unique=true) private Long telegramId;

    private String firstName;

    private String lastName;

    private String region;

    private String language;

    private String address;

    private Double balance; // ishlatilmagan


    @Enumerated(EnumType.STRING) private Gender gender; // ishlatilmagan

    @JsonIgnore private Date expiredCode;

    @JsonIgnore private String verifyCode; // android uchun code

    @JsonIgnore private String password; // paroli

    @Column(unique=true) private String phoneNumber; // qo'lda kiritadigan tel nomeri

    private String username; // ishlatilmagan bot uchun ishlatmoqchi edim

    @Enumerated(EnumType.STRING) private UserState state; // bot uchun holatlari

    @Enumerated(EnumType.STRING) private Family family;

    private Double longitude; // userni hozir tirgan joyi

    private Double latitude; // userni hozir tirgan joyi

    @ManyToMany(fetch=FetchType.EAGER) @JsonIgnore
    @JoinTable(name="user_role", joinColumns={@JoinColumn(name="user_id")}, inverseJoinColumns={@JoinColumn(name="role_id")})
    private List<Role> roles; // userni roli


    @JsonIgnore private Boolean accountNonExpired=true;
    @JsonIgnore private Boolean accountNonLocked=true;
    @JsonIgnore private Boolean credentialsNonExpired=true;
    @JsonIgnore private Boolean enabled=true;

    @Override
    public String getUsername() {
        return this.phoneNumber;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}

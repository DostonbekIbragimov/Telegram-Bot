package koinot.com.bot.entity.addons;

import koinot.com.bot.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Role implements GrantedAuthority {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;

    @Column(unique=true) @Enumerated(EnumType.STRING) private RoleName name;

    public Role() {
    }

    @Override
    public String getAuthority() {
        return name.name();
    }

    public Role(Integer id,RoleName name) {
        this.id=id;
        this.name=name;
    }
}

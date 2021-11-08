package dsmesd.esdu.domain.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "esd_user")
public class User {

    @Id
    @Column(length = 30)
    private String id;

    @Column(length = 400, nullable = false)
    private String password;
    
}

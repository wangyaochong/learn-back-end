package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.function.Predicate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

//
//@NamedQuery(name="User.nameQuery",query="select u from User u where u.name=?1")
public class User {
    @Id
    @GenericGenerator(name="generator",strategy = "increment")
    @GeneratedValue(generator = "generator")
    Long id;
    String name;
    String nickName;
    String emailAddress;

    @ManyToOne
    Address address;
}

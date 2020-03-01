package entity;


import enums.EnumSex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserM {

    Long id;
    String name;
    Integer age;
    String emailAddress;

    EnumSex sex;

    String forObjectFactory;
}

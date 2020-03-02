package wangyaochong.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserAddress implements Serializable {
    Integer id;
    String address;
    Integer age;
}

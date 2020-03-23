package src.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangyaochong
 * @date 2020/3/23 14:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationRequest {
    String userName;
    String password;
}

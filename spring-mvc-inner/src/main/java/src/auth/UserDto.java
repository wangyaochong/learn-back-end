package src.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangyaochong
 * @date 2020/3/23 14:27
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    String id;
    String username;
    String password;
    String fullName;
    String mobile;
}

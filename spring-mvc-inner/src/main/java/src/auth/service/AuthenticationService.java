package src.auth.service;

import src.auth.AuthenticationRequest;
import src.auth.UserDto;

/**
 * @author wangyaochong
 * @date 2020/3/23 14:29
 */
public interface AuthenticationService {
    UserDto authentication(AuthenticationRequest authenticationRequest);
}

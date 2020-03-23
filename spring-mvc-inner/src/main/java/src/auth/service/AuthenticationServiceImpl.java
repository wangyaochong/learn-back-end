package src.auth.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import src.auth.AuthenticationRequest;
import src.auth.UserDto;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyaochong
 * @date 2020/3/23 14:29
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    Map<String, UserDto> userDtoMap = new HashMap<>();

    @PostConstruct
    public void init() {
        userDtoMap.put("zhangsan", new UserDto("1010", "zhangsan", "123", "张三", "2345"));
        userDtoMap.put("lisi", new UserDto("1011", "lisi", "456", "李四", "234225"));
    }


    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest == null
                || StringUtils.isEmpty(authenticationRequest.getPassword())
                || StringUtils.isEmpty(authenticationRequest.getUserName())) {
            throw new RuntimeException("账号或密码为空");
        }
        UserDto userDto = userDtoMap.get(authenticationRequest.getUserName());
        if (userDto == null) {
            throw new RuntimeException("查询不到该用户");
        }
        if (!StringUtils.equals(authenticationRequest.getPassword(), userDto.getPassword())) {
            throw new RuntimeException("账号或密码错误");
        }
        return userDto;
    }


}

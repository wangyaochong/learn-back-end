package src.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class OuterSpringClass {
    String name;

    @Resource
    Person person;


    //    @Resource
    Person person2;

    @PostConstruct
    public void init() {
        log.info("初始化OuterSpringClass...");
        name = "autowireBean";
    }

}

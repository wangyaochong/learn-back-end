package com.learnspring.springDataJpa;

import com.learnspring.springDataJpa.repo.AddressRepo;
import com.learnspring.springDataJpa.repo.CombinedTransactionalRepo;
import com.learnspring.springDataJpa.repo.UserRepository;
import com.learnspring.springDataJpa.repo.custom.UserRepoCustomImpl;
import entity.Address;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import util.LogUtil;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestRepo {
    @Resource
    UserRepository userRepository;
    @Resource
    AddressRepo addressRepo;
    @Resource
    CombinedTransactionalRepo combinedTransactionalRepo;



    @Test
    public void testRepository(){
        Address save = addressRepo.save(new Address(1l, "中国", "江西", "南昌"));
        userRepository.save(new User(null,"test","test+test","test@email",save));
        userRepository.save(new User(null,"test2","test2+test2","test@email",save));
        User test = userRepository.findByEmailAddress("test@");
//        log.info(LogUtil.prefixLog(test.toString()));
        User test2 = userRepository.findByEmailAddress(null);
        List<User> test3 = userRepository.findByAddress_Country("中国");
        log.info(LogUtil.prefixLog(test3.toString()));
        List<User> test4 = userRepository.findByAddressCountry("中国");
        log.info(LogUtil.prefixLog(test4.toString()));
        Page<User> test5 = userRepository.findByName("test", PageRequest.of(1, 1));
        log.info(LogUtil.prefixLog(Integer.toString( test5.getTotalPages())));
//        Optional<User> userOptional = userRepository.findByEmailAddress2("test");
        List<User> test1 = userRepository.findByName("test");
        log.info(LogUtil.prefixLog(test1.toString()));

        combinedTransactionalRepo.addUserWithAddress(new User(null,"test3","test3+test3","test3@email",new Address(1l, "中国", "江西", "南昌")));
        userRepository.saveCustom(new User());

    }


}

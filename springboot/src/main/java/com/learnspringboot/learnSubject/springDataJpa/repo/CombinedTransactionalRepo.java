package com.learnspringboot.learnSubject.springDataJpa.repo;

import entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class CombinedTransactionalRepo {
    @Resource
    UserRepository userRepository;
    @Resource
    AddressRepo addressRepo;

    @Transactional
    public void addUserWithAddress(User user) {
        addressRepo.save(user.getAddress());
        userRepository.save(user);
    }
}

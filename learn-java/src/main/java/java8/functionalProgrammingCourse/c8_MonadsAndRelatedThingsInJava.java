package java8.functionalProgrammingCourse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Optional;
import java.util.UUID;

public class c8_MonadsAndRelatedThingsInJava {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class Bank {
        String uniqueNumber;
        String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class Account {
        UUID uuid;
        Bank bank;
        Long balance;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class User {
        String firstName;
        String lastName;
        Account account;
    }

    @Test
    public void testOptional() {
        System.out.println(
                Optional.<User>empty()
                        .map(User::getAccount)
                        .map(Account::getBank)
                        .map(Bank::getName)
                        .orElse("bankName not found"));

        System.out.println(
                Optional.of(new User())
                        .flatMap(e -> Optional.ofNullable(e.getAccount()))
                        .flatMap(e -> Optional.ofNullable(e.getBank()))
                        .flatMap(e -> Optional.ofNullable(e.getName()))
                        .orElse("bankName not found"));
    }
}

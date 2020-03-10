package leetcode.byNumber;

import org.junit.Test;

public class p196_DeleteDuplicateEmails {

    String answer = "DELETE p from Person p, Person q where p.Id>q.Id AND q.Email=p.Email;";
    String answer2 = "delete from Person where Id not in(select t.Id from  ( select Email,min(Id) as Id from Person group by Email ) as t);";


    @Test
    public void test() {

    }
}

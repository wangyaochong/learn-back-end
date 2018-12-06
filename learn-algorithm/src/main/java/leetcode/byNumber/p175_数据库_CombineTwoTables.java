package leetcode.byNumber;

public class p175_数据库_CombineTwoTables {
    String answer = "select p.FirstName,p.LastName,a.City,a.State from Person p left join Address a on p.PersonId=a.PersonId;";
}

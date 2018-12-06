package leetcode.byNumber;

public class p183_数据库_CustomersWhoNeverOrder {
    String answer1 = "select Name as Customers from Customers c where c.Id not in(select CustomerId from Orders);";

    String answer2 = "SELECT A.Name from Customers A WHERE NOT EXISTS (SELECT 1 FROM Orders B WHERE A.Id = B.CustomerId);";

    String answer3 = "SELECT A.Name from Customers A LEFT JOIN Orders B on  a.Id = B.CustomerId WHERE b.CustomerId is NULL;";
}

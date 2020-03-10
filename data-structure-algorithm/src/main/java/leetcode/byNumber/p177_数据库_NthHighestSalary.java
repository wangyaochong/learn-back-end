package leetcode.byNumber;

public class p177_数据库_NthHighestSalary {

    String declare = "DECLARE M INT;";
    String set = "SET M=N-1;";
    String answer = "SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT M, 1";
}

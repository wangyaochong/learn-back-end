package leetcode.byNumber;

public class p176_数据库_SecondHighestSalary {
    String answer = "SELECT max(Salary) as SecondHighestSalary FROM Employee WHERE Salary < (SELECT max(Salary) FROM Employee);";
}



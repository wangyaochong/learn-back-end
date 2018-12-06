package leetcode.byNumber;

public class p181_数据库_EmployeesEarningMoreThanTheirManagers {

    String answer = "select e1.Name as Employee from Employee e1,Employee e2 where e1.ManagerId=e2.Id and e1.Salary>e2.Salary;";
}

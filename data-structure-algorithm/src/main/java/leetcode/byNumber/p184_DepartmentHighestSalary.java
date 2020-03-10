package leetcode.byNumber;

public class p184_DepartmentHighestSalary {

    String answer = "select d.Name as Department,e1.Name as Employee,e1.Salary  from Employee e1,Department d where e1.DepartmentId=d.Id and  e1.Salary= (select max(e2.Salary) from Employee e2 where e1.DepartmentId=e2.DepartmentId);";
}

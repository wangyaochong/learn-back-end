package leetcode.byNumber;

public class p185_数据库_DepartmentTopThreeSalaries_这道题很不错 {

    String answer = "select d.Name as Department ,e1.Name as Employee,e1.Salary from Employee e1,Department d  where 3>(select  count(distinct Salary) from Employee e2 where e1.Salary<e2.Salary and e1.DepartmentId =e2.DepartmentId ) and e1.DepartmentId=d.Id order by e1.DepartmentId asc ,e1.Salary desc;";
}

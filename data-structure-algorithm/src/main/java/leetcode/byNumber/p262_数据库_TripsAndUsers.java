package leetcode.byNumber;

public class p262_数据库_TripsAndUsers {

    String answer = "select r.Request_at as 'Day' , convert(ifnull(cc,0)/(ifnull(ii,0)+ ifnull(cc,0)),decimal(16,2)) as 'Cancellation Rate' from\n" +
            "(select distinct Request_at from Trips where Request_at >='2013-10-01' and Request_at <='2013-10-03'  )as r \n" +
            "left join\n" +
            "(select sum(x.c) as cc,Request_at from ((\n" +
            "select count(1) as c,Request_at from Trips t,Users u where t.Client_Id=u.Users_Id and u.Role='client' and u.Banned='No' and t.status='cancelled_by_client' group by Request_at\n" +
            "union\n" +
            "select count(1) as c,Request_at from Trips t,Users u where t.Driver_Id=u.Users_Id and u.Role='driver' and u.Banned='No' and t.status='cancelled_by_driver' group by Request_at\n" +
            ")as x) group by Request_at) as t1 on t1.Request_at=r.Request_at\n" +
            "left join \n" +
            "(select count(t.id) as ii,Request_at from\n" +
            " (\n" +
            "select t.Id ,Request_at from Trips t,Users u, Users u2 where t.Client_Id=u.Users_Id and u.Role='client' and t.status='completed' and u.Banned='No' and t.Driver_Id=u2.Users_Id and u2.Role='driver' and u2.Banned='No')as t group by Request_at\n" +
            ") as t2 \n" +
            "on r.Request_at=t2.Request_at group by r.Request_at";

}

package leetcode.byNumber;

public class p262_数据库_TripsAndUsers_看别人的_in {

    String answer =
            "select t.Request_at Day,ROUND((count(IF(t.status!='completed',TRUE,null))/count(*)),2) as 'Cancellation Rate'\n"
                    + "from Trips t where \n"
                    + "t.Client_Id in (Select Users_Id from Users where Banned='No') \n"
                    + "and t.Driver_Id in (Select Users_Id from Users where Banned='No')\n"
                    + "and t.Request_at between '2013-10-01' and '2013-10-03'\n"
                    + "group by t.Request_at;";
}

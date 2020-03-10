package leetcode.byNumber;

public class p262_数据库_TripsAndUsers_看别人的_not_in {

    String answer =
            "SELECT Request_at as Day,ROUND(COUNT(IF(Status != 'completed', TRUE, NULL)) / COUNT(*), 2) AS 'Cancellation Rate'\n"
                    + "FROM Trips\n"
                    + "WHERE (Request_at BETWEEN '2013-10-01' AND '2013-10-03')\n"
                    + "      AND Client_id NOT IN (SELECT Users_Id FROM Users WHERE Banned = 'Yes')\n"
                    + "      AND Driver_Id NOT IN(SELECT Users_Id FROM Users WHERE Banned = 'Yes')\n"
                    + "GROUP BY Request_at;";
}

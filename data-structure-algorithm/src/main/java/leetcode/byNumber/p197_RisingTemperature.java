package leetcode.byNumber;

public class p197_RisingTemperature {
    String answer = "select w2.id from Weather w1,Weather w2 where datediff(w1.RecordDate,w2.RecordDate)=-1 and w1.Temperature<w2.Temperature;";
}

package leetcode.byNumber;

public class p178_数据库_RankScores {

    String answer = "SELECT Score,(SELECT count(distinct Score) FROM Scores WHERE Score >= s.Score) Rank FROM Scores s ORDER BY Score desc";
}

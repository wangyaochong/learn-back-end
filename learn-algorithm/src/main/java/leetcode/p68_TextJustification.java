package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p68_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int rowWordNum = 0;
        int rowWordsWidth = 0;
        int wordSpaceCount;
        int moreSpaceCount = 0;
        int tmp;
        StringBuilder stringBuilder = new StringBuilder();
        List<String> result = new ArrayList<>();
        int i = 0;
        int j = i;//当前一句的起点
        while (i < words.length) {
            moreSpaceCount = 0;
            while (i < words.length && rowWordsWidth + rowWordNum + words[i].length() <= maxWidth) {
                rowWordsWidth += words[i].length();
                rowWordNum += 1;
                i++;
            }
            if (rowWordNum == 1) {
                stringBuilder.append(words[j]);
                for (int x = 0; x < maxWidth - words[j].length(); x++) {
                    stringBuilder.append(' ');
                }
            } else {
                wordSpaceCount = (maxWidth - rowWordsWidth) / (rowWordNum - 1);//单词空格数
                tmp = (maxWidth - rowWordsWidth) % (rowWordNum - 1);//多一个空格的单词数量
                while (j < i) {
                    stringBuilder.append(words[j]);
                    for (int s = 0; s < wordSpaceCount && i < words.length && j != i - 1; s++) {
                        stringBuilder.append(' ');
                    }
                    if (i == words.length && j != i - 1) {
                        stringBuilder.append(' ');
                    } else if (moreSpaceCount < tmp) {
                        stringBuilder.append(' ');
                    }
                    moreSpaceCount++;
                    j++;
                }
                if (i == words.length) {//对于最后一行，左对齐填满
                    while (stringBuilder.length() < maxWidth) {
                        stringBuilder.append(' ');
                    }
                }
            }
            result.add(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            rowWordNum = 0;
            rowWordsWidth = 0;
            j = i;
        }
        return result;
    }

    @Test
    public void test() {
        List<String> x = fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
        System.out.println(x);
    }
}

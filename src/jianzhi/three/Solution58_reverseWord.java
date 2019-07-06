package jianzhi.three;

/**
 * Created by tt on 2018/10/9.
 */
public class Solution58_reverseWord {
    public String ReverseSentence(String str) {
        if(str == null || str.trim().length() <= 1){ return str;}
        char[] sentence = str.toCharArray();
        // 翻转整个句子
        reverse(sentence, 0, sentence.length - 1);
        int low = 0;
        int high = 0;
        // 翻转每个单词
        while(low != sentence.length && high != sentence.length) {
            // 找到第一个非空格字符
            while(low != sentence.length && sentence[low] == ' '){++low;}
            if(low == sentence.length){ break;}
            // 找到low后面的第一个空格字符
            high = low + 1;
            while(high != sentence.length && sentence[high] != ' '){++high;}
            reverse(sentence, low, high - 1);
            low = high + 1;
        }
        return new String(sentence);
    }

    private void reverse(char[] str, int startIndex, int endIndex) {
        for(int low = startIndex, high = endIndex; low < high;
            ++low, --high) {
            char t = str[low];
            str[low] = str[high];
            str[high] = t;
        }
    }

}

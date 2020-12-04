package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static String getStuId(String s) {
        Pattern numP = Pattern.compile("\\d+");
        Pattern nameP = Pattern.compile("[\\u4E00-\\u9FFF]+");
        Matcher numM = numP.matcher(s);
        Matcher nameM = nameP.matcher(s);
        String person = null;
        String num = null;
        if (numM.find() && nameM.find()) {
            num = numM.group();
            person = numM.group() + nameM.group();
        }
        return person;
    }

    public static boolean matherStu(String s) {
        Pattern pattern = Pattern.compile("\\+\\+\\d+--([\\\\\\\\u\\d\\w]+)+==");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }
}

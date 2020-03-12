
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulation {
    public static void main(String[] args) {

        String html = "<div class=\"image\"> <img src=\"http://cdn.posh24.se/images/:profile/0f8be6d232eb50db8ec0ace6477cedf4a\" alt=\"Isabella Löwengrip\"/> </div>";

        //Find Mi, then find pi, return what is between these two patterns
        Pattern p = Pattern.compile("src=\"(.*?)\" alt=\"(.*?)\"/>");
        Matcher m = p.matcher(html);

        while (m.find()) {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }
}
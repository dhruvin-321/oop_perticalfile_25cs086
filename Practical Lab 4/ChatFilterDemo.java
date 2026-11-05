import java.util.*;
public class ChatFilterDemo {
    public static void main(String[] a)
    {
        String[] logs ={"10:30 Khushi Good morning","11:00 Krima Good afternoon","12:00 Heer"};
        Scanner sc = new Scanner(System.in);
        String keyword = sc.next();
        int match = 0;
        StringBuilder report = new StringBuilder();
        for(String log : logs)
        {
            String []parts = ChatFilter.splitLine(log);
            if(parts == null)
                continue;
            String time = parts[0];
            String name = parts[1];
            String msg = parts[2];
            if(ChatFilter.hasKeyword(msg, keyword))
            {
                match++;
                report.append(time).append(" ").append(name).append(": ").append(msg).append("\n");
            }      
        }
        System.out.println("matches: "+match);
        System.out.println("Report - "+ report);
        
    }
}
class ChatFilter
{
    public static String[] splitLine(String line)
    {
        String []parts = line.split(" ",3);
        if(parts.length <=2 )
            return null;

        return parts;  
    }
    public static boolean hasKeyword(String msg,String keyword)
    {
        return msg.toLowerCase().contains(keyword.toLowerCase());
    }
    
}

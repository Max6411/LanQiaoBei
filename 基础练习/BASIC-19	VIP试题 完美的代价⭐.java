import java.util.Scanner;
 
public class Main {
    public static boolean IsPossible(String str) {
        boolean ans = true;
        int []cnt = new int[26];
        int odds=0;
        for(int i = 0;i<str.length();i++) cnt[str.charAt(i)-'a']++;
        for(int i = 0;i<26;i++)
            if(cnt[i]%2==1) odds++;
        if(odds>1) ans=false;
        return ans;
    }
    public static int getResult(String str) {
        if(str.length()==1 || str.length()==2) return 0;
        int tmp = str.lastIndexOf(str.charAt(0));
        if(tmp==0)//第一位为单个字符
            return str.length()/2 + getResult(str.substring(1,str.length()));
        else {
            StringBuilder sb = new StringBuilder(str);
            sb.deleteCharAt(tmp);
            sb.deleteCharAt(0);
            return str.length()-tmp-1+getResult(sb.toString());
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            String str = in.next();
            if(IsPossible(str))
                System.out.println(getResult(str));
            else
                System.out.println("Impossible");
        }
        in.close();
    }
}

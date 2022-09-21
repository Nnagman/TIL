package kakao;

public class 신규아이디추천 {

    public static void main(String[] args) {
        System.out.println(solution(""));
    }

    static String solution(String new_id) {

        String s1 = new_id.toLowerCase();

        String s2 = "";

        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                s2 += String.valueOf(c);
            }
        }

        String s3 = s2;

        while(s3.contains("..")) {
            s3 = s3.replace("..",".");
        }

        String s4 = s3;

        if (s4.length() > 0) {
            if (s4.charAt(0) == '.') {
                s4 = s4.substring(1, s4.length());
            }
        }

        if (s4.length() > 0) {
            if (s4.charAt(s4.length() - 1) == '.') {
                s4 = s4.substring(0, s4.length() - 1);
            }
        }

        String s5 = s4;

        if(s5.isEmpty()) {
            s5 += "a";
        }

        String s6 = s5;

        if(s6.length() > 15) {
            s6 = s5.substring(0,15);
            if(s6.charAt(14) == '.') {
                s6 = s6.substring(0,14);
            }
        }

        String s7 = s6;

        if(s7.length() < 3) {
            while(s7.length() < 3) {
                s7 += String.valueOf(s7.charAt(s7.length()-1));
            }
        }

        return s7;
    }
}

package kakao;

public class 광고삽입 {

    public static void main(String[] args) {
        System.out.println(solution("02:03:55", "00:14:15",
            new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29",
                "01:30:59-01:53:29", "01:37:44-02:02:30"}));
    }

    static String solution(String play_time, String adv_time, String[] logs) {

        int playTime = getTime(play_time.split(":"));
        int advTime = getTime(adv_time.split(":"));

        int[] arr = new int[playTime + 1];

        for (String log : logs) {
            int start = getTime(log.split("-")[0].split(":"));
            int end = getTime(log.split("-")[1].split(":"));

            for (int i = start; i < end; i++) {
                arr[i] += 1;
            }
        }

        int ans = 0;
        long max = 0;
        long now = 0;

        for (int i = 0; i < advTime; i++) {
            max += arr[i];
        }

        now = max;

        for (int i = advTime; i < playTime; i++) {
            now += arr[i] - arr[i - advTime];
            if (max < now) {
                max = now;
                ans = i - advTime + 1;
            }
        }

        return getTimeString(ans);
    }

    static String getTimeString(int time) {
        String h = String.valueOf(time / 60 / 60);
        h = h.length() == 1 ? "0" + h : h;
        String m = String.valueOf(time / 60 % 60);
        m = m.length() == 1 ? "0" + m : m;
        String s = String.valueOf(time % 60);
        s = s.length() == 1 ? "0" + s : s;
        return h + ":" + m + ":" + s;
    }

    static int getTime(String[] time) {
        return Integer.parseInt(time[0]) * 60 * 60 + Integer.parseInt(time[1]) * 60
            + Integer.parseInt(time[2]);
    }
}

public class Problem1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        int total = 0;
        int[] months = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        String[] days = {"Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        for (int i = 1971; i < year; i++)  total += isLeapYear(i) ? 366 : 365;
        for (int i = 0; i < month - 1; i++)  total += months[i];
        total = total + day - 1;
        if (isLeapYear(year) && month > 2) total++;
        int ans = total % 7;
        return days[ans];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        Problem1185 problem1185 = new Problem1185();
        System.out.println(problem1185.dayOfTheWeek(31, 8 , 2019));
        System.out.println(problem1185.dayOfTheWeek(18, 7, 1999));
        System.out.println(problem1185.dayOfTheWeek(15, 8, 1993));
    }
}

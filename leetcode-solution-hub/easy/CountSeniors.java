public class CountSeniors {
    public static void main(String[] args) {
        String[] details = {"1313579440F2036", "2921522980M5644"};
        int seniorCitizenCount = 0;
        for (String s : details) {
            if (Integer.parseInt(s.substring(11, 13)) > 60) seniorCitizenCount++;
        }
        System.out.println("Count of senior citizens: " + seniorCitizenCount);

        //Approach 2
        for (String detail : details) {
            if (detail.charAt(11) - '0' == 6 && detail.charAt(12) - '0' >= 1) seniorCitizenCount++;
            else if (detail.charAt(11) - '0' > 6) seniorCitizenCount++;
        }
        System.out.println("Count of senior citizens using second approach: " + seniorCitizenCount);
    }
}

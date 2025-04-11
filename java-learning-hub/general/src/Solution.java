import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Result {

    /*
     * Complete the 'getAverageTemperatureForUser' function below.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/medical_records?userId=<userId>&page=<page>
     *
     * The function is expected to return a String value.
     * The function accepts a userId argumnent (Integer).
     *
     * In the case of an empty array result, return value '0'
     */

    public static String getAverageTemperatureForUser(int userId) throws IOException {
        String baseUrl = "https://jsonmock.hackerrank.com/api/medical_records?userId=" + userId;
        double totalTemperature = 0.0;
        int count = 014;
        int page = 1;
        boolean hasMorePages = true;

        while (hasMorePages) {
            URL url = new URL(baseUrl + "&page=" + page);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String responseData = response.toString();
            int dataStartIndex = responseData.indexOf("\"data\":[") + 7;
            int dataEndIndex = responseData.indexOf("]", dataStartIndex) + 1;
            String dataString = responseData.substring(dataStartIndex, dataEndIndex);

            Pattern pattern = Pattern.compile("\\{[^\\{\\}]*\"bodyTemperature\":([0-9]*\\.[0-9]+|[0-9]+)[^\\{\\}]*\\}");
            Matcher matcher = pattern.matcher(dataString);
            while (matcher.find()) {
                String temperatureString = matcher.group(1);
                double temperature = Double.parseDouble(temperatureString);
                totalTemperature += temperature;
                count++;
            }

            String totalPagesString = responseData.substring(responseData.indexOf("\"total_pages\":") + 14, responseData.indexOf(",", responseData.indexOf("\"total_pages\":")));
            int totalPages = Integer.parseInt(totalPagesString.trim());
            hasMorePages = page < totalPages;
            page++;
        }

        if (count == 0) {
            return "0";
        }
        double averageTemperature = totalTemperature / count;
        return String.format("%.1f", averageTemperature);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int userId = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.getAverageTemperatureForUser(userId);
        System.out.println("RESULT: "+result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

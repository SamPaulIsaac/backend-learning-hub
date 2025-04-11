import java.text.DecimalFormat;

public class TemperatureConversion {
    public static void main(String[] args) {
        double celsius = 36.50;
        double[] result = new double[2];
        DecimalFormat df = new DecimalFormat("#.00000");
        result[0] = Double.parseDouble(df.format(celsius + 273.15));
        result[1] = Double.parseDouble(df.format(celsius * 1.80 + 32.00));
        System.out.println("Celsius to Kelvin: " + result[0]);
        System.out.println("Celsius to Fahrenheit: " + result[1]);
    }
}

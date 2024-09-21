public class Main {

    public static void main(String[] args) {
        System.out.format("Java version: %s%n", getJavaVersion());
        System.out.format("JUnit version: %s%n", getJUnitVersion());

        System.out.format("%d%n", addNumeric("111","22"));
    }

    /**
     * Add two numbers represented as strings and return the sum.
     * @param num1 - String containing only whole numbers or the empty string.
     * @param num2 - String containing only whole numbers or the empty string.
     * @return the sum of num1 + num2.
     */
    public static String addNumeric(String num1, String num2) {
        // find longest of the two strings
        int len1 = num1.length(), len2 = num2.length();
        int maxLen = Math.max(len1, len2);
        String result = "";
        long sum = 0;
        int digit = 0;
        double n1 = 0, n2 = 0;
        double powerIndex = 0;
        int index1 = len1 - 1, index2 = len2 - 1;
        while (index1 >= 0 || index2 >= 0) {
            n1 = 0; n2 = 0;
            double tenPower = Math.pow(10.0, powerIndex);

            if (index1 >= 0) {
                digit = Integer.parseInt(Character.toString(num1.charAt(index1)));
                n1 = digit * tenPower;
            }

            if (index2 >= 0) {
                digit = Integer.parseInt(Character.toString(num2.charAt(index2)));
                n2 = digit * tenPower;
            }
            sum += (long) (n1 + n2);

            powerIndex++;
            index1--;
            index2--;
        }

        return Long.toString(sum);
    }

    /**
     * get the java version that is running the current program
     *
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion() {
        Runtime.Version runTimeVersion = Runtime.version();
        return String.format("%s.%s.%s.%s", runTimeVersion.feature(), runTimeVersion.interim(), runTimeVersion.update(), runTimeVersion.patch());
    }

    /**
     * Get the Junit version number that is used by the unit tests in this project.
     *
     * @return String containing the JUnit version number.
     */
    private static String getJUnitVersion() {
        return org.junit.jupiter.api.Test.class.getPackage().getImplementationVersion();
    }
}

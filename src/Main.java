public class Main {

    public static void main(String[] args) {
        System.out.format("Java version: %s%n", getJavaVersion());
        System.out.format("JUnit version: %s%n", getJUnitVersion());

        String n1, n2;

        n1 = "111"; n2 = "22";
        System.out.format("%s + %s = %s%n", n1, n2, addNumeric(n1, n2));

        n1 = "77"; n2 = "44";
        System.out.format("%s + %s = %s%n", n1, n2, addNumeric(n1, n2));
    }

    /**
     * Add two numbers represented as strings and return the sum.
     * @param num1 - String containing only whole numbers or the empty string.
     * @param num2 - String containing only whole numbers or the empty string.
     * @return the sum of num1 + num2 as a string.
     */
    public static String addNumeric(String num1, String num2) {

        int len1 = num1.length(), len2 = num2.length();
        int index1 = len1 - 1, index2 = len2 - 1;

        int sum = 0, digit = 0, carry = 0, n1=0, n2=0;

        StringBuilder sb = new StringBuilder(len1 + len2);
        while (index1 >= 0 || index2 >= 0) {

            n1 = 0; n2 = 0;

            if (index1 >= 0) {
                n1 = Integer.parseInt(Character.toString(num1.charAt(index1)));
            }

            if (index2 >= 0) {
                n2 = Integer.parseInt(Character.toString(num2.charAt(index2)));
            }

            sum = n1 + n2 + carry;
            digit = sum % 10;
            carry = sum / 10;

            sb.insert(0, digit);

            index1--;
            index2--;
        }

        if(carry > 0) sb.insert(0,carry);

        return sb.toString();
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

public class PingScan {

    public static void main(String[] args) {
        if(verifyArgument(args)) {
            long responseTime = Scanner.checkResponse(args[0]);
            if(responseTime >= 0) {
                System.out.println(args[0] + " responded in: " + responseTime + " ms. Connection OK.");
            }
            else {
                System.out.println(args[0] + " - no response from host.");
            }
        }
        else {
            System.out.println("Incorrect argument. Proper usage:\njava PingScan <ip_address>");
        }
    }

    private static boolean verifyArgument(String[] args) {
        if(args.length == 1) {
            String regex = "^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-5][0-5])\\." +
                    "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-5][0-5])\\." +
                    "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-5][0-5])\\." +
                    "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-5][0-5])$";
            if(args[0].matches(regex)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}

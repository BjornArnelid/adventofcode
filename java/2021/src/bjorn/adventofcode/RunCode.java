public class RunCode {
    public static void main(String[] args) {
        if (args.length > 0) {
            String day = args[0];
            System.out.println("You selected day " + day);
        } else {
            System.out.println("Select a day!");
        }
    }
}

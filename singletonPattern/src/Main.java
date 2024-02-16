public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("test");

        Logger logger1 = Logger.getInstance();
        System.out.println(logger1 == logger);
    }
}


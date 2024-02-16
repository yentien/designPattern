public class Logger {
    private static volatile Logger instance;

    private Logger() {
        // 私有構造器, 防止外部直接創建實例
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        // 模仿打印出東西
        System.out.println(System.currentTimeMillis() + ": " + message);
    }
}

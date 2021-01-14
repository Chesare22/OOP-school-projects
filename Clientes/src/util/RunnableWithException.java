package util;

@FunctionalInterface
public interface RunnableWithException {
    void run() throws Exception;

    static void defaultTryCatch(RunnableWithException runnable) {
        try {
            runnable.run();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}

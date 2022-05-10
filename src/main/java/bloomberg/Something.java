package bloomberg;

/**
 * Singleton using lazy initialization
 * https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 */
public class Something {
    private Something() {}

    private static class LazyHolder {
        private static final Something INSTANCE = new Something();
    }

    public static Something getInstance() {
        return LazyHolder.INSTANCE;
    }
}

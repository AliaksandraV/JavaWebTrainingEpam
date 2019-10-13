package by.training.photographer.dao.connection;

class DatabaseConfiguration {

    private String username;
    private String password;
    private String url;
    private String driverClass;
    private Integer maxConnections;
    private Integer maxCheckConnectionTimeout;

    private DatabaseConfiguration() {
        init();
    }

    private static DatabaseConfiguration configuration = new DatabaseConfiguration();

    static DatabaseConfiguration getInstance() {
        return configuration;
    }

    private void init() {
        PropertiesReader properties = new PropertiesReader("config.properties");
        url = properties.takeProperty("db.url");
        username = properties.takeProperty("db.username");
        password = properties.takeProperty("db.password");
        driverClass = properties.takeProperty("db.driverClass");
        maxConnections = Integer.valueOf(properties.takeProperty("db.maxConnections"));
        maxCheckConnectionTimeout = Integer.valueOf(properties.takeProperty("db.maxCheckConnectionTimeout"));
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public Integer getMaxConnections() {
        return maxConnections;
    }

    public Integer getMaxCheckConnectionTimeout() {
        return maxCheckConnectionTimeout;
    }
}

package by.training.photographer.dao;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.Sources;
import com.wix.mysql.SqlScriptSource;
import com.wix.mysql.config.MysqldConfig;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.config.Charset.UTF8;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v8_0_11;

public abstract class BaseDaoImplTest {

    private static final String DATABASE_NAME = "photographer";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "";
    private static final int PORT = 3307;
    private static final SqlScriptSource[] SQL_SCRIPT_SOURCES = {classPathScript("sql/create_db.sql")};

    private static Connection connection;
    private static EmbeddedMysql database;

    @BeforeSuite
    public void init() throws SQLException {
        MysqldConfig config = aMysqldConfig(v8_0_11)
            .withPort(PORT)
            .withCharset(UTF8)
            .withUser(USERNAME, PASSWORD)
            .build();

        database = anEmbeddedMysql(config)
            .addSchema(DATABASE_NAME, SQL_SCRIPT_SOURCES)
            .start();

        connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:" + PORT + "/" + DATABASE_NAME, USERNAME, PASSWORD);
    }

    @BeforeMethod
    public void initMethod() {
        database.reloadSchema(DATABASE_NAME, SQL_SCRIPT_SOURCES);
    }

    @AfterSuite
    public void destroy() {
        database.stop();
    }

    protected List<String> executeScript(String script) {
        return database.executeScripts(DATABASE_NAME, Sources.fromString(script));
    }

    protected Connection getConnection() {
        return connection;
    }
}

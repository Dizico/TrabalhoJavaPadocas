package application.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataSourceFactory {
    private static Properties property;

    public static DataSource getDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        if (property == null)
            property =getProperty();
        dataSource.setURL(property.getProperty("db.url"));
        dataSource.setUser(property.getProperty("db.user"));
        dataSource.setPassword(property.getProperty("db.password"));
        return dataSource;
    }

    private static Properties getProperty() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

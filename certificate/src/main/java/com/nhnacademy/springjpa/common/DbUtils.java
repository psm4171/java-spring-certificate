package com.nhnacademy.springjpa.common;


import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.Duration;

public class DbUtils {
    public DbUtils(){
        throw new IllegalStateException("Utility class");
    }

    private static final DataSource DATASOURCE;

    static {

        BasicDataSource basicDataSource = new BasicDataSource();

        try {
            basicDataSource.setDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        basicDataSource.setUrl("jdbc:mysql://133.186.241.167:3306/nhn_academy_21");
        basicDataSource.setUsername("nhn_academy_21");
        basicDataSource.setPassword("*L]RAMG*8NYJnCKK");


        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxTotal(5);
        basicDataSource.setMaxIdle(5);
        basicDataSource.setMinIdle(5);


        basicDataSource.setValidationQuery("select 1");

        basicDataSource.setMaxWait(Duration.ofSeconds(2));

        DATASOURCE = basicDataSource;

    }

    public static DataSource getDataSource(){
        return DATASOURCE;
    }

}

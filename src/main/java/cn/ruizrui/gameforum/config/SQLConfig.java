package cn.ruizrui.gameforum.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * MySQL 配置类
 */
@Component
@Configuration
public class SQLConfig {

    @Value("${gameforum.mysql.driver}")
    private String driver;

    @Value("${gameforum.mysql.url}")
    private String url;

    @Value("${gameforum.mysql.user}")
    private String user;

    @Value("${gameforum.mysql.pwd}")
    private String pwd;

    public SQLConfig(){
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/game_forum?useSSL=false&serverTimezone=UTC";
        this.user = "root";
        this.pwd = "0508";
    }

    @Bean
    public String getDriver() {
        return driver;
    }

    @Bean
    public String getUrl() {
        return url;
    }

    @Bean
    public String getUser() {
        return user;
    }

    @Bean
    public String getPwd() {
        return pwd;
    }
}

package com.alan.cake.admin.config;

import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
@EnableConfigurationProperties({DruidDataSourceProperties.class})
public class DruidConfig {
	
	@Autowired
	private DruidDataSourceProperties properties;

	@Bean
	@ConditionalOnMissingBean
	public DataSource druidDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(properties.getDriverClassName());
		druidDataSource.setUrl(properties.getUrl());
		druidDataSource.setUsername(properties.getUsername());
		druidDataSource.setPassword(properties.getPassword());
		druidDataSource.setInitialSize(properties.getInitialSize());
		druidDataSource.setMinIdle(properties.getMinIdle());
		druidDataSource.setMaxActive(properties.getMaxActive());
		druidDataSource.setMaxWait(properties.getMaxWait());
		druidDataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
		druidDataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
		druidDataSource.setValidationQuery(properties.getValidationQuery());
		druidDataSource.setTestWhileIdle(properties.isTestWhileIdle());
		druidDataSource.setTestOnBorrow(properties.isTestOnBorrow());
		druidDataSource.setTestOnReturn(properties.isTestOnReturn());
		druidDataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());

		try {
			druidDataSource.setFilters(properties.getFilters());
			druidDataSource.init();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return druidDataSource;
	}

	/**
	 * 註冊Servlet訊息， 配置監控視圖
	 */
	@Bean
	@ConditionalOnMissingBean
	public ServletRegistrationBean<Servlet> druidServlet() {
		ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<Servlet>(new StatViewServlet(), "/druid/*");
		// IP白名單：
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1,139.196.87.48");
		// IP黑名單 (共同存在時，deny優先於allow) : 如果滿足deny的話提示:Sorry, you are not permitted to
		// view this page.
		servletRegistrationBean.addInitParameter("deny", "192.168.1.119");
		// 登錄查看訊息的帳號密碼, 用於登錄Druid監控後台
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "admin");
		// 是否能夠重置數據.
		servletRegistrationBean.addInitParameter("resetEnable", "true");
		return servletRegistrationBean;
	}

	/**
	 * 註冊Filter訊息, 監控攔截器
	 */
	@Bean
	@ConditionalOnMissingBean
	public FilterRegistrationBean<Filter> filterRegistrationBean() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}

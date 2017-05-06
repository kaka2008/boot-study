package cn.com.gei;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 多数据源配置演示
 * 
 * @author gei
 *
 */
@Configuration
@MapperScan(basePackages = "cn.com.gei.dao2", sqlSessionFactoryRef = "springSqlSessionFactory2")
public class DataSourceConfig2 {

	@Bean(name = "springDataSource2")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource sendDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "springTransactionManager2")
	public DataSourceTransactionManager transactionManager(@Qualifier("springDataSource2") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "springSqlSessionFactory2")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("springDataSource2") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
		return factoryBean.getObject();
	}
}

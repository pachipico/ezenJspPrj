package orm;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataBaseBuilder {
	private static final Logger log = LoggerFactory.getLogger(DataBaseBuilder.class);
	private static SqlSessionFactory factory;
	
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("orm/MybatisConfig.xml")
					);
		} catch (IOException e) {
			e.printStackTrace();
			log.info("---MybatisConfig Error");
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}

package org.batchoperator.test;

import java.util.HashMap;
import java.util.Map;

import org.batchoperator.util.BatchUtils;
import org.junit.Test;

/**
 * 类描述：对BatchUtils工具类进行测试
 * 类名称：org.batchoperator.test.BatchUtilsTest
 * @author 曲健磊
 * 2018年4月12日.下午5:20:15
 * @version V1.0
 */
public class BatchUtilsTest {

	/**
	 * 测试生成单条插入语句
	 */
	@Test
	public void testGenerateSqlOfInsert() {
		Map<String, String> columnMap = new HashMap<String, String>();
		columnMap.put("user_id", "String");
		columnMap.put("user_name", "String");
		columnMap.put("user_age", "String");
		
		String sql = BatchUtils.generateSqlOfInsert("pms_user", columnMap);
		
		System.out.println(sql);
		// INSERT INTO pms_user(user_id) VALUES(1)
	}
	
	/**
	 * 测试生成多条插入语句
	 */
	@Test
	public void testGenerateSqlOfBatchInsert() {
		Map<String, String> columnMap = new HashMap<String, String>();
		columnMap.put("user_id", "String");
		columnMap.put("user_name", "String");
		columnMap.put("user_age", "String");
		
		String sql = BatchUtils.generateSqlOfInsert("pms_user", columnMap, 5);
		System.out.println(sql);
		
//		INSERT INTO pms_user(user_id ,user_name ,user_age) VALUES(1 ,1 ,1);
//		INSERT INTO pms_user(user_id ,user_name ,user_age) VALUES(1 ,1 ,1);
//		INSERT INTO pms_user(user_id ,user_name ,user_age) VALUES(1 ,1 ,1);
//		INSERT INTO pms_user(user_id ,user_name ,user_age) VALUES(1 ,1 ,1);
//		INSERT INTO pms_user(user_id ,user_name ,user_age) VALUES(1 ,1 ,1);
		
	}

}

package org.batchoperator.test;

import java.util.HashMap;
import java.util.Map;

import org.batchoperator.util.BatchUtils;
import org.junit.Test;

public class BatchUtilsTest {

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

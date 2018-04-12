package org.batchoperator.test;

import java.util.HashMap;
import java.util.Map;

import org.batchoperator.util.BatchUtils;
import org.junit.Test;

public class BatchUtilsTest {

	@Test
	public void test() {
		Map<String, String> columnMap = new HashMap<String, String>();
		columnMap.put("user_id", "String");
		
		String sql = BatchUtils.generateSqlOfInsert("pms_user", columnMap);
		
		System.out.println(sql);
		// INSERT INTO pms_user(user_id) VALUES(1)
		
	}

}

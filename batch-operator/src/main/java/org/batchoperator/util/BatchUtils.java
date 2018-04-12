package org.batchoperator.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 类描述：用于对数据库进行一些批量操作的工具类
 * 类名称：org.batchoperator.util.BatchUtils
 * @author 曲健磊
 * 2018年4月12日.下午4:42:57
 * @version V1.0
 */
public class BatchUtils {
	
	/**
	 * 生成插入语句失败的错误提示信息
	 */
	public static final String INSERT_ERR_MSG = "生成插入语句失败，请检查输入参数!";
	
	/**
	 * 根据表名，字段名，字段的类型生成一条插入语句
	 * @param tabName 数据表名
	 * @param columnMap 字段名-字段类型之间的映射关系
	 * @return 生成的单条SQL语句
	 */
	public static String generateSqlOfInsert(String tabName, Map<String, String> columnMap) {
		// 合法性判断
		if (tabName == null || tabName.length() == 0 || columnMap == null || columnMap.size() == 0) {
			throw new RuntimeException(INSERT_ERR_MSG);
		}
		
		// 获取map的entrySet
		Set<Entry<String, String >> set = columnMap.entrySet();
		
		// 用于保存生成的SQL语句
		StringBuilder builder = new StringBuilder("INSERT INTO ");
		builder.append(tabName).append("(");
		for (Map.Entry<String, String> entry : set) {
			builder.append(entry.getKey()).append(" ,");
		}
		builder.setLength(builder.length() - 2);
		builder.append(")");
		
		// 生成values
		builder.append(" VALUES(");
		for (Map.Entry<String, String> entry : set) {
			builder.append("1").append(" ,");
		}
		builder.setLength(builder.length() - 2);
		builder.append(");\r\n");
		
		return builder.toString();
	}
	
	/**
	 * 根据表名，字段名，字段的类型生成批量的插入语句
	 * @param tabName 数据表名
	 * @param columnMap 字段名-字段类型之间的映射关系
	 * @param recordNum 生成的SQL语句的数量
	 * @return 批量生成的SQL语句
	 */
	public static String generateSqlOfInsert(String tabName, Map<String, String> columnMap, Integer recordNum) {
		StringBuilder batchSql = new StringBuilder();
		for (int i = 0; i < recordNum; i++) {
			String insertSql = generateSqlOfInsert(tabName, columnMap);
			batchSql.append(insertSql);
		}
		return batchSql.toString();
	}
	
}

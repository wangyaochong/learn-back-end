package com.example.learnmybatis.config.readWriteAnnotation;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataBaseContextHolder.getDataBaseType();
    }

    /**
     * 自动提交一定要开启，否则对于没有@Transaction或者手动事务管理的方法，更新数据的操作都会失效
     * 自动提交开启时，对于没有事务管理的方法，会将每个方法的更新操作单独提交
     */
//
//	@Override
//	public Connection getConnection() throws SQLException {
//		Connection connection = determineTargetDataSource().getConnection();
//		connection.setAutoCommit(false);//取消自动提交，否则事务不生效
//		return connection;
//	}
}

package com.example.learnmybatis.typeHandler;

import com.example.learnmybatis.enums.EnumSex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SexTypeHandler implements TypeHandler<EnumSex> {

    @Override
    public void setParameter(PreparedStatement ps, int i, EnumSex parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getCode());
    }

    @Override
    public EnumSex getResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return EnumSex.getFromCode(code);
    }

    @Override
    public EnumSex getResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return EnumSex.getFromCode(code);
    }

    @Override
    public EnumSex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return EnumSex.getFromCode(code);
    }
}

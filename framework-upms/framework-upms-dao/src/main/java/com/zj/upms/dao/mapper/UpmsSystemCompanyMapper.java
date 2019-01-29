package com.zj.upms.dao.mapper;

import com.zj.upms.dao.model.UpmsSystemCompany;
import com.zj.upms.dao.model.UpmsSystemCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsSystemCompanyMapper {
    long countByExample(UpmsSystemCompanyExample example);

    int deleteByExample(UpmsSystemCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UpmsSystemCompany record);

    int insertSelective(UpmsSystemCompany record);

    List<UpmsSystemCompany> selectByExample(UpmsSystemCompanyExample example);

    UpmsSystemCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UpmsSystemCompany record, @Param("example") UpmsSystemCompanyExample example);

    int updateByExample(@Param("record") UpmsSystemCompany record, @Param("example") UpmsSystemCompanyExample example);

    int updateByPrimaryKeySelective(UpmsSystemCompany record);

    int updateByPrimaryKey(UpmsSystemCompany record);
}
package cn.itcast.jk.mapper;

import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.domain.DeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    int countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int deleteByPrimaryKey(String deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptExample example);

    Dept selectByPrimaryKey(String deptId);

    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    
    //统计总记录  分页
    int findTotalCount();
    
    //统计分页集合  分页
    List<Dept> findList(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize);
}
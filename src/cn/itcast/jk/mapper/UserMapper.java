package cn.itcast.jk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.jk.domain.User;
import cn.itcast.jk.domain.UserExample;
import cn.itcast.jk.vo.UserAndInfoVo;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User findUserByNameAndPwd(@Param("name")String name,@Param("pwd")String pwd);
    
    int findTotalCount();

	List<User> findUser(@Param("pageNo")int pageNo, @Param("pageSize") int pageSize);

	List<UserAndInfoVo> findAllUser();
}
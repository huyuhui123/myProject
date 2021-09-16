package com.aa.bb.dao;

import com.aa.bb.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface userDao {
    @Select("select * from user")
    public List<User> findAllUser();
    @Select("select * from user where name='${name}'")
    public User findUserByName(@Param("name") String name);
    @Insert("insert into user(name) values('${user.name}')")
    @Options(useGeneratedKeys=true,keyProperty = "id",keyColumn="id")
    public void insertUser(@Param("user") User user);

}

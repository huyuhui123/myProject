package com.aa.bb.dao;

import com.aa.bb.entity.Lun;
import com.aa.bb.to.lunAndName;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface lunDao {
    @Select("select l.id,name,content from lun l,user u where l.u_id=u.id")
    public List<lunAndName> findAllLun();
    @Insert("insert into lun(content,u_id) values(#{lun.content},#{lun.u_id})")
    public void insertLun(@Param("lun") Lun lun);
}

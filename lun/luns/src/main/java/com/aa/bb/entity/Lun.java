package com.aa.bb.entity;

import lombok.Data;
@Data
public class Lun {
    public Integer id;
    public String content;
    public Integer u_id;

    public Lun(String content, Integer u_id) {
        this.content = content;
        this.u_id = u_id;
    }
}

package com.ming.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 
 * @TableName organization
 */
public class Organization extends BaseFields implements Serializable {
    // 组织的下属公司
    private List<Company> children;

    public List<Company> getChildren() {
        return children;
    }

    @Override
    public String getRowKey() {
        /*
         * uuid重复概率： 每秒产生10亿笔数据，100年后产生一条重复uuid的概率为50%
         * */
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return "org:" + super.getId() + ":" + uuid;
    }

    public void setChildren(List<Company> children) {
        this.children = children;
    }
}
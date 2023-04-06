package com.ming.entity;

import java.io.Serializable;
import java.util.UUID;

/**
 * 
 * @TableName department
 */
public class Department extends BaseFields implements Serializable {
    @Override
    public String getRowKey() {
        // dept:1,  dept:2:
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return "dept:" + super.getId() + ":" + uuid;
    }
}

package com.ming.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 职称表
 * @TableName joblevel
 */
public class Joblevel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    /**
     * 
     */
    private Object titlelevel;

    /**
     * 
     */
    private Date createdate;

    /**
     * 
     */
    private Integer enabled;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 职称名称
     */
    public String getName() {
        return name;
    }

    /**
     * 职称名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public Object getTitlelevel() {
        return titlelevel;
    }

    /**
     * 
     */
    public void setTitlelevel(Object titlelevel) {
        this.titlelevel = titlelevel;
    }

    /**
     * 
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * 
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Joblevel other = (Joblevel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTitlelevel() == null ? other.getTitlelevel() == null : this.getTitlelevel().equals(other.getTitlelevel()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(other.getEnabled()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTitlelevel() == null) ? 0 : getTitlelevel().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", titlelevel=").append(titlelevel);
        sb.append(", createdate=").append(createdate);
        sb.append(", enabled=").append(enabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
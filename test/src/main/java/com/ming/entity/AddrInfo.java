package com.ming.entity;

import com.ming.vo.AddrInfoVo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @TableName addr_info
 */
public class AddrInfo implements Serializable {
    /**
     * 
     */
    private Integer addrId;

    /**
     * 
     */
    private Integer addrPreId;

    /**
     * 
     */
    private String addrInfo;

    /**
     * 
     */
    private Integer lev;

    private List<AddrInfoVo> children;

    private static final long serialVersionUID = 1L;

    public List<AddrInfoVo> getChildren() {
        return children;
    }

    public void setChildren(List<AddrInfoVo> children) {
        this.children = children;
    }

    /**
     * 
     */
    public Integer getAddrId() {
        return addrId;
    }

    /**
     * 
     */
    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    /**
     * 
     */
    public Integer getAddrPreId() {
        return addrPreId;
    }

    /**
     * 
     */
    public void setAddrPreId(Integer addrPreId) {
        this.addrPreId = addrPreId;
    }

    /**
     * 
     */
    public String getAddrInfo() {
        return addrInfo;
    }

    /**
     * 
     */
    public void setAddrInfo(String addrInfo) {
        this.addrInfo = addrInfo;
    }

    /**
     * 
     */
    public Integer getLev() {
        return lev;
    }

    /**
     * 
     */
    public void setLev(Integer lev) {
        this.lev = lev;
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
        AddrInfo other = (AddrInfo) that;
        return (this.getAddrId() == null ? other.getAddrId() == null : this.getAddrId().equals(other.getAddrId()))
            && (this.getAddrPreId() == null ? other.getAddrPreId() == null : this.getAddrPreId().equals(other.getAddrPreId()))
            && (this.getAddrInfo() == null ? other.getAddrInfo() == null : this.getAddrInfo().equals(other.getAddrInfo()))
            && (this.getLev() == null ? other.getLev() == null : this.getLev().equals(other.getLev()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAddrId() == null) ? 0 : getAddrId().hashCode());
        result = prime * result + ((getAddrPreId() == null) ? 0 : getAddrPreId().hashCode());
        result = prime * result + ((getAddrInfo() == null) ? 0 : getAddrInfo().hashCode());
        result = prime * result + ((getLev() == null) ? 0 : getLev().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addrId=").append(addrId);
        sb.append(", addrPreId=").append(addrPreId);
        sb.append(", addrInfo=").append(addrInfo);
        sb.append(", lev=").append(lev);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
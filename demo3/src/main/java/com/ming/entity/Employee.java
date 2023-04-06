package com.ming.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工信息表
 * @TableName employee
 */
public class Employee implements Serializable {
    /**
     * 员工编号
     */
    private Integer id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 婚姻状况
     */
    private Object wedlock;

    /**
     * 民族
     */
    private Integer nationid;

    /**
     * 籍贯
     */
    private String nativeplace;

    /**
     * 政治面貌
     */
    private Integer politicid;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 所属部门
     */
    private Integer departmentid;

    /**
     * 职称ID
     */
    private Integer joblevelid;

    /**
     * 职位ID
     */
    private Integer posid;

    /**
     * 聘用形式
     */
    private String engageform;

    /**
     * 最高学历
     */
    private Object tiptopdegree;

    /**
     * 所属专业
     */
    private String specialty;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 入职日期
     */
    private Date begindate;

    /**
     * 在职状态
     */
    private Object workstate;

    /**
     * 工号
     */
    private String workid;

    /**
     * 合同期限
     */
    private Double contractterm;

    /**
     * 转正日期
     */
    private Date conversiontime;

    /**
     * 离职日期
     */
    private Date notworkdate;

    /**
     * 合同起始日期
     */
    private Date begincontract;

    /**
     * 合同终止日期
     */
    private Date endcontract;

    /**
     * 工龄
     */
    private Integer workage;

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 员工编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 员工姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 员工姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 身份证号
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 婚姻状况
     */
    public Object getWedlock() {
        return wedlock;
    }

    /**
     * 婚姻状况
     */
    public void setWedlock(Object wedlock) {
        this.wedlock = wedlock;
    }

    /**
     * 民族
     */
    public Integer getNationid() {
        return nationid;
    }

    /**
     * 民族
     */
    public void setNationid(Integer nationid) {
        this.nationid = nationid;
    }

    /**
     * 籍贯
     */
    public String getNativeplace() {
        return nativeplace;
    }

    /**
     * 籍贯
     */
    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    /**
     * 政治面貌
     */
    public Integer getPoliticid() {
        return politicid;
    }

    /**
     * 政治面貌
     */
    public void setPoliticid(Integer politicid) {
        this.politicid = politicid;
    }

    /**
     * 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 所属部门
     */
    public Integer getDepartmentid() {
        return departmentid;
    }

    /**
     * 所属部门
     */
    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    /**
     * 职称ID
     */
    public Integer getJoblevelid() {
        return joblevelid;
    }

    /**
     * 职称ID
     */
    public void setJoblevelid(Integer joblevelid) {
        this.joblevelid = joblevelid;
    }

    /**
     * 职位ID
     */
    public Integer getPosid() {
        return posid;
    }

    /**
     * 职位ID
     */
    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    /**
     * 聘用形式
     */
    public String getEngageform() {
        return engageform;
    }

    /**
     * 聘用形式
     */
    public void setEngageform(String engageform) {
        this.engageform = engageform;
    }

    /**
     * 最高学历
     */
    public Object getTiptopdegree() {
        return tiptopdegree;
    }

    /**
     * 最高学历
     */
    public void setTiptopdegree(Object tiptopdegree) {
        this.tiptopdegree = tiptopdegree;
    }

    /**
     * 所属专业
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * 所属专业
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * 毕业院校
     */
    public String getSchool() {
        return school;
    }

    /**
     * 毕业院校
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 入职日期
     */
    public Date getBegindate() {
        return begindate;
    }

    /**
     * 入职日期
     */
    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    /**
     * 在职状态
     */
    public Object getWorkstate() {
        return workstate;
    }

    /**
     * 在职状态
     */
    public void setWorkstate(Object workstate) {
        this.workstate = workstate;
    }

    /**
     * 工号
     */
    public String getWorkid() {
        return workid;
    }

    /**
     * 工号
     */
    public void setWorkid(String workid) {
        this.workid = workid;
    }

    /**
     * 合同期限
     */
    public Double getContractterm() {
        return contractterm;
    }

    /**
     * 合同期限
     */
    public void setContractterm(Double contractterm) {
        this.contractterm = contractterm;
    }

    /**
     * 转正日期
     */
    public Date getConversiontime() {
        return conversiontime;
    }

    /**
     * 转正日期
     */
    public void setConversiontime(Date conversiontime) {
        this.conversiontime = conversiontime;
    }

    /**
     * 离职日期
     */
    public Date getNotworkdate() {
        return notworkdate;
    }

    /**
     * 离职日期
     */
    public void setNotworkdate(Date notworkdate) {
        this.notworkdate = notworkdate;
    }

    /**
     * 合同起始日期
     */
    public Date getBegincontract() {
        return begincontract;
    }

    /**
     * 合同起始日期
     */
    public void setBegincontract(Date begincontract) {
        this.begincontract = begincontract;
    }

    /**
     * 合同终止日期
     */
    public Date getEndcontract() {
        return endcontract;
    }

    /**
     * 合同终止日期
     */
    public void setEndcontract(Date endcontract) {
        this.endcontract = endcontract;
    }

    /**
     * 工龄
     */
    public Integer getWorkage() {
        return workage;
    }

    /**
     * 工龄
     */
    public void setWorkage(Integer workage) {
        this.workage = workage;
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
        Employee other = (Employee) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getIdcard() == null ? other.getIdcard() == null : this.getIdcard().equals(other.getIdcard()))
            && (this.getWedlock() == null ? other.getWedlock() == null : this.getWedlock().equals(other.getWedlock()))
            && (this.getNationid() == null ? other.getNationid() == null : this.getNationid().equals(other.getNationid()))
            && (this.getNativeplace() == null ? other.getNativeplace() == null : this.getNativeplace().equals(other.getNativeplace()))
            && (this.getPoliticid() == null ? other.getPoliticid() == null : this.getPoliticid().equals(other.getPoliticid()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getDepartmentid() == null ? other.getDepartmentid() == null : this.getDepartmentid().equals(other.getDepartmentid()))
            && (this.getJoblevelid() == null ? other.getJoblevelid() == null : this.getJoblevelid().equals(other.getJoblevelid()))
            && (this.getPosid() == null ? other.getPosid() == null : this.getPosid().equals(other.getPosid()))
            && (this.getEngageform() == null ? other.getEngageform() == null : this.getEngageform().equals(other.getEngageform()))
            && (this.getTiptopdegree() == null ? other.getTiptopdegree() == null : this.getTiptopdegree().equals(other.getTiptopdegree()))
            && (this.getSpecialty() == null ? other.getSpecialty() == null : this.getSpecialty().equals(other.getSpecialty()))
            && (this.getSchool() == null ? other.getSchool() == null : this.getSchool().equals(other.getSchool()))
            && (this.getBegindate() == null ? other.getBegindate() == null : this.getBegindate().equals(other.getBegindate()))
            && (this.getWorkstate() == null ? other.getWorkstate() == null : this.getWorkstate().equals(other.getWorkstate()))
            && (this.getWorkid() == null ? other.getWorkid() == null : this.getWorkid().equals(other.getWorkid()))
            && (this.getContractterm() == null ? other.getContractterm() == null : this.getContractterm().equals(other.getContractterm()))
            && (this.getConversiontime() == null ? other.getConversiontime() == null : this.getConversiontime().equals(other.getConversiontime()))
            && (this.getNotworkdate() == null ? other.getNotworkdate() == null : this.getNotworkdate().equals(other.getNotworkdate()))
            && (this.getBegincontract() == null ? other.getBegincontract() == null : this.getBegincontract().equals(other.getBegincontract()))
            && (this.getEndcontract() == null ? other.getEndcontract() == null : this.getEndcontract().equals(other.getEndcontract()))
            && (this.getWorkage() == null ? other.getWorkage() == null : this.getWorkage().equals(other.getWorkage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getIdcard() == null) ? 0 : getIdcard().hashCode());
        result = prime * result + ((getWedlock() == null) ? 0 : getWedlock().hashCode());
        result = prime * result + ((getNationid() == null) ? 0 : getNationid().hashCode());
        result = prime * result + ((getNativeplace() == null) ? 0 : getNativeplace().hashCode());
        result = prime * result + ((getPoliticid() == null) ? 0 : getPoliticid().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
        result = prime * result + ((getJoblevelid() == null) ? 0 : getJoblevelid().hashCode());
        result = prime * result + ((getPosid() == null) ? 0 : getPosid().hashCode());
        result = prime * result + ((getEngageform() == null) ? 0 : getEngageform().hashCode());
        result = prime * result + ((getTiptopdegree() == null) ? 0 : getTiptopdegree().hashCode());
        result = prime * result + ((getSpecialty() == null) ? 0 : getSpecialty().hashCode());
        result = prime * result + ((getSchool() == null) ? 0 : getSchool().hashCode());
        result = prime * result + ((getBegindate() == null) ? 0 : getBegindate().hashCode());
        result = prime * result + ((getWorkstate() == null) ? 0 : getWorkstate().hashCode());
        result = prime * result + ((getWorkid() == null) ? 0 : getWorkid().hashCode());
        result = prime * result + ((getContractterm() == null) ? 0 : getContractterm().hashCode());
        result = prime * result + ((getConversiontime() == null) ? 0 : getConversiontime().hashCode());
        result = prime * result + ((getNotworkdate() == null) ? 0 : getNotworkdate().hashCode());
        result = prime * result + ((getBegincontract() == null) ? 0 : getBegincontract().hashCode());
        result = prime * result + ((getEndcontract() == null) ? 0 : getEndcontract().hashCode());
        result = prime * result + ((getWorkage() == null) ? 0 : getWorkage().hashCode());
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
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", idcard=").append(idcard);
        sb.append(", wedlock=").append(wedlock);
        sb.append(", nationid=").append(nationid);
        sb.append(", nativeplace=").append(nativeplace);
        sb.append(", politicid=").append(politicid);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", departmentid=").append(departmentid);
        sb.append(", joblevelid=").append(joblevelid);
        sb.append(", posid=").append(posid);
        sb.append(", engageform=").append(engageform);
        sb.append(", tiptopdegree=").append(tiptopdegree);
        sb.append(", specialty=").append(specialty);
        sb.append(", school=").append(school);
        sb.append(", begindate=").append(begindate);
        sb.append(", workstate=").append(workstate);
        sb.append(", workid=").append(workid);
        sb.append(", contractterm=").append(contractterm);
        sb.append(", conversiontime=").append(conversiontime);
        sb.append(", notworkdate=").append(notworkdate);
        sb.append(", begincontract=").append(begincontract);
        sb.append(", endcontract=").append(endcontract);
        sb.append(", workage=").append(workage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
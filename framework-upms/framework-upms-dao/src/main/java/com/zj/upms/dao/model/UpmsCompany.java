package com.zj.upms.dao.model;

import java.io.Serializable;

public class UpmsCompany implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 公司名称
     *
     * @mbg.generated
     */
    private String company;

    /**
     * 公司简称
     *
     * @mbg.generated
     */
    private String companyname;

    /**
     * 公司编码
     *
     * @mbg.generated
     */
    private String companycode;

    /**
     * 区域
     *
     * @mbg.generated
     */
    private String location;

    /**
     * 税率
     *
     * @mbg.generated
     */
    private Double rate;

    /**
     * 电话
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * 传真
     *
     * @mbg.generated
     */
    private String fax;

    /**
     * 网址
     *
     * @mbg.generated
     */
    private String website;

    /**
     * 类型(0:普通公司，1:管理公司{可查看隐藏功能})
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     * 状态(-1:黑名单,1:正常)
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 详细地址
     *
     * @mbg.generated
     */
    private String address;

    private String description;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Long ctime;

    /**
     * 1客户 2供应商
     *
     * @mbg.generated
     */
    private Integer companytype;

    /**
     * logo
     *
     * @mbg.generated
     */
    private String logo;

    /**
     * 英文缩写
     *
     * @mbg.generated
     */
    private String engabbreviate;

    /**
     * 公司当前开始盘点时间
     *
     * @mbg.generated
     */
    private Long checktime;

    /**
     * 租赁到期日期
     *
     * @mbg.generated
     */
    private Long duedate;

    /**
     * 公司别
     *
     * @mbg.generated
     */
    private String siteindex;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Integer getCompanytype() {
        return companytype;
    }

    public void setCompanytype(Integer companytype) {
        this.companytype = companytype;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEngabbreviate() {
        return engabbreviate;
    }

    public void setEngabbreviate(String engabbreviate) {
        this.engabbreviate = engabbreviate;
    }

    public Long getChecktime() {
        return checktime;
    }

    public void setChecktime(Long checktime) {
        this.checktime = checktime;
    }

    public Long getDuedate() {
        return duedate;
    }

    public void setDuedate(Long duedate) {
        this.duedate = duedate;
    }

    public String getSiteindex() {
        return siteindex;
    }

    public void setSiteindex(String siteindex) {
        this.siteindex = siteindex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", company=").append(company);
        sb.append(", companyname=").append(companyname);
        sb.append(", companycode=").append(companycode);
        sb.append(", location=").append(location);
        sb.append(", rate=").append(rate);
        sb.append(", phone=").append(phone);
        sb.append(", fax=").append(fax);
        sb.append(", website=").append(website);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", address=").append(address);
        sb.append(", description=").append(description);
        sb.append(", ctime=").append(ctime);
        sb.append(", companytype=").append(companytype);
        sb.append(", logo=").append(logo);
        sb.append(", engabbreviate=").append(engabbreviate);
        sb.append(", checktime=").append(checktime);
        sb.append(", duedate=").append(duedate);
        sb.append(", siteindex=").append(siteindex);
        sb.append("]");
        return sb.toString();
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
        UpmsCompany other = (UpmsCompany) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()))
            && (this.getCompanyname() == null ? other.getCompanyname() == null : this.getCompanyname().equals(other.getCompanyname()))
            && (this.getCompanycode() == null ? other.getCompanycode() == null : this.getCompanycode().equals(other.getCompanycode()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
            && (this.getWebsite() == null ? other.getWebsite() == null : this.getWebsite().equals(other.getWebsite()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getCompanytype() == null ? other.getCompanytype() == null : this.getCompanytype().equals(other.getCompanytype()))
            && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
            && (this.getEngabbreviate() == null ? other.getEngabbreviate() == null : this.getEngabbreviate().equals(other.getEngabbreviate()))
            && (this.getChecktime() == null ? other.getChecktime() == null : this.getChecktime().equals(other.getChecktime()))
            && (this.getDuedate() == null ? other.getDuedate() == null : this.getDuedate().equals(other.getDuedate()))
            && (this.getSiteindex() == null ? other.getSiteindex() == null : this.getSiteindex().equals(other.getSiteindex()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getCompanyname() == null) ? 0 : getCompanyname().hashCode());
        result = prime * result + ((getCompanycode() == null) ? 0 : getCompanycode().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
        result = prime * result + ((getWebsite() == null) ? 0 : getWebsite().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getCompanytype() == null) ? 0 : getCompanytype().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getEngabbreviate() == null) ? 0 : getEngabbreviate().hashCode());
        result = prime * result + ((getChecktime() == null) ? 0 : getChecktime().hashCode());
        result = prime * result + ((getDuedate() == null) ? 0 : getDuedate().hashCode());
        result = prime * result + ((getSiteindex() == null) ? 0 : getSiteindex().hashCode());
        return result;
    }
}
package com.portal.recruitcenter.entity;

import com.portal.recruitcenter.entity.base.BaseCompanyInfo;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

public class CompanyInfo
        extends BaseCompanyInfo {
    private static final long serialVersionUID = 1L;

    public void init() {
        if (StringUtils.isBlank(getLinkTel())) {
            setLinkTel("1111111111");
        }
        if (StringUtils.isBlank(getLinkMan())) {
            setLinkMan("a");
        }
        if (getLastPostTime() == null) {
            setLastPostTime(new Date());
        }
        if (getCheck() == null) {
            setCheck(Boolean.valueOf(false));
        }
        if (getCommend() == null) {
            setCommend(Boolean.valueOf(false));
        }
        if (getShow() == null) {
            setShow(Boolean.valueOf(false));
        }
    }

    public Integer getRegCapital() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getRegCapital();
        }
        return null;
    }

    public String getSetUp() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getSetUp();
        }
        return null;
    }

    public String getCity() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getCity();
        }
        return null;
    }

    public String getAddress() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getAddress();
        }
        return null;
    }

    public String getZipCode() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getZipCode();
        }
        return null;
    }

    public String getWebUrl() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getWebUrl();
        }
        return null;
    }

    public String getEmail() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getEmail();
        }
        return null;
    }

    public String getPhone() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getPhone();
        }
        return null;
    }

    public String getFax() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getFax();
        }
        return null;
    }

    public String getSynopsis() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getSynopsis();
        }
        return null;
    }

    public Boolean getApplyVip() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getApplyVip();
        }
        return null;
    }

    public Date getApplyTime() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getApplyTime();
        }
        return null;
    }

    public Boolean getNeedLogin() {
        CompanyInfoExt ext = getExt();
        if (ext != null) {
            return ext.getNeedLogin();
        }
        return null;
    }

    public VipType getLastVipType() {
        VipType v = getVipType();
        if (v == null) {
            return null;
        }
        if (getExt() == null) {
            return null;
        }
        if (getExt().getDredgeTime() == null) {
            return null;
        }
        long d = System.currentTimeMillis() -
                getExt().getDredgeTime().getTime();
        long day = d / 86400000L;
        if (day <= v.getDayCount().intValue()) {
            return v;
        }
        return null;
    }

    public CompanyInfo() {
    }

    public CompanyInfo(Integer id) {
        super(id);
    }

    public CompanyInfo(Integer id, String name, String linkMan, String linkTel, Boolean check, Boolean commend, Boolean show) {
        super(id, name, linkMan, linkTel, check, commend, show);
    }
}



/* Location:           F:\jspaa\aaaaaa\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.recruitcenter.entity.CompanyInfo

 * JD-Core Version:    0.7.0.1

 */
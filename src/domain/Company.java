package domain;

import java.util.Date;

public class Company {

    private String mName;
    private String mShortName;
    private Date mDate;
    private String mAddress;
    private Date mDateFoundation;
    private int mEmployeesCount;
    private String mAuditor;
    private String mPhone;
    private String mEmail;
    private String mBranch;
    private String mActivity;
    private String mLink;

    // region Setters and Getters

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getShortName() {
        return mShortName;
    }

    public void setShortName(String shortName) {
        mShortName = shortName;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public Date getDateFoundation() {
        return mDateFoundation;
    }

    public void setDateFoundation(Date dateFoundation) {
        mDateFoundation = dateFoundation;
    }

    public int getEmployeesCount() {
        return mEmployeesCount;
    }

    public void setEmployeesCount(int employeesCount) {
        mEmployeesCount = employeesCount;
    }

    public String getAuditor() {
        return mAuditor;
    }

    public void setAuditor(String auditor) {
        mAuditor = auditor;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getBranch() {
        return mBranch;
    }

    public void setBranch(String branch) {
        mBranch = branch;
    }

    public String getActivity() {
        return mActivity;
    }

    public void setActivity(String activity) {
        mActivity = activity;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }

    // endregion
}

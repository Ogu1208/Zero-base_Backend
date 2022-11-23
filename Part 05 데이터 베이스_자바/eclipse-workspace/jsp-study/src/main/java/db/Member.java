package db;

import java.sql.Date;

public class Member {

    private String memberType;
    private String userId;
    private String password;
    private String name;
    private String mobileNo;
    private boolean marketingYn;
    private Date registerDate;
    
    
    
    public String getMemberType() {
        return memberType;
    }

    public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean isMarketingYn() {
		return marketingYn;
	}

	public void setMarketingYn(boolean marketingYn) {
		this.marketingYn = marketingYn;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

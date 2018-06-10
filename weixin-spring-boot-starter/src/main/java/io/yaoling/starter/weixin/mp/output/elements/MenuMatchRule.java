package io.yaoling.starter.weixin.mp.output.elements;

/**
 * 微信个性化菜单匹配规则
 * @author liangping
 *
 */
public class MenuMatchRule {
	
	public static final int CLIENT_PLATFORM_TYPE_IOS = 1;
	public static final int CLIENT_PLATFORM_TYPE_ANDROID = 2;
	public static final int CLIENT_PLATFORM_TYPE_OTHERS = 3;
	
	public static final int SEX_MALE = 1;
	public static final int SEX_FEMALE = 2;
	
	private String group_id; 
    private Integer sex;
    private String country;
    private String province;//": "广东"; 
    private String city;//: "广州";
    private Integer client_platform_type;
    
	/**
	 * @return the group_id
	 */
	public String getGroup_id() {
		return group_id;
	}
	/**
	 * @param group_id the group_id to set
	 */
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	/**
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the client_platform_type
	 */
	public Integer getClient_platform_type() {
		return client_platform_type;
	}
	/**
	 * @param client_platform_type the client_platform_type to set
	 */
	public void setClient_platform_type(Integer client_platform_type) {
		this.client_platform_type = client_platform_type;
	}
}

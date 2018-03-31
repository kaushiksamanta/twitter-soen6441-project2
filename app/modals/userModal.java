package modals;

import java.util.List;

/**
 * userModal class to map the value from twitter and store.
 * @version 1.0
 * @see userModal
 * @author Kaushik Samanta
 */
public class userModal {
	protected long id;
	protected String name;
	protected String email;
	protected String screenName;
	protected String location;
	protected String description;
	protected String imageUrl;
	protected int followersCount;
	protected String publicUrl;
	protected Boolean isProtected;
	protected List<String> timeline;

	/**
	 * Set the value of id.
	 * @param id A variable of type long.
	 * @author Kaushik Samanta
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Set the value of name.
	 * @param name A variable of type String.
	 * @author Kaushik Samanta
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the value of email.
	 * @author Kaushik Samanta
	 * @param email A variable of type String.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Set the value of screenName.
	 * @author Kaushik Samanta
	 * @param screenName A variable of type String.
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	/**
	 * Set the value of location.
	 * @author Kaushik Samanta
	 * @param location A variable of type String.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Set the value of description.
	 * @author Kaushik Samanta
	 * @param description A variable of type String.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Set the value of followersCount.
	 * @author Kaushik Samanta
	 * @param followersCount A variable of type int.
	 */
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	/**
	 * Set the value of publicUrl.
	 * @author Kaushik Samanta
	 * @param publicUrl A variable of type String.
	 */
	public void setUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

	/**
	 * Set the value of isProtected.
	 * @author Kaushik Samanta
	 * @param isProtected A variable of type String.
	 */
	public void setIsProtected(Boolean isProtected) {
		this.isProtected = isProtected;
	}

	/**
	 * Set the value of imageUrl.
	 * @author Kaushik Samanta
	 * @param imageUrl A variable of type String.
	 */
	public void setBiggerProfileImageURLHttps(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * Set the value of timeline.
	 * @author Kaushik Samanta
	 * @param timeline A variable of type List.
	 */
	public void setTimeline(List<String> timeline) {
		this.timeline = timeline;
	}

	/**
	 * Retrieve the value of id.
	 * @author Kaushik Samanta
	 * @return A long data type.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Retrieve the value of name.
	 * @author Kaushik Samanta
	 * @return A String data type.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retrieve the value of email.
	 * @author Kaushik Samanta
	 * @return A String data type.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Retrieve the value of screenName.
	 * @author Kaushik Samanta
	 * @return A String data type.
	 */
	public String getScreenName() {
		return screenName;
	}

	/**
	 * Retrieve the value of location.
	 * @author Kaushik Samanta
	 * @return A String data type.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Retrieve the value of description.
	 * @author Kaushik Samanta
	 * @return A String data type.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Retrieve the value of followersCount.
	 * @author Kaushik Samanta
	 * @return A int data type.
	 */
	public int getFollowersCount() {
		return followersCount;
	}

	/**
	 * Retrieve the value of publicUrl.
	 * @author Kaushik Samanta
	 * @return A String type.
	 */
	public String getUrl() {
		return publicUrl;
	}

	/**
	 * Retrieve the value of isProtected.
	 * @author Kaushik Samanta
	 * @return A boolean  type.
	 */
	public Boolean getIsProtected() {
		return isProtected;
	}

	/**
	 * Retrieve the value of profileImage.
	 * @author Kaushik Samanta
	 * @return A String type.
	 */
	public String getBiggerProfileImageURLHttps() {
		return imageUrl;
	}

	/**
	 * Retrieve the value of timeline.
	 * @author Kaushik Samanta
	 * @return A List type.
	 */
	public List<String> getTimeline() {
		return timeline;
	}
	
}

package org.wicketTutorial.helloworld.model;

import java.io.Serializable;

/**
 * Represents a group a user could have.
 * 
 * @author cmanig
 */
public class Group implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = -1642771056814860900L;
	
	/** The id of the group. */
	private Integer groupId;
	/** The name of the group */
	private String groupname;
		
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
}

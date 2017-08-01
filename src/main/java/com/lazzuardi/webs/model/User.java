/**
 * 
 */
package com.lazzuardi.webs.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Adi
 *
 */
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4538672772214274078L;
	private Long id;
    private String ssoId;
    private String name;
	private String password;
	private String email;
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSsoId() {
		return ssoId;
	}
	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}
	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}

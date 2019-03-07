package com.indra.iopen.model.security.users;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.indra.iopen.model.EmployeeProfile;
import com.indra.iopen.model.Usuario;

public class EmployeeUser extends GenericUser {

	private Usuario employeeProfile;
	/**
	 * the generated serial version UID
	 */
	private static final long serialVersionUID = 4178799544135423023L;

	public EmployeeUser( Usuario employeeProfile, String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.employeeProfile = employeeProfile;
	}

	public EmployeeUser( Usuario employeeProfile, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.employeeProfile = employeeProfile;
	}

	public Usuario getEmployeeProfile() {
		return employeeProfile;
	}

	public void setEmployeeProfile(Usuario employeeProfile) {
		this.employeeProfile = employeeProfile;
	}

	

}

package com.indra.iopen.model.security.users;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Abstract User for storing iOpenuser data
 * @author mbaez
 *
 */
public abstract class GenericUser extends User {
	
	/**
	 * generated serial version UID
	 */
	private static final long serialVersionUID = 2520025774908016906L;

	public GenericUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	
	public GenericUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}	
}

package com.indra.iopen.model.security.users;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.indra.iopen.model.ClienteProfile;

public class ClientUser extends GenericUser{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4801333960765286756L;
	
	private ClienteProfile clienteProfile;

	public ClientUser(ClienteProfile clienteProfile, String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.clienteProfile = clienteProfile;
	}

	public ClientUser(ClienteProfile clienteProfile, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.clienteProfile = clienteProfile;
	}

	public ClienteProfile getClienteProfile() {
		return clienteProfile;
	}

	public void setClienteProfile(ClienteProfile clienteProfile) {
		this.clienteProfile = clienteProfile;
	}

}

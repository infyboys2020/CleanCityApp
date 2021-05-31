package com.clean.springbootstarter.services;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.clean.springbootstarter.model.User;

@SuppressWarnings("serial")
public class CleanCityUserDetails  implements UserDetails{
	
	private List<String> userRoles;
	
	private User user;

	public CleanCityUserDetails(User user, List<String> userRoles) {
		
		this.user = user;
		this.userRoles = userRoles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		String roles =StringUtils.collectionToCommaDelimitedString(userRoles);
		
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}

package com.Spring.bill.login;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/*
 * 处理用户校验逻辑-UserDetails 
 */
public class test implements UserDetails  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 private User user;
	    
	    // 权限信息
	    private Collection<? extends GrantedAuthority> authorities;

	    public void AuthUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
	        //super();
	        this.user = user;
	        this.authorities = authorities;
	    }
	    
	    // 权限信息
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
		}

		@Override
		public String getPassword() {
	        return this.user.getPassword();
		}

		@Override
		public String getUsername() {
	        return this.user.getName();
		}

		// 账户是否过期
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		// 账户是否锁定（冻结）可恢复：
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		// 密码是否过期
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		// 账户是否可用（是否被删除）不可恢复
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
	        return true; //this.user.isEnabled();
		}

}

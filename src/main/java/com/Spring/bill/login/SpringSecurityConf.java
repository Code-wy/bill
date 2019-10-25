package com.Spring.bill.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 1.使用 SpringSecurity 有很多好处：
 * 1.输入一个需要登录验证的url，先跳转到登录界面，登录成功后，立即跳转到刚才请求的url
 *
 */

@EnableWebSecurity
public class SpringSecurityConf extends WebSecurityConfigurerAdapter {
   
	@Autowired
    private CustomUserDetailsService userDetailsService;
	
	// 自定义认证规则
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO 自动生成的方法存根
		//super.configure(auth);
		 auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
	            @Override
	            public String encode(CharSequence charSequence) {
	                return charSequence.toString();
	            }

	            @Override
	            public boolean matches(CharSequence charSequence, String s) {
	                return s.equals(charSequence.toString());
	            }
	        });
	
	}
	// 定制请求的授权规则的方法(访问控制)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	//自定义需要认证才可以访问的url 和公共的url
    	 http.authorizeRequests()
         .antMatchers("/users","/register","/**").permitAll()
         .antMatchers("/admin","/user").hasRole("ADMIN")
         .antMatchers("/user").hasRole("USER")
         .anyRequest().authenticated();
    	 
    	 //开启自动配置的登录功能, 如果用户没有登陆, 自动跳转到登录页面,授权
         http
         .formLogin().loginPage("/login")// 设置登陆页
         .defaultSuccessUrl("/").permitAll()// 设置登陆成功页
         // 自定义登陆用户名和密码参数，默认为username和password
         .usernameParameter("username")
         .passwordParameter("password");
         
        // 开启注销功能,即登出
        //注销用户清空 Session
         http
         .logout().permitAll().logoutSuccessUrl("/");

         
    	 // 关闭CSRF跨域 ,否则无法提交表单
    	 http.csrf().disable();

    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**");
    }
    
}
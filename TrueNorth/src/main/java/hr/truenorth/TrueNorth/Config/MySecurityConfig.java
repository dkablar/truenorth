package hr.truenorth.TrueNorth.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import hr.truenorth.TrueNorth.Security.CustomAuthenticationFilter;
import hr.truenorth.TrueNorth.Security.CustomLoginAuthenticationProvider;
import hr.truenorth.TrueNorth.Security.MySimpleUrlAuthenticationSuccessHandler;
import hr.truenorth.TrueNorth.Service.UserService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MySimpleUrlAuthenticationSuccessHandler successHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/vhs/new").hasRole("ADMIN")
		.antMatchers("/api/rental/**").authenticated()
		.antMatchers("/homepage*").permitAll()
		.antMatchers("/logout").authenticated()
		.and()
		.formLogin()
			.loginPage("/homepage")
			.failureUrl("/homepage-error")
			.loginProcessingUrl("/login")
		.and()
		.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/homepage");
	}
	
	public CustomAuthenticationFilter authenticationFilter() throws Exception {
		CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
		filter.setAuthenticationManager(authenticationManagerBean());
		filter.setAuthenticationSuccessHandler(successHandler);
		filter.setAuthenticationFailureHandler(failureHandler());
		return filter;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}
	
	public AuthenticationProvider authProvider() {
		CustomLoginAuthenticationProvider provider 
        	= new CustomLoginAuthenticationProvider(passwordEncoder, userService);
		return provider;
	}

	public SimpleUrlAuthenticationFailureHandler failureHandler() {
		return new SimpleUrlAuthenticationFailureHandler("/homepage-error");
	}
}

package com.example.fainalprojectforbackend.Configration;

import com.example.fainalprojectforbackend.Service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
    private final MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/auth/user/register").permitAll()
                .antMatchers("/api/v1/auth/user/login").permitAll()
                .antMatchers("/api/v1/auth/user/update/password").hasAnyAuthority("Patients","HospitalAndHealthCenter","AmbulanceCenter")

                .antMatchers("/api/v1/patient/**","/api/v1/hospital/git/location","/api/v1/hospital/all/hospitals",
                        "/api/v1/ambulance/git/location", "/api/v1/ambulance/all/ambulance/center","/api/v1/order/add","/api/v1/order/git",
                        "/api/v1/order/delete","/api/v1/order/destination/location","/api/v1/order/update/patient/location",
                        "/api/v1/order/update/health/status","/api/v1/order/update/order/type","/api/v1/order/update/ambulance/info",
                        "/api/v1/order/update/hospital/info").hasAuthority("Patients")

                .antMatchers("/api/v1/hospital/account","/api/v1/hospital/update/status","/api/v1/order/update/accept/status/hospital","/api/v1/order/git/hospital").hasAuthority("Hospital")

                .antMatchers("/api/v1/ambulance/account","/api/v1/ambulance/update/status","/api/v1/order/update/accept/status/ambulance","/api/v1/order/git/ambulance").hasAuthority("AmbulanceCenter")

                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/api/v1/auth/user/logout")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .and()
                .httpBasic();
    }
}

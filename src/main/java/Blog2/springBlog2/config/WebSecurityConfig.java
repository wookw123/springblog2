package Blog2.springBlog2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;//yml에 설정한 datasource를 참조한다


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/","/auth/**")//홈페이지와 join페이지는 로그인없이 접근가능
                .permitAll()//누구나 접근가능
                .anyRequest().authenticated()//위 경로를 제외한 경로는 인증(로그인)을 해야한다
                .and()
                .formLogin() //form로그인 설정 진행
                .loginPage("/login")//커스텀 로그인 페이지 경로와 로그인 인증경로 등록
                .loginProcessingUrl("/auth/userLogin")//스프링 시큐리티가 해당요청이 들어오면 로그인을 대신한다.
                .defaultSuccessUrl("/")//로그인 성공시 갈 페이지
                .permitAll()
                .and()
                .logout()//로그아웃 설정 진행
                .logoutSuccessUrl("/")//로그아웃 성공시 갈 페이지
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static 디렉터리의 하위 파일 목록은 인증 무시
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }



    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles(" ")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username,password, "
                        + "from user "
                        + "where username = ?")
                .authoritiesByUsernameQuery("select username "
                        + "from user "
                        + "where username = ?"); //권한처리
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MessageDigestPasswordEncoder("MD5");//비밀번호 MD5 암호화
    }
}
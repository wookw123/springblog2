package Blog2.springBlog2.DTO;

import Blog2.springBlog2.model.User;
import org.hibernate.annotations.CreationTimestamp;

import java.lang.reflect.Member;
import java.sql.Timestamp;


public class UserDTO {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;

    private Timestamp createDate;
    private Timestamp updateDate;


    public UserDTO(String username, String password, String email, String phone, String address) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }



    @Override
    public String toString() {
        return "userDTO{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public User toJoin(){
        return new User(username,password,email,phone,address,createDate);
    }

    public User toLogin(){
        return new User(username,password);
    }

    public User toUpdate(){
        return new User(username,password,email,phone,address,updateDate);
    }












}

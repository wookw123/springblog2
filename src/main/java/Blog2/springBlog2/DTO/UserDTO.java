package Blog2.springBlog2.DTO;

import Blog2.springBlog2.model.User;

import java.sql.Timestamp;


public class UserDTO {


    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private Timestamp createDate;
    private Timestamp updateDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDTO(String username, String password, String email, String phone, String address, Timestamp createDate, Timestamp updateDate) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
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

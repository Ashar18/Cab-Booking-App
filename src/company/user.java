package company;

abstract public class user {
    private int user_id;
    private String name, username, password;
    private String phone;

    public user(int user_id,String name, String username,String password,String phone) {
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.password = password;
    }
    user(){}

    public String getName() {
        return name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("name changed!!!");
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println("username changed!!!");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        System.out.println("password changed!!!");
    }

    abstract public String toString();

}

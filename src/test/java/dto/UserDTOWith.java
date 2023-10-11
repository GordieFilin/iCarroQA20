package dto;

public class UserDTOWith {

    String name;

    String lastname;

    String email;

    String password;

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    //-------------------------------------------

    public UserDTOWith withName(String name){
        this.name = name;
        return this;
    }
    public UserDTOWith withLastname(String lastname){
        this.lastname = lastname;
        return this;
    }
    public UserDTOWith withEmail(String email){
        this.email = email;
        return this;
    }
    public UserDTOWith withPassword(String password){
        this.password = password;
        return this;
    }
}

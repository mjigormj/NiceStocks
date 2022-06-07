package Model;

import Controller.CRUD;
import java.sql.SQLException;

public class User {

    String userName;
    String passwd;
    String email;
    int idUsuario;

    public User(String userName, String email, String passwd) throws SQLException {
        if (CRUD.verifyIfExistsInTable("user_table", "email",email) == false) {
            this.userName = userName;
            this.email = email;
            this.passwd = passwd;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

package AUCA_Interfaces;

import AUCA.model.Users;

public interface UsersInterface {
	Users findByEmail(String user_email);

}

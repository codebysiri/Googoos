package com.mygg.mygg.storage;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {

    private static UserStorage instance;
    private Set<String> users;

    private UserStorage() {
        users = new HashSet<>();
    }

    public static synchronized UserStorage getInstance(){
        if(instance==null){
            instance = new UserStorage();
        }
        return instance;
    }

    public Set<String> getUsers() {
        return users;
    }

    // 한 번에 한 사용자에게만 메세지 발신
    public void setUsers(String usersName) throws Exception {
        if(users.contains(usersName)) {
            throw new Exception("User already exists with userName: " + usersName);
        }
        users.add(usersName);
    }
}

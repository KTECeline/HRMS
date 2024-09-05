package auth;

public class Session {
    public static String userId;
    public static String role;
    public static String username;
    public static String gender;
    public static String Dept;
    private static boolean isLoggedIn;

    public static void createSession(String userId, String role, String username, String gender, String Dept) {
        Session.userId = userId;
        Session.role = role;
        Session.username = username;
        Session.gender = gender;
        Session.Dept = Dept;
        Session.isLoggedIn = true;
    }

    public static String getUserId() {
        return userId;
    }
    
    public static String getDept(){
        return Dept;
    }
    
    public static String getGender(){
        return gender;
    }

    public static String getRole() {
        return role;
    }

    public static String getUsername() {
        return username;
    }

    public static boolean isLoggedIn() {
        return isLoggedIn;
    }
    
    public static void logout() {
        userId = null;
        role = null;
        username = null;
        isLoggedIn = false;
    }
    
    

}

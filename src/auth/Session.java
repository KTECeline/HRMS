package auth;

public class Session {
    private static String userId;
    private static String role;
    private static String username;
    private static boolean isLoggedIn;

    public static void createSession(String userId, String role, String username) {
        Session.userId = userId;
        Session.role = role;
        Session.username = username;
        Session.isLoggedIn = true;
    }

    public static String getUserId() {
        return userId;
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
}

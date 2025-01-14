/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

/**
 *
 * @author FryenX
 */
public class UserSession {

    private static String uuid;
    private static String username;
    private static String nameUser;
    private static String level;

    // Getters and setters
    public static String getUuid() {
        return uuid;
    }

    public static void setUuid(String uuid) {
        UserSession.uuid = uuid;
    }
    
    public static String getName() {
        return nameUser;
    }

    public static void setName(String name) {
        UserSession.nameUser = name;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserSession.username = username;
    }

    public static String getLevel() {
        return level;
    }

    public static void setLevel(String level) {
        UserSession.level = level;
    }

    public static void clearSession() {
        uuid = null;
        nameUser = null;
        username = null;
        level = null;
    }
}

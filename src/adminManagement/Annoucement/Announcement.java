package adminManagement.Annoucement;

import java.time.LocalDateTime;
import java.util.UUID;
import auth.Session;
import java.time.format.DateTimeFormatter;

public class Announcement {
    private String id=Session.getUserId();
    private String title;
    private String content;
    private String audience;
    private String createdBy;
    private LocalDateTime createdAt;

    // Default constructor
    public Announcement() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    // Constructor with all fields
    public Announcement(String title, String content, String audience, String createdBy) {
        this();
        this.title = title;
        this.content = content;
        this.audience = audience;
        this.createdBy = createdBy;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAudience() {
        return audience;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }

    public void setContent(String content) {
        if (content != null && !content.trim().isEmpty()) {
            this.content = content;
        } else {
            throw new IllegalArgumentException("Content cannot be empty");
        }
    }

    public void setAudience(String audience) {
        if (audience != null && !audience.trim().isEmpty()) {
            this.audience = audience;
        } else {
            throw new IllegalArgumentException("Audience cannot be empty");
        }
    }

    public void setCreatedBy(String createdBy) {
        if (createdBy != null && !createdBy.trim().isEmpty()) {
            this.createdBy = createdBy;
        } else {
            throw new IllegalArgumentException("Creator cannot be empty");
        }
    }

    public static Announcement fromString(String line) {
    String[] parts = line.split("\\|");
    System.out.println("Parts length: " + parts.length);
    for (int i = 0; i < parts.length; i++) {
        System.out.println("Part " + i + ": " + parts[i]);
    }
    if (parts.length != 6) {
        throw new IllegalArgumentException("Invalid announcement string format");
    }
    Announcement announcement = new Announcement(parts[1], parts[2], parts[3], parts[4]);
    announcement.id = parts[0];
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    announcement.createdAt = LocalDateTime.parse(parts[5], formatter);
    return announcement;
}


}
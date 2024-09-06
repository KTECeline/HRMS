/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adminManagement.DisplayA;

/**
 *
 * @author leopa
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Edit {
    private String audience;
    private boolean showAll;

    public Edit(String audience, boolean showAll) {
        this.audience = audience;
        this.showAll = showAll;
    }

public void displayAnnouncements(List<Announcement> announcements) {
    List<Announcement> filteredAnnouncements = new ArrayList<>();
    for (Announcement announcement : announcements) {
        String announcementAudience = announcement.getAudience();
        if (announcementAudience.equals(audience) || announcementAudience.equals("All")) {
            filteredAnnouncements.add(announcement);
        }
    }
    displayAnnouncementsInList(filteredAnnouncements);
}


    public List<Announcement> readAnnouncementsFromFile() throws IOException {
        List<Announcement> announcements = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("announcement.txt"))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split("\\|");
                Announcement announcement = new Announcement(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                announcements.add(announcement);
            }
        }
        return announcements;
    }

    private void displayAnnouncementsInList(List<Announcement> announcements) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Announcement announcement : announcements) {
            listModel.addElement(announcement.getTitle() + " - " + announcement.getContent());
        }
        JList<String> list = new JList<>(listModel);
        JOptionPane.showMessageDialog(null, list, "Announcements for " + audience, JOptionPane.INFORMATION_MESSAGE);
    }
}

class Announcement {
    private String id;
    private String title;
    private String content;
    private String audience;
    private String createdBy;
    private String date;

    public Announcement(String id, String title, String content, String audience, String createdBy, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.audience = audience;
        this.createdBy = createdBy;
        this.date = date;
    }

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

    public String getDate() {
        return date;
    }
}
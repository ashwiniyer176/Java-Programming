package GUI;

import java.awt.event.MouseListener;

public class Event implements MouseListener {
    int clicks = 0;
    int enter = 0;
    int exit = 0;
    int press = 0;
    int release = 0;

    String ReturnStats() {
        String TotalStats = "";
        TotalStats = TotalStats + "Total Clicks :- " + clicks + "\n";
        TotalStats = TotalStats + "Total enter :- " + enter + "\n";
        TotalStats = TotalStats + "Total exit :- " + exit + "\n";
        TotalStats = TotalStats + "Total press :- " + press + "\n";
        TotalStats = TotalStats + "Total release :- " + release + "\n";

        return TotalStats;
    }

    void DisplayStats() {
        System.out.println("Total Clicks :- " + clicks);
        System.out.println("Total enter :- " + enter);
        System.out.println("Total exit :- " + exit);
        System.out.println("Total press :- " + press);
        System.out.println("Total release :- " + release);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        try {
            clicks++;
            throw new Exceptions("You Just Clicked");
        } catch (Exceptions ex) {
            System.out.println("Exception :- " + ex);
        }

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        press++;
        try {
            throw new Exceptions("You Just Pressed");
        } catch (Exceptions ex) {
            System.out.println("Exception: " + ex);
        }

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        release++;
        try {
            throw new Exceptions("You Just Realesed");
        } catch (Exceptions ex) {
            System.out.println("Exception :- " + ex);
        }
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        enter++;
        try {
            throw new Exceptions("You Just Entered");
        } catch (Exceptions ex) {
            System.out.println("Exception :- " + ex);
        }
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        exit++;
        try {
            throw new Exceptions("You Just Exited");
        } catch (Exceptions ex) {
            System.out.println("Exception :- " + ex);
        }
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

/**
 * TournamentFlagApp - FIFA World Cup 2022 Flag Display Application
 * 
 * This application displays a dropdown menu with 6 teams and shows
 * the corresponding flag when a team is selected.
 * 
 * Place flag images (PNG/JPG) in the /src/flags/ directory with names:
 * - argentina.png (or .jpg)
 * - brazil.png
 * - france.png
 * - germany.png
 * - spain.png
 * - portugal.png
 */
public class TournamentFlagApp extends JFrame {
    private JComboBox<String> teamComboBox;
    private JLabel flagLabel;
    private JLabel titleLabel;
    
    // Team names
    private final String[] teams = {
        "Select a Team",
        "Argentina",
        "Brazil",
        "France",
        "Germany",
        "Spain",
        "Portugal"
    };
    
    public TournamentFlagApp() {
        initializeGUI();
    }
    
    private void initializeGUI() {
        setTitle("FIFA World Cup 2022 - Flag Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(20, 20));
        
        // Tournament title
        titleLabel = new JLabel("FIFA World Cup 2022", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(0, 100, 200));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        
        // Dropdown for teams
        teamComboBox = new JComboBox<>(teams);
        teamComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        teamComboBox.setPreferredSize(new Dimension(200, 35));
        teamComboBox.addActionListener(new TeamSelectionListener());
        
        // Flag display label
        flagLabel = new JLabel("", JLabel.CENTER);
        flagLabel.setPreferredSize(new Dimension(400, 300));
        flagLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 2),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        flagLabel.setHorizontalAlignment(JLabel.CENTER);
        flagLabel.setVerticalAlignment(JLabel.CENTER);
        
        // Panel for dropdown
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        controlPanel.add(new JLabel("Select Team: "));
        controlPanel.add(teamComboBox);
        
        // Panel for flag display
        JPanel flagPanel = new JPanel(new BorderLayout());
        flagPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        flagPanel.add(flagLabel, BorderLayout.CENTER);
        
        // Main container
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(controlPanel, BorderLayout.CENTER);
        mainPanel.add(flagPanel, BorderLayout.SOUTH);
        
        add(mainPanel, BorderLayout.CENTER);
        
        // Set initial state
        pack();
        setLocationRelativeTo(null);
        setResizable(true);
    }
    
    private class TeamSelectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedTeam = (String) teamComboBox.getSelectedItem();
            
            if (selectedTeam == null || selectedTeam.equals("Select a Team")) {
                flagLabel.setIcon(null);
                flagLabel.setText("No team selected");
                return;
            }
            
            // Load flag image
            ImageIcon flagIcon = loadFlagImage(selectedTeam.toLowerCase());
            
            if (flagIcon != null) {
                // Scale image to fit display area
                Image image = flagIcon.getImage();
                Image scaledImage = image.getScaledInstance(
                    350, 
                    250, 
                    Image.SCALE_SMOOTH
                );
                flagLabel.setIcon(new ImageIcon(scaledImage));
                flagLabel.setText("");
            } else {
                flagLabel.setIcon(null);
                flagLabel.setText("<html><center>Flag image not found<br/>" +
                    "Please place " + selectedTeam.toLowerCase() + 
                    ".png or .jpg<br/>in /src/flags/ directory</center></html>");
            }
        }
    }
    
    /**
     * Loads flag image from the /src/flags/ directory
     * Tries both PNG and JPG formats
     */
    private ImageIcon loadFlagImage(String countryName) {
        // Try to load from classpath first (for Eclipse project structure)
        String[] extensions = {".png", ".jpg", ".jpeg"};
        
        for (String ext : extensions) {
            // Try classpath resource (works in Eclipse)
            URL imageURL = getClass().getResource("/flags/" + countryName + ext);
            if (imageURL != null) {
                return new ImageIcon(imageURL);
            }
            
            // Try file system path (relative to project root)
            File imageFile = new File("src/flags/" + countryName + ext);
            if (imageFile.exists() && imageFile.isFile()) {
                return new ImageIcon(imageFile.getAbsolutePath());
            }
            
            // Try absolute path from current directory
            imageFile = new File(System.getProperty("user.dir") + "/src/flags/" + countryName + ext);
            if (imageFile.exists() && imageFile.isFile()) {
                return new ImageIcon(imageFile.getAbsolutePath());
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        // Set look and feel to system default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create and show the application
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TournamentFlagApp().setVisible(true);
            }
        });
    }
}


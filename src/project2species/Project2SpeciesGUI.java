
package project2species;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static project2species.MySQLConnection.DB_URL;
import static project2species.MySQLConnection.PASS;
import static project2species.MySQLConnection.USER;


public class Project2SpeciesGUI extends javax.swing.JFrame {
    
    
    private final String SPECIES_TEXT_FILE = "src/project2species/SpeciesList.txt";
    private  ArrayList<Species> animals = new ArrayList<Species>();
    private Species myPerson = new Species();
      private int currentName = 1, sizeOfDB;



 
    public Project2SpeciesGUI() {
        initComponents();
        updateSpeciesListJList(); // Populate the JList after the GUI is set up
        speciesSelector();  // Set up the listener after initializing components



        readFromTextFile(SPECIES_TEXT_FILE);
        createDB();
        String url = DB_URL;
        String user = USER;
        String password = PASS;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        speciesListJjScrollPane = new javax.swing.JScrollPane();
        speciesListJList = new javax.swing.JList<>();
        bottomButtonsJPanel = new javax.swing.JPanel();
        addJButton = new javax.swing.JButton();
        editJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        nameOfSpeceiesJLabel = new javax.swing.JLabel();
        GenusJLabel = new javax.swing.JLabel();
        populationJLabel = new javax.swing.JLabel();
        DietJLabel = new javax.swing.JLabel();
        HabitatJLabel = new javax.swing.JLabel();
        PredatorsJLabel = new javax.swing.JLabel();
        GenusJTextField = new javax.swing.JTextField();
        PopulationJTextField = new javax.swing.JTextField();
        DietJTextField = new javax.swing.JTextField();
        HabitatJTextField = new javax.swing.JTextField();
        PredatorsJTextField = new javax.swing.JTextField();
        NameOfSpeciesJTextField = new javax.swing.JTextField();
        imageMainJLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        speciesListJjScrollPane.setViewportView(speciesListJList);

        addJButton.setText("Add");

        editJButton.setText("Edit");

        deleteJButton.setText("Delete");

        exitJButton.setText("Exit");

        javax.swing.GroupLayout bottomButtonsJPanelLayout = new javax.swing.GroupLayout(bottomButtonsJPanel);
        bottomButtonsJPanel.setLayout(bottomButtonsJPanelLayout);
        bottomButtonsJPanelLayout.setHorizontalGroup(
            bottomButtonsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomButtonsJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(editJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        bottomButtonsJPanelLayout.setVerticalGroup(
            bottomButtonsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomButtonsJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bottomButtonsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        nameOfSpeceiesJLabel.setText("Name Of Species:");

        GenusJLabel.setText("Genus:");

        populationJLabel.setText("Population:");

        DietJLabel.setText("Diet:");

        HabitatJLabel.setText("Habitat:");

        PredatorsJLabel.setText("Predators:");

        GenusJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenusJTextFieldActionPerformed(evt);
            }
        });

        DietJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DietJTextFieldActionPerformed(evt);
            }
        });

        HabitatJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HabitatJTextFieldActionPerformed(evt);
            }
        });

        PredatorsJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PredatorsJTextFieldActionPerformed(evt);
            }
        });

        NameOfSpeciesJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameOfSpeciesJTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(GenusJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameOfSpeceiesJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(populationJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DietJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(HabitatJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HabitatJTextField)
                            .addComponent(DietJTextField)
                            .addComponent(PopulationJTextField)
                            .addComponent(GenusJTextField)
                            .addComponent(NameOfSpeciesJTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(PredatorsJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PredatorsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameOfSpeceiesJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameOfSpeciesJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenusJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenusJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(populationJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PopulationJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DietJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DietJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HabitatJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HabitatJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PredatorsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PredatorsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 204));
        jLabel1.setText("Endangered Species");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bottomButtonsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(speciesListJjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageMainJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageMainJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(speciesListJjScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottomButtonsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private ArrayList<String> fetchSpeciesNames() {
    ArrayList<String> names = new ArrayList<>();
    String query = "SELECT name FROM SpeciesTable";  // Adjust if your column name differs
    try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            names.add(rs.getString("name"));
        }
    } catch (SQLException exp) {
        JOptionPane.showMessageDialog(null, "SQL error: " + exp.getMessage(),
                                      "SQL Error!", JOptionPane.ERROR_MESSAGE);
    }
    return names;
}

    private void updateSpeciesListJList() {
    DefaultListModel<String> model = new DefaultListModel<>();
    ArrayList<String> speciesNames = fetchSpeciesNames();
    for (String name : speciesNames) {
        model.addElement(name);
    }
    speciesListJList.setModel(model);
}

    
     private void createDB()
            
    {   
        try
        {            
            String url = DB_URL;
            String user = USER;
            String password = PASS;
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            DatabaseMetaData dbm = con.getMetaData();
            ResultSet table;
            
            table = dbm.getTables(null, null, "SpeciesTable", null);
           if (table.next()) {
        stmt.executeUpdate("DROP TABLE SpeciesTable");
    }

    // Create a new "SpeciesTable" with appropriate columns for the Species model
    stmt.executeUpdate("CREATE TABLE SpeciesTable (speciesID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, "
            + "name VARCHAR(50), genus VARCHAR(50), population INT, diet VARCHAR(50), "
            + "habitat VARCHAR(50), predators VARCHAR(50), PRIMARY KEY (speciesID))");

    // Assuming 'speciesList' is a List<Species> containing all the species data
    for (Species species : animals) {
        // Prepare and execute the SQL INSERT statement for each species
        String sql = "INSERT INTO SpeciesTable (name, genus, population, diet, habitat, predators) VALUES ('"
                + species.getName() + "', '"
                + species.getGenus() + "', "
                + species.getPopulation() + ", '"
                + species.getDiet() + "', '"
                + species.getHabitat() + "', '"
                + species.getPredators() + "')";
        stmt.executeUpdate(sql);
    }

            stmt.close();
        }
        catch(SQLException exp)
        {
//            exp.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL error",
                    "SQL Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     
     
     private void readFromTextFile(String textFile)
{
    try
    {
        FileReader freader = new FileReader(textFile);
        BufferedReader input = new BufferedReader(freader);
        String line = input.readLine();

        while (line != null)
        {
            Species tempSpecies = new Species();
            StringTokenizer token = new StringTokenizer(line, ",");
            while (token.hasMoreElements())
            {
                tempSpecies.setName(token.nextToken());
                tempSpecies.setGenus(token.nextToken());
                tempSpecies.setPopulation(Integer.parseInt(token.nextToken()));
                tempSpecies.setDiet(token.nextToken());
                tempSpecies.setHabitat(token.nextToken());
                tempSpecies.setPredators(token.nextToken());
            }
            animals.add(tempSpecies); // Assuming speciesList is already declared
            line = input.readLine();
        }
        input.close();
    }
    catch (FileNotFoundException fnfexp)
    {
        fnfexp.printStackTrace();
        JOptionPane.showMessageDialog(null, "Input error -- File not found.",
                "File Not Found Error!", JOptionPane.ERROR_MESSAGE);
    }
    catch (IOException | NumberFormatException exp)
    {
        // You might decide whether to print stack trace based on the need for debugging
        // exp.printStackTrace();
        JOptionPane.showMessageDialog(null, "Input error -- File could not be read or data is improperly formatted.",
                "File Read Error!", JOptionPane.ERROR_MESSAGE);
    }
}
     

   private void speciesSelector() {
    speciesListJList.addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                String selectedSpeciesDetails = speciesListJList.getSelectedValue();
                if (selectedSpeciesDetails != null) {
                    String[] details = selectedSpeciesDetails.trim().split(",", -1); // Ensuring trimming and preserving empty
                    String selectedSpeciesName = details[0].trim();
                    String selectedSpeciesGenus = details.length > 1 && !details[1].trim().isEmpty() ? details[1].trim() : "Unknown";

                    System.out.println("Parsed name: " + selectedSpeciesName + ", Parsed genus: " + selectedSpeciesGenus);

                    // Finding species by name
                    Species selectedSpecies = findSpeciesByName(selectedSpeciesName);
                    if (selectedSpecies != null) {
                        System.out.println("Selected Species Info by Name: " + selectedSpecies);
                        NameOfSpeciesJTextField.setText(selectedSpecies.getName());
                    } else {
                        System.out.println("Species not found by name in the list");
                        NameOfSpeciesJTextField.setText("");
                    }

                    // Finding species by genus
                    Species speciesByGenus = findSpeciesByGenus(selectedSpeciesGenus);
                    if (speciesByGenus != null) {
                        System.out.println("Selected Species Info by Genus: " + speciesByGenus);
                        GenusJTextField.setText(speciesByGenus.getGenus());
                    } else {
                        System.out.println("Species not found by genus in the list");
                        GenusJTextField.setText("Unknown");
                    }
                } else {
                    NameOfSpeciesJTextField.setText("");
                    GenusJTextField.setText("");
                    System.out.println("No species selected");
                }
            }
        }
    });
}

             









private Species findSpeciesByName(String name) {
    for (Species species : animals) {
        if (species.getName().equals(name)) {
            return species;
        }
    }
    return null;  
}

private Species findSpeciesByGenus(String genus) {
    for (Species species : animals) {
        if (species.getGenus().equals(genus)) {
            return species;
        }
    }
    return null;
}


     
    

    
    private void GenusJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenusJTextFieldActionPerformed
        // TODO add your handling code here:
                  System.out.println("Action performed on NameOfSpeciesJTextField: " + GenusJTextField.getText());

    }//GEN-LAST:event_GenusJTextFieldActionPerformed

    private void DietJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DietJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DietJTextFieldActionPerformed

    private void HabitatJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HabitatJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HabitatJTextFieldActionPerformed

    private void PredatorsJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PredatorsJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PredatorsJTextFieldActionPerformed

    private void NameOfSpeciesJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameOfSpeciesJTextFieldActionPerformed
          System.out.println("Action performed on NameOfSpeciesJTextField: " + NameOfSpeciesJTextField.getText());

    }//GEN-LAST:event_NameOfSpeciesJTextFieldActionPerformed

   
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project2SpeciesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DietJLabel;
    private javax.swing.JTextField DietJTextField;
    private javax.swing.JLabel GenusJLabel;
    private javax.swing.JTextField GenusJTextField;
    private javax.swing.JLabel HabitatJLabel;
    private javax.swing.JTextField HabitatJTextField;
    private javax.swing.JTextField NameOfSpeciesJTextField;
    private javax.swing.JTextField PopulationJTextField;
    private javax.swing.JLabel PredatorsJLabel;
    private javax.swing.JTextField PredatorsJTextField;
    private javax.swing.JButton addJButton;
    private javax.swing.JPanel bottomButtonsJPanel;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JButton editJButton;
    private javax.swing.JButton exitJButton;
    private javax.swing.JLabel imageMainJLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameOfSpeceiesJLabel;
    private javax.swing.JLabel populationJLabel;
    private javax.swing.JList<String> speciesListJList;
    private javax.swing.JScrollPane speciesListJjScrollPane;
    // End of variables declaration//GEN-END:variables
}

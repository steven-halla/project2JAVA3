
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
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static project2species.MySQLConnection.DB_URL;
import static project2species.MySQLConnection.PASS;
import static project2species.MySQLConnection.USER;
import java.sql.PreparedStatement;


public class Project2SpeciesGUI extends javax.swing.JFrame {
    
    
    private final String SPECIES_TEXT_FILE = "src/project2species/SpeciesList.txt";
    private  ArrayList<Species> animals = new ArrayList<Species>();
    private Species myPerson = new Species();
      private int currentName = 1, sizeOfDB;



 
    public Project2SpeciesGUI() {
        initComponents();
//            loadSpeciesFromDatabase();  // Load species data from database

        updateSpeciesListJList(); // Populate the JList after the GUI is set up
        speciesSelector();  // Set up the listener after initializing components



//        readFromTextFile(SPECIES_TEXT_FILE);
//        createDB();
        String url = DB_URL;
        String user = USER;
        String password = PASS;
        
         System.out.println("Loaded species data from database:");
    for (Species species : animals) {
        System.out.println(species);
    }
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
        jLabel2 = new javax.swing.JLabel();
        searchJTextField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        searchJMenuItem = new javax.swing.JMenuItem();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        speciesListJjScrollPane.setViewportView(speciesListJList);

        addJButton.setText("Add");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        editJButton.setText("Edit");
        editJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButtonActionPerformed(evt);
            }
        });

        deleteJButton.setText("Delete");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

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

        PopulationJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PopulationJTextFieldActionPerformed(evt);
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

        NameOfSpeciesJTextField.setEditable(false);
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

        jLabel2.setText("Search:");

        searchJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJTextFieldActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sort");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Database Management");

        searchJMenuItem.setText("search");
        searchJMenuItem.setToolTipText("");
        searchJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(searchJMenuItem);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bottomButtonsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(speciesListJjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageMainJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jLabel2)
                                .addGap(57, 57, 57)
                                .addComponent(searchJTextField)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(searchJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
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

    private void loadSpeciesFromDatabase() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // Load the database driver (if necessary)
        Class.forName("com.mysql.jdbc.Driver");

        // Establish a connection
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // Create a statement object to perform the query
        stmt = conn.createStatement();

        // SQL query to fetch name and genus
        String sql = "SELECT name, genus FROM SpeciesTable";
        rs = stmt.executeQuery(sql);

        // Clear the current list
        animals.clear();

        // Process the result set
        while (rs.next()) {
            String name = rs.getString("name");
            String genus = rs.getString("genus");

            // Create a new Species object and add it to the list
            Species species = new Species(name, genus, 0, "", "", "");
            animals.add(species);
        }
    } catch (ClassNotFoundException e) {
        System.err.println("Driver not found: " + e.getMessage());
    } catch (SQLException e) {
        System.err.println("SQL error: " + e.getMessage());
    } finally {
        // Close all resources
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("SQL error on close: " + e.getMessage());
        }
    }
}

    
    private ArrayList<String> fetchSpeciesNames() {
    ArrayList<String> names = new ArrayList<>();
    String query = "SELECT name FROM SpeciesTable";  
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
     
private Map<String, String> findSpeciesNames() {
    Map<String, String> speciesMap = new HashMap<>();
    String query = "SELECT name FROM SpeciesTable WHERE name IS NOT NULL AND name != ''";
    try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            String name = rs.getString("name");
            if (name != null && !name.isEmpty()) {
                speciesMap.put(name, ""); // Put an empty string for genus initially
            }
        }
    } catch (SQLException exp) {
        JOptionPane.showMessageDialog(null, "SQL error: " + exp.getMessage(),
                                      "SQL Error!", JOptionPane.ERROR_MESSAGE);
    }
    return speciesMap;
}

private Map<String, String> findSpeciesGenera() {
    Map<String, String> genusMap = new HashMap<>();
    String query = "SELECT name, genus FROM SpeciesTable WHERE name IS NOT NULL AND genus IS NOT NULL AND name != '' AND genus != ''";
    try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            String name = rs.getString("name");
            String genus = rs.getString("genus");
            if (name != null && !name.isEmpty() && genus != null && !genus.isEmpty()) {
                genusMap.put(name, genus);
            }
        }
    } catch (SQLException exp) {
        JOptionPane.showMessageDialog(null, "SQL error: " + exp.getMessage(),
                                      "SQL Error!", JOptionPane.ERROR_MESSAGE);
    }
    return genusMap;
}

private Map<String, Integer> findSpeciesPopulations() {
    Map<String, Integer> populationMap = new HashMap<>();
    String query = "SELECT name, population FROM SpeciesTable WHERE name IS NOT NULL AND population IS NOT NULL AND name != '' AND population > 0";
    try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            String name = rs.getString("name");
            int population = rs.getInt("population");
            if (name != null && !name.isEmpty() && population > 0) {
                populationMap.put(name, population);
            }
        }
    } catch (SQLException exp) {
        JOptionPane.showMessageDialog(null, "SQL error: " + exp.getMessage(),
                                      "SQL Error!", JOptionPane.ERROR_MESSAGE);
    }
    return populationMap;
}

private Map<String, String> findSpeciesDiets() {
    Map<String, String> dietMap = new HashMap<>();
    String query = "SELECT name, diet FROM SpeciesTable WHERE name IS NOT NULL AND diet IS NOT NULL AND name != '' AND diet != ''";
    try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            String name = rs.getString("name");
            String diet = rs.getString("diet");
            if (name != null && !name.isEmpty() && diet != null && !diet.isEmpty()) {
                dietMap.put(name, diet);
            }
        }
    } catch (SQLException exp) {
        JOptionPane.showMessageDialog(null, "SQL error: " + exp.getMessage(),
                                      "SQL Error!", JOptionPane.ERROR_MESSAGE);
    }
    return dietMap;
}

private Map<String, String> findSpeciesHabitats() {
    Map<String, String> habitatMap = new HashMap<>();
    String query = "SELECT name, habitat FROM SpeciesTable WHERE name IS NOT NULL AND habitat IS NOT NULL AND name != '' AND habitat != ''";
    try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            String name = rs.getString("name");
            String habitat = rs.getString("habitat");
            if (name != null && !name.isEmpty() && habitat != null && !habitat.isEmpty()) {
                habitatMap.put(name, habitat);
            }
        }
    } catch (SQLException exp) {
        JOptionPane.showMessageDialog(null, "SQL error: " + exp.getMessage(),
                                      "SQL Error!", JOptionPane.ERROR_MESSAGE);
    }
    return habitatMap;
}

private Map<String, String> findSpeciesPredators() {
    Map<String, String> predatorMap = new HashMap<>();
    String query = "SELECT name, predators FROM SpeciesTable WHERE name IS NOT NULL AND predators IS NOT NULL AND name != '' AND predators != ''";
    try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            String name = rs.getString("name");
            String predators = rs.getString("predators");
            if (name != null && !name.isEmpty() && predators != null && !predators.isEmpty()) {
                predatorMap.put(name, predators);
            }
        }
    } catch (SQLException exp) {
        JOptionPane.showMessageDialog(null, "SQL error: " + exp.getMessage(),
                                      "SQL Error!", JOptionPane.ERROR_MESSAGE);
    }
    return predatorMap;
}


private void speciesSelector() {
    Map<String, String> speciesNameMap = findSpeciesNames();
    Map<String, String> speciesGenusMap = findSpeciesGenera();
    Map<String, Integer> speciesPopulationMap = findSpeciesPopulations();
    Map<String, String> speciesDietMap = findSpeciesDiets();
    Map<String, String> speciesHabitatMap = findSpeciesHabitats();
    Map<String, String> speciesPredatorMap = findSpeciesPredators(); // New line added

    speciesListJList.addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                String selectedSpeciesName = speciesListJList.getSelectedValue();
                if (selectedSpeciesName != null) {
                    String selectedSpeciesGenus = speciesGenusMap.get(selectedSpeciesName);
                    Integer selectedSpeciesPopulation = speciesPopulationMap.get(selectedSpeciesName);
                    String selectedSpeciesDiet = speciesDietMap.get(selectedSpeciesName);
                    String selectedSpeciesHabitat = speciesHabitatMap.get(selectedSpeciesName);
                    String selectedSpeciesPredator = speciesPredatorMap.get(selectedSpeciesName); // New line added
                    if (selectedSpeciesGenus != null) {
                        System.out.println("Selected Species Name: " + selectedSpeciesName + ", Genus: " + selectedSpeciesGenus);
                        // Display species name
                        NameOfSpeciesJTextField.setText(selectedSpeciesName);

                        // Display species genus
                        GenusJTextField.setText(selectedSpeciesGenus);

                        // Display species population
                        PopulationJTextField.setText(selectedSpeciesPopulation != null ? selectedSpeciesPopulation.toString() : "");

                        // Display species diet
                        DietJTextField.setText(selectedSpeciesDiet != null ? selectedSpeciesDiet : "");

                        // Display species habitat
                        HabitatJTextField.setText(selectedSpeciesHabitat != null ? selectedSpeciesHabitat : "");

                        // Display species predator
                        PredatorsJTextField.setText(selectedSpeciesPredator != null ? selectedSpeciesPredator : ""); // New line added
                    } else {
                        System.out.println("Genus not found for species: " + selectedSpeciesName);
                    }
                } else {
                    NameOfSpeciesJTextField.setText("");
                    GenusJTextField.setText("");
                    PopulationJTextField.setText("");
                    DietJTextField.setText("");
                    HabitatJTextField.setText("");
                    PredatorsJTextField.setText(""); 
                    System.out.println("No species selected");
                }
            }
        }
    });
}






private Species findSpeciesByGenus(String genus) {
    // If genus is unknown or empty, return null
    if (genus == null || genus.isEmpty() || genus.equals("Unknown")) {
        return null;
    }

    for (Species species : animals) {
        // Check if the genus matches, ignoring case
        if (species.getGenus().equalsIgnoreCase(genus)) {
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
                          System.out.println("Action performed on NameOfSpeciesJTextField: " + DietJTextField.getText());

    }//GEN-LAST:event_DietJTextFieldActionPerformed

    private void HabitatJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HabitatJTextFieldActionPerformed
        // TODO add your handling code here:
                          System.out.println("Action performed on NameOfSpeciesJTextField: " + HabitatJTextField.getText());

    }//GEN-LAST:event_HabitatJTextFieldActionPerformed

    private void PredatorsJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PredatorsJTextFieldActionPerformed
        // TODO add your handling code here:
                          System.out.println("Action performed on NameOfSpeciesJTextField: " + PredatorsJTextField.getText());

    }//GEN-LAST:event_PredatorsJTextFieldActionPerformed

    private void NameOfSpeciesJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameOfSpeciesJTextFieldActionPerformed
          System.out.println("Action performed on NameOfSpeciesJTextField: " + NameOfSpeciesJTextField.getText());

    }//GEN-LAST:event_NameOfSpeciesJTextFieldActionPerformed

    private void PopulationJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PopulationJTextFieldActionPerformed
        // TODO add your handling code here:
                          System.out.println("Action performed on NameOfSpeciesJTextField: " + PopulationJTextField.getText());

    }//GEN-LAST:event_PopulationJTextFieldActionPerformed
   
    
    private void display(Species mySpecies)
    {
    NameOfSpeciesJTextField.setText(mySpecies.getName());
    GenusJTextField.setText(mySpecies.getGenus());
    PopulationJTextField.setText(String.valueOf(mySpecies.getPopulation()));
    DietJTextField.setText(mySpecies.getDiet());
    HabitatJTextField.setText(mySpecies.getHabitat());
    PredatorsJTextField.setText(mySpecies.getPredators());
    }
    
      private boolean exists(Species mySpecies)
    {
        boolean found = false;
        try
        {
            
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in exists.", 
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return found;
    }
    
    
    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
      System.out.println("Opening AddSpecies dialog...");
    try {
        // Open AddSpecies dialog
        AddSpecies myAddForm = new AddSpecies(this, true);
        System.out.println("Dialog created");
        myAddForm.setVisible(true);
        System.out.println("Dialog should now be visible");

        // Check if the dialog is visible
        if (myAddForm.isVisible()) {
            System.out.println("Dialog is visible");
        } else {
            System.out.println("Dialog is not visible");
        }

        // Get the new species data from the form
        Species newSpecies = myAddForm.getSpecies();
        if (newSpecies != null) {
            System.out.println("New species data retrieved: " + newSpecies.getName());
        } else {
            System.out.println("No new species data retrieved");
        }
    } catch (Exception exp) {
        exp.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error opening the AddSpecies form", "Error!", JOptionPane.ERROR_MESSAGE);
    }
         
    }//GEN-LAST:event_addJButtonActionPerformed

    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJButtonActionPerformed
        // TODO add your handling code here:
          // Check if a species is selected
    if (NameOfSpeciesJTextField.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a species.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Get selected species details
    String selectedSpeciesName = NameOfSpeciesJTextField.getText();
    String selectedSpeciesGenus = GenusJTextField.getText();
    int selectedSpeciesPopulation = Integer.parseInt(PopulationJTextField.getText());
    String selectedSpeciesDiet = DietJTextField.getText();
    String selectedSpeciesHabitat = HabitatJTextField.getText();
    String selectedSpeciesPredator = PredatorsJTextField.getText();

    // Create a Species object with the selected details
    Species selectedSpecies = new Species(selectedSpeciesName, selectedSpeciesGenus, selectedSpeciesPopulation, selectedSpeciesDiet, selectedSpeciesHabitat, selectedSpeciesPredator);

    // Open the EditSpecies form
    EditSpecies myEditForm = new EditSpecies(this, true, selectedSpecies);
    myEditForm.setVisible(true);

    // After the dialog is closed, get the updated species
    Species updatedSpecies = myEditForm.getSpecies();

    // Update the display with the edited species details
    NameOfSpeciesJTextField.setText(updatedSpecies.getName());
    GenusJTextField.setText(updatedSpecies.getGenus());
    PopulationJTextField.setText(String.valueOf(updatedSpecies.getPopulation()));
    DietJTextField.setText(updatedSpecies.getDiet());
    HabitatJTextField.setText(updatedSpecies.getHabitat());
    PredatorsJTextField.setText(updatedSpecies.getPredators());
           // Get selected species details
//    String selectedSpeciesName = NameOfSpeciesJTextField.getText();
//    String selectedSpeciesGenus = GenusJTextField.getText();
//    int selectedSpeciesPopulation = Integer.parseInt(PopulationJTextField.getText());
//    String selectedSpeciesDiet = DietJTextField.getText();
//    String selectedSpeciesHabitat = HabitatJTextField.getText();
//    String selectedSpeciesPredator = PredatorsJTextField.getText();
//
//    // Create a Species object with the selected details
//    Species selectedSpecies = new Species(selectedSpeciesName, selectedSpeciesGenus, selectedSpeciesPopulation, selectedSpeciesDiet, selectedSpeciesHabitat, selectedSpeciesPredator);
//
//    // Open the EditSpecies form
//    EditSpecies myEditForm = new EditSpecies(this, true, selectedSpecies);
//    myEditForm.setVisible(true);
//
//    // After the dialog is closed, get the updated species
//    Species updatedSpecies = myEditForm.getSpecies();
//
//    // Update the display with the edited species details
//    NameOfSpeciesJTextField.setText(updatedSpecies.getName());
//    GenusJTextField.setText(updatedSpecies.getGenus());
//    PopulationJTextField.setText(String.valueOf(updatedSpecies.getPopulation()));
//    DietJTextField.setText(updatedSpecies.getDiet());
//    HabitatJTextField.setText(updatedSpecies.getHabitat());
//    PredatorsJTextField.setText(updatedSpecies.getPredators());
    }//GEN-LAST:event_editJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // TODO add your handling code here:
         String selectedSpeciesName = speciesListJList.getSelectedValue();
    if (selectedSpeciesName == null) {
        JOptionPane.showMessageDialog(this, "Please select a species to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Confirm the deletion
    int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + selectedSpeciesName + "?", "Delete Species", JOptionPane.YES_NO_OPTION);
    
    if (result == JOptionPane.YES_OPTION) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare the SQL DELETE statement
            String query = "DELETE FROM SpeciesTable WHERE name = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, selectedSpeciesName);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Species deleted successfully.", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Species not found or could not be deleted.", "Deletion Failed", JOptionPane.ERROR_MESSAGE);
            }

            // Update the JList to reflect the changes
            updateSpeciesListJList();

            // Clear the text fields
            NameOfSpeciesJTextField.setText("");
            GenusJTextField.setText("");
            PopulationJTextField.setText("");
            DietJTextField.setText("");
            HabitatJTextField.setText("");
            PredatorsJTextField.setText("");

        } catch (SQLException exp) {
            JOptionPane.showMessageDialog(this, "SQL error: " + exp.getMessage(), "SQL Error!", JOptionPane.ERROR_MESSAGE);
            exp.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException exp) {
                exp.printStackTrace();
            }
        }
    }
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void searchJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchJMenuItemActionPerformed

    private void searchJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJTextFieldActionPerformed
        // TODO add your handling code here:
         String searchText = searchJTextField.getText().trim();
    if (searchText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter search criteria!", "No Search Criteria", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // SQL query to search the database including all fields
    String query = "SELECT * FROM SpeciesTable WHERE name LIKE ? OR genus LIKE ? OR habitat LIKE ? OR predators LIKE ? OR diet LIKE ? OR CAST(population AS CHAR) LIKE ?";

    try {
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pstmt = con.prepareStatement(query);

        // Setting the parameters for the prepared statement
        String searchPattern = "%" + searchText + "%";
        pstmt.setString(1, searchPattern);
        pstmt.setString(2, searchPattern);
        pstmt.setString(3, searchPattern);
        pstmt.setString(4, searchPattern);
        pstmt.setString(5, searchPattern);
        pstmt.setString(6, searchPattern);

        ResultSet rs = pstmt.executeQuery();

        // Process the result set
        StringBuilder result = new StringBuilder("Search Results:\n");
        boolean hasResults = false;
        while (rs.next()) {
            hasResults = true;
            result.append("Name: ").append(rs.getString("name")).append(", ");
            result.append("Genus: ").append(rs.getString("genus")).append(", ");
            result.append("Population: ").append(rs.getInt("population")).append(", ");
            result.append("Diet: ").append(rs.getString("diet")).append(", ");
            result.append("Habitat: ").append(rs.getString("habitat")).append(", ");
            result.append("Predators: ").append(rs.getString("predators")).append("\n");
        }

        if (!hasResults) {
            JOptionPane.showMessageDialog(null, "No results found!", "No Results", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, result.toString(), "Search Results", JOptionPane.INFORMATION_MESSAGE);
        }

        rs.close();
        pstmt.close();
        con.close();

    } catch (SQLException exp) {
        JOptionPane.showMessageDialog(null, "SQL error: " + exp.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        exp.printStackTrace();
    }
    }//GEN-LAST:event_searchJTextFieldActionPerformed

   
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameOfSpeceiesJLabel;
    private javax.swing.JLabel populationJLabel;
    private javax.swing.JMenuItem searchJMenuItem;
    private javax.swing.JTextField searchJTextField;
    private javax.swing.JList<String> speciesListJList;
    private javax.swing.JScrollPane speciesListJjScrollPane;
    // End of variables declaration//GEN-END:variables
}

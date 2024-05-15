package project2species;
import static com.mysql.cj.conf.PropertyKey.PASSWORD;


import java.awt.Color;
import java.sql.Connection; // Correct import for Connection
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import static project2species.MySQLConnection.DB_URL;
import static project2species.MySQLConnection.USER;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class        AddSpecies.java
 * Description  A class used to   edit a species in the database.
 *              This class provides a GUI form to input species details.
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; PC Windows 10
 * Course       CS 143
 * Hourse       1 hours and 12 minutes
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020, 4/5/2021
 * @author      <i>Steven Halla</i>
 * @version     %1% %2%
 * @see         javax.swing.JDialog
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class AddSpecies extends javax.swing.JDialog
{
    // class instance variables
   private Species mySpecies = null;
    private String name;
    private String genus;
    private int population;
    private String habitat;
    private String predators;
    

    private String diet;
    private Project2SpeciesGUI mainGui;

    private final Color white = Color.WHITE; // Default background color for input textfield
    private final Color pink = Color.PINK;
     // Background color for bad input textfield
    
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor  AddSpecies()--default constructor
 * Description  Create an instance of the GUI form and sets icon image.
 *              Centers the form, sets the default button, and makes the 
 *              dialog modal.
 * Date         4/5/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public AddSpecies()
    {
        initComponents();
        // Center the form
        this.setLocationRelativeTo(null);        
        // Set the default button
//        this.getRootPane().setDefaultButton(addJButton);   
        // Center the form
//        addJButton.setText("Edit");
        // Set the modal to true
        setModal(true);        
    }
    
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor  AddSpecies(Species species)--overloaded constructor
 * Description  Create an instance of the GUI form, initializes the form with
 *              the provided Species object, and sets the text fields with 
 *              the species data.
 * Date         4/5/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       species The Species object containing data to populate the form
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public AddSpecies(Species species) {
    this(); // Call default constructor to build GUI
    mySpecies = species;
    addNameJTextField.setText(species.getName());
    addGenusJTextField.setText(species.getGenus());
    addPopulationJTextField.setText(String.valueOf(species.getPopulation()));
    addDietJTextField.setText(species.getDiet());
    addHabitatJTextField.setText(species.getHabitat());
    addPredatorsJTextField.setText(species.getPredators()); // Adding predators field

}

   /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor  AddSpecies(java.awt.Frame parent, boolean modal)
 * Description  Create an instance of the GUI form with specified parent and 
 *              modal settings. Sets the form to the center and sets the default
 *              button.
 * Date         4/5/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       parent The parent frame of this dialog
 * @param       modal  Specifies whether dialog blocks user input to other 
 *                     top-level windows when shown
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public AddSpecies(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();

        // Center the form
        this.setLocationRelativeTo(null);        
        // Set the default button
        this.getRootPane().setDefaultButton(addJButton);                        
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor  AddSpecies(Project2SpeciesGUI mainGui, boolean modal)
 * Description  Create an instance of the GUI form with specified main GUI and
 *              modal settings.
 * Date         4/5/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       mainGui The main GUI of the application
 * @param       modal   Specifies whether dialog blocks user input to other 
 *                      top-level windows when shown
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    
    public AddSpecies(Project2SpeciesGUI mainGui, boolean modal) {
    super((java.awt.Frame) null, modal);
    this.mainGui = mainGui;
    initComponents();
}

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       getSpecies()
 * Description  Returns the species that was added or edited.
 * Date         5/12/16
 * History Log  8/24/2016, 4/3/2020
 * @author      <i>Steven Halla</i>
 * @return      Species The species that was added 
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public Species getSpecies()
    {
        return mySpecies;
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayJPanel = new javax.swing.JPanel();
        firstJLabel = new javax.swing.JLabel();
        addNameJTextField = new javax.swing.JTextField();
        lastJLabel = new javax.swing.JLabel();
        addGenusJTextField = new javax.swing.JTextField();
        ageJLabel = new javax.swing.JLabel();
        addPopulationJTextField = new javax.swing.JTextField();
        addressJLabel = new javax.swing.JLabel();
        addDietJTextField = new javax.swing.JTextField();
        cityJLabel = new javax.swing.JLabel();
        addHabitatJTextField = new javax.swing.JTextField();
        controlJPanel = new javax.swing.JPanel();
        addJButton = new javax.swing.JButton();
        quitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addPredatorsJTextField = new javax.swing.JTextField();
        addTitleJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Add Form");
        setType(java.awt.Window.Type.UTILITY);

        displayJPanel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        displayJPanel.setLayout(new java.awt.GridLayout(7, 2, 3, 3));

        firstJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        firstJLabel.setText("Name of Species:");
        displayJPanel.add(firstJLabel);

        addNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addNameJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        addNameJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addNameJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addNameJTextFieldFocusLost(evt);
            }
        });
        displayJPanel.add(addNameJTextField);

        lastJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lastJLabel.setText("Genus:");
        displayJPanel.add(lastJLabel);

        addGenusJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addGenusJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        addGenusJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addGenusJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addGenusJTextFieldFocusLost(evt);
            }
        });
        displayJPanel.add(addGenusJTextField);

        ageJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ageJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ageJLabel.setText("Population:");
        displayJPanel.add(ageJLabel);

        addPopulationJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addPopulationJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        addPopulationJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addPopulationJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addPopulationJTextFieldFocusLost(evt);
            }
        });
        displayJPanel.add(addPopulationJTextField);

        addressJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addressJLabel.setText("Diet:");
        displayJPanel.add(addressJLabel);

        addDietJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addDietJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        displayJPanel.add(addDietJTextField);

        cityJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cityJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cityJLabel.setText("Habitat:");
        displayJPanel.add(cityJLabel);

        addHabitatJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addHabitatJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        addHabitatJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addHabitatJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addHabitatJTextFieldFocusLost(evt);
            }
        });
        addHabitatJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHabitatJTextFieldActionPerformed(evt);
            }
        });
        displayJPanel.add(addHabitatJTextField);

        controlJPanel.setLayout(new java.awt.GridLayout(1, 2, 3, 3));

        addJButton.setBackground(new java.awt.Color(255, 255, 204));
        addJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addJButton.setMnemonic('A');
        addJButton.setText("Add");
        addJButton.setToolTipText("Add a speices to the DB");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(addJButton);

        quitJButton.setBackground(new java.awt.Color(255, 255, 204));
        quitJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quitJButton.setMnemonic('Q');
        quitJButton.setText("Quit");
        quitJButton.setToolTipText("Close form and return to main GUI");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(quitJButton);

        jLabel1.setText("Predators:");

        addPredatorsJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        addPredatorsJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addPredatorsJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addPredatorsJTextFieldFocusLost(evt);
            }
        });
        addPredatorsJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPredatorsJTextFieldActionPerformed(evt);
            }
        });

        addTitleJLabel.setText("Add Species");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addPredatorsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(addTitleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(addTitleJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(addPredatorsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(102, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      quitJButtonActionPerformed()
 * Description: Dispose the Add form. Uses the Validation class to validate 
 *              input fields.
 * Date:        4/26/2021
 * History Log: 7/18/2018, 5/7/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.ActionEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitJButtonActionPerformed
    {//GEN-HEADEREND:event_quitJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_quitJButtonActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addJButtonActionPerformed()
 * Description: Add new species to the database. Retrieves data from input 
 *              fields, prepares and executes an SQL insert statement, and 
 *              updates the species list if successful.
 * Date:        4/26/2021
 * History Log: 7/18/2018, 5/7/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.ActionEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addJButtonActionPerformed
    {//GEN-HEADEREND:event_addJButtonActionPerformed

    String message = "Species not added.";
    Connection conn = null;
    PreparedStatement pstmt = null;

    // Assuming these variables are retrieved from form inputs or another source
    String name = addNameJTextField.getText().trim();
    String genus = addGenusJTextField.getText().trim();
    String populationText = addPopulationJTextField.getText().trim();
    String diet = addDietJTextField.getText().trim();
    String habitat = addHabitatJTextField.getText().trim();
    String predators = addPredatorsJTextField.getText().trim();

    // Validation flags
    boolean isValid = true;
    StringBuilder validationMessage = new StringBuilder("Please fix the following errors:\n");

    // Validate that population is a number
    int population = 0;
    try {
        population = Integer.parseInt(populationText);
    } catch (NumberFormatException e) {
        isValid = false;
        validationMessage.append("- Population must be a number.\n");
    }

    // Validate that name, genus, diet, habitat, and predators contain only letters
if (!name.matches("[a-zA-Z ]+")) {
    isValid = false;
    validationMessage.append("- Name must contain only letters and spaces.\n");
}
if (!genus.matches("[a-zA-Z ]+")) {
    isValid = false;
    validationMessage.append("- Genus must contain only letters and spaces.\n");
}
if (!diet.matches("[a-zA-Z ]+")) {
    isValid = false;
    validationMessage.append("- Diet must contain only letters and spaces.\n");
}
if (!habitat.matches("[a-zA-Z ]+")) {
    isValid = false;
    validationMessage.append("- Habitat must contain only letters and spaces.\n");
}
if (!predators.matches("[a-zA-Z ]+")) {
    isValid = false;
    validationMessage.append("- Predators must contain only letters and spaces.\n");
}


    // If validations fail, show the error messages and return
    if (!isValid) {
        JOptionPane.showMessageDialog(this, validationMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Debug print statements to verify values
        System.out.println("Name: " + name);
        System.out.println("Genus: " + genus);
        System.out.println("Population: " + population);
        System.out.println("Diet: " + diet);
        System.out.println("Habitat: " + habitat);
        System.out.println("Predators: " + predators);

        // Initialize database connection
        conn = DriverManager.getConnection(MySQLConnection.DB_URL, MySQLConnection.USER, MySQLConnection.PASS);

        // Prepare SQL statement
        String sql = "INSERT INTO SpeciesTable (name, genus, population, diet, habitat, predators) VALUES (?, ?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, genus);
        pstmt.setInt(3, population);
        pstmt.setString(4, diet);
        pstmt.setString(5, habitat);
        pstmt.setString(6, predators);

        // Execute update
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            message = "Species added successfully!";
            mainGui.updateSpeciesListJList();
        }

        // Close form if successful
        this.dispose();
    } catch (SQLException exp) {
        JOptionPane.showMessageDialog(null, message, "Database Error", JOptionPane.ERROR_MESSAGE);
        exp.printStackTrace();
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

        
        

     
     
    }//GEN-LAST:event_addJButtonActionPerformed

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addNameJTextFieldFocusGained()
 * Description: Highlights the addNameJTextField text field when it gains focus.
 * Date:        4/5/2021
 * History Log: 8/24/2016, 4/3/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.FocusEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void addNameJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_addNameJTextFieldFocusGained
    {//GEN-HEADEREND:event_addNameJTextFieldFocusGained
        addNameJTextField.selectAll();
    }//GEN-LAST:event_addNameJTextFieldFocusGained
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addNameJTextFieldFocusLost()
 * Description: Changes the background color of addNameJTextField based on 
 *              the validity of the input when the focus is lost.
 * Date:        4/5/2021
 * History Log: 8/24/2016, 4/3/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.FocusEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void addNameJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_addNameJTextFieldFocusLost
    {//GEN-HEADEREND:event_addNameJTextFieldFocusLost
        String input = addNameJTextField.getText();
        if(Validation.isValidName(input))
            addNameJTextField.setBackground(white);
        else
            addNameJTextField.setBackground(pink);
    }//GEN-LAST:event_addNameJTextFieldFocusLost
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addGenusJTextFieldFocusGained()
 * Description: Highlights the entire text in addGenusJTextField when it 
 *              gains focus.
 * Date:        4/5/2021
 * History Log: 8/24/2016, 4/3/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.FocusEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void addGenusJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_addGenusJTextFieldFocusGained
    {//GEN-HEADEREND:event_addGenusJTextFieldFocusGained
        addGenusJTextField.selectAll();
    }//GEN-LAST:event_addGenusJTextFieldFocusGained
  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addGenusJTextFieldFocusLost()
 * Description: Validates the input in addGenusJTextField when focus is lost.
 *              Changes the background color to indicate validity.
 * Date:        4/5/2021
 * History Log: 8/24/2016, 4/3/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.FocusEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void addGenusJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_addGenusJTextFieldFocusLost
    {//GEN-HEADEREND:event_addGenusJTextFieldFocusLost
        String input = addGenusJTextField.getText();
        if(Validation.isValidName(input))
            addGenusJTextField.setBackground(white);
        else
            addGenusJTextField.setBackground(pink);
    }//GEN-LAST:event_addGenusJTextFieldFocusLost
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addPopulationJTextFieldFocusGained()
 * Description: Highlights the text in addPopulationJTextField when it gains focus.
 * Date:        4/5/2021
 * History Log: 8/24/2016, 4/3/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.FocusEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void addPopulationJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_addPopulationJTextFieldFocusGained
    {//GEN-HEADEREND:event_addPopulationJTextFieldFocusGained
        addPopulationJTextField.selectAll();
    }//GEN-LAST:event_addPopulationJTextFieldFocusGained
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addPopulationJTextFieldFocusLost()
 * Description: Changes the background color of addPopulationJTextField based 
 *              on the validity of the input when focus is lost.
 * Date:        4/5/2021
 * History Log: 8/24/2016, 4/3/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.FocusEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void addPopulationJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_addPopulationJTextFieldFocusLost
    {//GEN-HEADEREND:event_addPopulationJTextFieldFocusLost
        String input = addPopulationJTextField.getText();
        if(Validation.isInteger(input, 5, 140))     //valid age: [5,140]
            addPopulationJTextField.setBackground(white);
        else
            addPopulationJTextField.setBackground(pink);
    }//GEN-LAST:event_addPopulationJTextFieldFocusLost
   /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addHabitatJTextFieldFocusGained()
 * Description: Highlights the text in addHabitatJTextField when the field 
 *              gains focus.
 * Date:        4/5/2021
 * History Log: 8/24/2016, 4/3/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.FocusEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void addHabitatJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_addHabitatJTextFieldFocusGained
    {//GEN-HEADEREND:event_addHabitatJTextFieldFocusGained
        addHabitatJTextField.selectAll();
    }//GEN-LAST:event_addHabitatJTextFieldFocusGained
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addHabitatJTextFieldFocusLost()
 * Description: Changes the background color of addHabitatJTextField based on 
 *              the validity of the input when the field loses focus.
 * Date:        4/5/2021
 * History Log: 8/24/2016, 4/3/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.FocusEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void addHabitatJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_addHabitatJTextFieldFocusLost
    {//GEN-HEADEREND:event_addHabitatJTextFieldFocusLost
        String input = addHabitatJTextField.getText();
        if(Validation.isValidName(input))
            addHabitatJTextField.setBackground(white);
        else
            addHabitatJTextField.setBackground(pink);
    }//GEN-LAST:event_addHabitatJTextFieldFocusLost

    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addPredatorsJTextFieldActionPerformed()
 * Description: Handles the action event for addPredatorsJTextField. This method
 *              is triggered when the user presses Enter while focused on the 
 *              addPredatorsJTextField.
 * Date:        4/5/2021
 * History Log: 8/24/2016, 4/3/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.ActionEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void addPredatorsJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPredatorsJTextFieldActionPerformed
        // TODO add your handling code here:
        String input = addPredatorsJTextField.getText();
    if (Validation.isValidName(input)) {
        addPredatorsJTextField.setBackground(white);
    } else {
        addPredatorsJTextField.setBackground(pink);
    }

    }//GEN-LAST:event_addPredatorsJTextFieldActionPerformed

    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addPredatorsJTextFieldFocusGained()
 * Description: Selects all text in addPredatorsJTextField when the field gains focus.
 * Date:        4/5/2021
 * History Log: 8/24/2016, 4/3/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.FocusEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void addPredatorsJTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addPredatorsJTextFieldFocusGained
        // TODO add your handling code here:
            addPredatorsJTextField.selectAll();

    }//GEN-LAST:event_addPredatorsJTextFieldFocusGained

    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method:      addPredatorsJTextFieldFocusLost()
 * Description: Changes the background color of addPredatorsJTextField based on 
 *              whether the input is valid when the field loses focus.
 * Date:        4/5/2021
 * History Log: 8/24/2016, 4/3/2020
 * @author      Steven Halla
 * @param       evt java.awt.event.FocusEvent
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void addPredatorsJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addPredatorsJTextFieldFocusLost
        // TODO add your handling code here:
            String input = addPredatorsJTextField.getText();
    if (Validation.isValidName(input))
        addPredatorsJTextField.setBackground(white);
    else
        addPredatorsJTextField.setBackground(pink);
    }//GEN-LAST:event_addPredatorsJTextFieldFocusLost

    private void addHabitatJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHabitatJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addHabitatJTextFieldActionPerformed

    
  
                                          




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addDietJTextField;
    private javax.swing.JTextField addGenusJTextField;
    private javax.swing.JTextField addHabitatJTextField;
    private javax.swing.JButton addJButton;
    private javax.swing.JTextField addNameJTextField;
    private javax.swing.JTextField addPopulationJTextField;
    private javax.swing.JTextField addPredatorsJTextField;
    private javax.swing.JLabel addTitleJLabel;
    private javax.swing.JLabel addressJLabel;
    private javax.swing.JLabel ageJLabel;
    private javax.swing.JLabel cityJLabel;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JLabel firstJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lastJLabel;
    private javax.swing.JButton quitJButton;
    // End of variables declaration//GEN-END:variables
}

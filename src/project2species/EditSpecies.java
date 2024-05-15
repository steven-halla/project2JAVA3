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
import java.sql.ResultSet;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class        EditSpecies.java
 * Description  A class used to edit the details of a species in the database.
 *              It provides a graphical user interface (GUI) for modifying 
 *              species information such as name, genus, population, diet, 
 *              habitat, and predators. 
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; PC Windows 10
 * Course       CS 143
 * Hourse       1 hours and 12 minutes
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020, 4/5/2021
 * @author      <i>Steven Halla</i>
 * @version     %1% %2%
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


public class EditSpecies extends javax.swing.JDialog
{
    // class instance variables
   private Species mySpecies = null;
   private String originalName;

       private Project2SpeciesGUI mainGui;

    private String name;
    private String genus;
    private int population;
    private String habitat;
    private String predators;

    private String diet;
    private final Color white = Color.WHITE;
    private final Color pink = Color.PINK;
     // Background color for bad input textfield
    
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor  EditSpecies()
 * Description  Creates an instance of the EditSpecies GUI form, initializes 
 *              its components, centers the form on the screen, and sets the 
 *              modal to true.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public EditSpecies()
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
 * Constructor  EditSpecies(Project2SpeciesGUI mainGui, boolean modal, Species species)
 * Description  Creates an instance of the EditSpecies GUI form with the 
 *              specified parent GUI, modal setting, and species. Initializes 
 *              the form components and populates the form fields with the 
 *              species data.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       mainGui Project2SpeciesGUI - the parent GUI
 * @param       modal boolean - specifies whether the dialog is modal
 * @param       species Species - the species data to be edited
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  public EditSpecies(Project2SpeciesGUI mainGui, boolean modal, Species species) {
    super(mainGui, modal);
    this.mainGui = mainGui;
    this.mySpecies = species;
    initComponents();
    initializeEditForm(species);
}
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor  EditSpecies(Project2SpeciesGUI mainGui, boolean modal, Species species)
 * Description  Creates an instance of the EditSpecies GUI form with the 
 *              specified parent GUI, modal setting, and species. Initializes 
 *              the form components and populates the form fields with the 
 *              species data.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>

 * @param       species Species - the species data to be edited
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    
    public void initializeEditForm(Species species) {
                System.out.println("Initializing Edit Form with Original Name: " + originalName); // Print statement for debugging

    originalName = species.getName();
    editNameJTextField.setText(species.getName());
    editGenusJTextField.setText(species.getGenus());
    editPopulationJTextField.setText(String.valueOf(species.getPopulation()));
    editDietJTextField.setText(species.getDiet());
    editHabitatJTextField.setText(species.getHabitat());
    editPredatorsJTextField.setText(species.getPredators());
}
    
  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor  EditSpecies(Species species)
 * Description  Creates an instance of the EditSpecies GUI form and populates 
 *              the form fields with the provided species data.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       species Species - the species data to be edited
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public EditSpecies(Species species) {
    this(); // Call default constructor to build GUI
    mySpecies = species;
    editNameJTextField.setText(species.getName());
    editGenusJTextField.setText(species.getGenus());
    editPopulationJTextField.setText(String.valueOf(species.getPopulation()));
    editDietJTextField.setText(species.getDiet());
    editHabitatJTextField.setText(species.getHabitat());
    editPredatorsJTextField.setText(species.getPredators()); // Adding predators field

}

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor  EditSpecies(java.awt.Frame parent, boolean modal, Species species)
 * Description  Creates an instance of the EditSpecies GUI form with the specified
 *              parent frame, modality, and species data. Centers the form and 
 *              initializes the form fields with the provided species data.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       parent  java.awt.Frame - the parent frame
 * @param       modal   boolean - specifies whether dialog blocks user input to other top-level windows
 * @param       species Species - the species data to be edited
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public EditSpecies(java.awt.Frame parent, boolean modal, Species species) {
    super(parent, modal);
    initComponents();
    this.setLocationRelativeTo(null);        
    this.mySpecies = species;
    setFormData(species);
            initializeEditForm(species); // Call this method to initialize the form

}

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       setFormData(Species species)
 * Description  Populates the form fields with the data from the provided Species 
 *              object. Sets the name, genus, population, diet, habitat, and 
 *              predators text fields with the corresponding values from the species.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       species Species - the species data to populate the form fields
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

private void setFormData(Species species) {
    editNameJTextField.setText(species.getName());
    editGenusJTextField.setText(species.getGenus());
    editPopulationJTextField.setText(String.valueOf(species.getPopulation()));
    editDietJTextField.setText(species.getDiet());
    editHabitatJTextField.setText(species.getHabitat());
    editPredatorsJTextField.setText(species.getPredators());
}


 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor  EditSpecies(java.awt.Frame parent, boolean modal)
 * Description  Overloaded constructor that creates an instance of the EditSpecies 
 *              GUI form. Sets the icon image, centers the form on the screen, 
 *              and sets the default button for the form.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       parent java.awt.Frame - the parent frame of the dialog
 * @param       modal boolean - specifies whether dialog blocks user input to 
 *              other top-level windows when shown
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public EditSpecies(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();

        // Center the form
        this.setLocationRelativeTo(null);        
        // Set the default button
        this.getRootPane().setDefaultButton(editJButton);                        
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       getSpecies()
 * Description  Retrieves the current species being edited.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @return      Species - the current species being edited
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
        editNameJTextField = new javax.swing.JTextField();
        lastJLabel = new javax.swing.JLabel();
        editGenusJTextField = new javax.swing.JTextField();
        ageJLabel = new javax.swing.JLabel();
        editPopulationJTextField = new javax.swing.JTextField();
        addressJLabel = new javax.swing.JLabel();
        editDietJTextField = new javax.swing.JTextField();
        cityJLabel = new javax.swing.JLabel();
        editHabitatJTextField = new javax.swing.JTextField();
        controlJPanel = new javax.swing.JPanel();
        editJButton = new javax.swing.JButton();
        quitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        editPredatorsJTextField = new javax.swing.JTextField();
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

        editNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editNameJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editNameJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                editNameJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                editNameJTextFieldFocusLost(evt);
            }
        });
        displayJPanel.add(editNameJTextField);

        lastJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lastJLabel.setText("Genus:");
        displayJPanel.add(lastJLabel);

        editGenusJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editGenusJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editGenusJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                editGenusJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                editGenusJTextFieldFocusLost(evt);
            }
        });
        displayJPanel.add(editGenusJTextField);

        ageJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ageJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ageJLabel.setText("Population:");
        displayJPanel.add(ageJLabel);

        editPopulationJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editPopulationJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editPopulationJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                editPopulationJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                editPopulationJTextFieldFocusLost(evt);
            }
        });
        displayJPanel.add(editPopulationJTextField);

        addressJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addressJLabel.setText("Diet:");
        displayJPanel.add(addressJLabel);

        editDietJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editDietJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        displayJPanel.add(editDietJTextField);

        cityJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cityJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cityJLabel.setText("Habitat:");
        displayJPanel.add(cityJLabel);

        editHabitatJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editHabitatJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editHabitatJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                editHabitatJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                editHabitatJTextFieldFocusLost(evt);
            }
        });
        displayJPanel.add(editHabitatJTextField);

        controlJPanel.setLayout(new java.awt.GridLayout(1, 2, 3, 3));

        editJButton.setBackground(new java.awt.Color(255, 255, 204));
        editJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editJButton.setMnemonic('A');
        editJButton.setText("Edit");
        editJButton.setToolTipText("Edit the speices");
        editJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(editJButton);

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

        editPredatorsJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        editPredatorsJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                editPredatorsJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                editPredatorsJTextFieldFocusLost(evt);
            }
        });
        editPredatorsJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPredatorsJTextFieldActionPerformed(evt);
            }
        });

        addTitleJLabel.setText("Edit Species");

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
                                .addComponent(editPredatorsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(editPredatorsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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
 * Method       quitJButtonActionPerformed()
 * Description  Closes the EditSpecies dialog.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.ActionEvent - event triggered when the quit 
 *              button is pressed
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitJButtonActionPerformed
    {//GEN-HEADEREND:event_quitJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_quitJButtonActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editJButtonActionPerformed()
 * Description  Updates the species in the database with the new values from 
 *              the text fields when the edit button is pressed. Validates 
 *              input fields before performing the update. Displays appropriate
 *              messages for successful or failed updates.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.ActionEvent - event triggered when the edit
 *              button is pressed
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editJButtonActionPerformed
    {//GEN-HEADEREND:event_editJButtonActionPerformed

      if (editNameJTextField.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String newName = editNameJTextField.getText().trim();
    String genus = editGenusJTextField.getText().trim();
    String populationText = editPopulationJTextField.getText().trim();
    String diet = editDietJTextField.getText().trim();
    String habitat = editHabitatJTextField.getText().trim();
    String predators = editPredatorsJTextField.getText().trim();

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
    if (!newName.matches("[a-zA-Z]+")) {
        isValid = false;
        validationMessage.append("- Name must contain only letters.\n");
    }
    if (!genus.matches("[a-zA-Z]+")) {
        isValid = false;
        validationMessage.append("- Genus must contain only letters.\n");
    }
    if (!diet.matches("[a-zA-Z]+")) {
        isValid = false;
        validationMessage.append("- Diet must contain only letters.\n");
    }
    if (!habitat.matches("[a-zA-Z]+")) {
        isValid = false;
        validationMessage.append("- Habitat must contain only letters.\n");
    }
    if (!predators.matches("[a-zA-Z]+")) {
        isValid = false;
        validationMessage.append("- Predators must contain only letters.\n");
    }

    // If validations fail, show the error messages and return
    if (!isValid) {
        JOptionPane.showMessageDialog(this, validationMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = DriverManager.getConnection(MySQLConnection.DB_URL, MySQLConnection.USER, MySQLConnection.PASS);
        String sql = "UPDATE SpeciesTable SET name = ?, genus = ?, population = ?, diet = ?, habitat = ?, predators = ? WHERE name = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newName);
        pstmt.setString(2, genus);
        pstmt.setInt(3, population);
        pstmt.setString(4, diet);
        pstmt.setString(5, habitat);
        pstmt.setString(6, predators);
        pstmt.setString(7, originalName);

        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(this, "Species updated successfully!", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
            if (mainGui != null) {
                mainGui.updateSpeciesListJList();
            } else {
                System.err.println("Error: mainGui is null. Unable to refresh the species list.");
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No changes were made. Please check your input values.", "Update Failed", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException exp) {
        JOptionPane.showMessageDialog(this, "Database error: " + exp.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        exp.printStackTrace();
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }
     
    }//GEN-LAST:event_editJButtonActionPerformed

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editNameJTextFieldFocusGained()
 * Description  Selects all text in the editNameJTextField when it gains focus.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.FocusEvent - event triggered when the 
 *              editNameJTextField gains focus
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void editNameJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editNameJTextFieldFocusGained
    {//GEN-HEADEREND:event_editNameJTextFieldFocusGained
        editNameJTextField.selectAll();
    }//GEN-LAST:event_editNameJTextFieldFocusGained
 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editNameJTextFieldFocusLost()
 * Description  Validates the input in editNameJTextField when it loses focus. 
 *              Changes the background color based on validation result.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.FocusEvent - event triggered when the 
 *              editNameJTextField loses focus
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void editNameJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editNameJTextFieldFocusLost
    {//GEN-HEADEREND:event_editNameJTextFieldFocusLost
        String input = editNameJTextField.getText();
        if(Validation.isValidName(input))
            editNameJTextField.setBackground(white);
        else
            editNameJTextField.setBackground(pink);
    }//GEN-LAST:event_editNameJTextFieldFocusLost
  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editGenusJTextFieldFocusGained()
 * Description  Selects all text in editGenusJTextField when it gains focus.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.FocusEvent - event triggered when the 
 *              editGenusJTextField gains focus
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void editGenusJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editGenusJTextFieldFocusGained
    {//GEN-HEADEREND:event_editGenusJTextFieldFocusGained
        editGenusJTextField.selectAll();
    }//GEN-LAST:event_editGenusJTextFieldFocusGained
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editGenusJTextFieldFocusLost()
 * Description  Validates the input in editGenusJTextField when focus is lost.
 *              Changes the background color based on the validity of the input.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.FocusEvent - event triggered when the 
 *              editGenusJTextField loses focus
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void editGenusJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editGenusJTextFieldFocusLost
    {//GEN-HEADEREND:event_editGenusJTextFieldFocusLost
        String input = editGenusJTextField.getText();
        if(Validation.isValidName(input))
            editGenusJTextField.setBackground(white);
        else
            editGenusJTextField.setBackground(pink);
    }//GEN-LAST:event_editGenusJTextFieldFocusLost
  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editPopulationJTextFieldFocusGained()
 * Description  Selects all text in editPopulationJTextField when it gains focus.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.FocusEvent - event triggered when the 
 *              editPopulationJTextField gains focus
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void editPopulationJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editPopulationJTextFieldFocusGained
    {//GEN-HEADEREND:event_editPopulationJTextFieldFocusGained
        editPopulationJTextField.selectAll();
    }//GEN-LAST:event_editPopulationJTextFieldFocusGained
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editPopulationJTextFieldFocusLost()
 * Description  Validates the input in editPopulationJTextField when it loses 
 *              focus. Changes the background color based on the validity of 
 *              the input.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.FocusEvent - event triggered when the 
 *              editPopulationJTextField loses focus
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void editPopulationJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editPopulationJTextFieldFocusLost
    {//GEN-HEADEREND:event_editPopulationJTextFieldFocusLost
        String input = editPopulationJTextField.getText();
        if(Validation.isInteger(input, 5, 140))     //valid age: [5,140]
            editPopulationJTextField.setBackground(white);
        else
            editPopulationJTextField.setBackground(pink);
    }//GEN-LAST:event_editPopulationJTextFieldFocusLost
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editHabitatJTextFieldFocusGained()
 * Description  Selects all text in editHabitatJTextField when it gains focus,
 *              allowing for easy editing of the habitat input.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.FocusEvent - event triggered when the 
 *              editHabitatJTextField gains focus
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void editHabitatJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editHabitatJTextFieldFocusGained
    {//GEN-HEADEREND:event_editHabitatJTextFieldFocusGained
        editHabitatJTextField.selectAll();
    }//GEN-LAST:event_editHabitatJTextFieldFocusGained
  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editHabitatJTextFieldFocusLost()
 * Description  Changes the background color of editHabitatJTextField based on 
 *              the validity of the input. If the input is valid, sets the 
 *              background color to white; otherwise, sets it to pink.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.FocusEvent - event triggered when the 
 *              editHabitatJTextField loses focus
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void editHabitatJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editHabitatJTextFieldFocusLost
    {//GEN-HEADEREND:event_editHabitatJTextFieldFocusLost
        String input = editHabitatJTextField.getText();
        if(Validation.isValidName(input))
            editHabitatJTextField.setBackground(white);
        else
            editHabitatJTextField.setBackground(pink);
    }//GEN-LAST:event_editHabitatJTextFieldFocusLost
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editPredatorsJTextFieldActionPerformed()
 * Description  This should be deleted, no idea how to do that one
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.FocusEvent - event triggered when the 
 *              editPredatorsJTextField gains focus
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void editPredatorsJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPredatorsJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editPredatorsJTextFieldActionPerformed
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editPredatorsJTextFieldFocusGained()
 * Description  Selects all the text in the editPredatorsJTextField when the 
 *              text field gains focus, allowing for easy editing or replacement 
 *              of the text.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.FocusEvent - event triggered when the 
 *              editPredatorsJTextField gains focus
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    private void editPredatorsJTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editPredatorsJTextFieldFocusGained
        // TODO add your handling code here:
            editPredatorsJTextField.selectAll();

    }//GEN-LAST:event_editPredatorsJTextFieldFocusGained
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       editPredatorsJTextFieldFocusLost()
 * Description  Changes the background color of the editPredatorsJTextField 
 *              based on the validity of the input. Sets the background to white 
 *              if the input is valid, otherwise sets it to pink.
 * Date         5/1/2021
 * History Log  7/18/2018, 5/7/2020
 * @author      <i>Steven Halla</i>
 * @param       evt java.awt.event.FocusEvent - event triggered when the 
 *              editPredatorsJTextField loses focus
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    private void editPredatorsJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editPredatorsJTextFieldFocusLost
        // TODO add your handling code here:
            String input = editPredatorsJTextField.getText();
    if (Validation.isValidName(input))
        editPredatorsJTextField.setBackground(white);
    else
        editPredatorsJTextField.setBackground(pink);
    }//GEN-LAST:event_editPredatorsJTextFieldFocusLost

    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addTitleJLabel;
    private javax.swing.JLabel addressJLabel;
    private javax.swing.JLabel ageJLabel;
    private javax.swing.JLabel cityJLabel;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JTextField editDietJTextField;
    private javax.swing.JTextField editGenusJTextField;
    private javax.swing.JTextField editHabitatJTextField;
    private javax.swing.JButton editJButton;
    private javax.swing.JTextField editNameJTextField;
    private javax.swing.JTextField editPopulationJTextField;
    private javax.swing.JTextField editPredatorsJTextField;
    private javax.swing.JLabel firstJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lastJLabel;
    private javax.swing.JButton quitJButton;
    // End of variables declaration//GEN-END:variables
}

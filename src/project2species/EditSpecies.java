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
 * Class        AddPerson.java
 * Description  A class used to both add and edit a person into the DB.
 * Course       CS 143
 * Hourse       1 hours and 12 minutes
 * Date         5/1/2021
  History Log   7/18/2018, 5/7/2020, 4/5/2021
 * @author	<i>Niko Culevski</i>
 * @version 	%1% %2%
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
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  AddPerson()--default constructor
     * Description  Create an instance of the GUI form and sets icon image.
     *              Used for Add Person.
     * Date         4/5/2021
     * History Log  7/18/2018, 5/7/2020
     * @author      <i>Niko Culevski</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
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
    
  public EditSpecies(Project2SpeciesGUI mainGui, boolean modal, Species species) {
    super(mainGui, modal);
    this.mainGui = mainGui;
    this.mySpecies = species;
    initComponents();
    initializeEditForm(species);
}
    
    
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
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  AddPerson()--overloaded constructor
     * Description  Create an instance of the GUI form and sets icon image.
     *              Used for Edit Person.
     * Date         4/5/2021
     * History Log  7/18/2018, 5/7/2020
     * @author      <i>Niko Culevski</i>
     * @param       friend Person
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
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


public EditSpecies(java.awt.Frame parent, boolean modal, Species species) {
    super(parent, modal);
    initComponents();
    this.setLocationRelativeTo(null);        
    this.mySpecies = species;
    setFormData(species);
            initializeEditForm(species); // Call this method to initialize the form

}

private void setFormData(Species species) {
    editNameJTextField.setText(species.getName());
    editGenusJTextField.setText(species.getGenus());
    editPopulationJTextField.setText(String.valueOf(species.getPopulation()));
    editDietJTextField.setText(species.getDiet());
    editHabitatJTextField.setText(species.getHabitat());
    editPredatorsJTextField.setText(species.getPredators());
}


    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  AddPerson()--overloaded constructor
     * Description  Create an instance of the GUI form and sets icon image.
     *              Used for Edit Person.
     * Date         4/5/2021
     * History Log  7/18/2018, 5/7/2020
     * @author      <i>Niko Culevski</i>
     * @param       parent Frame
     * @param       modal  boolean
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public EditSpecies(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();

        // Center the form
        this.setLocationRelativeTo(null);        
        // Set the default button
        this.getRootPane().setDefaultButton(editJButton);                        
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method:      getPerson()
     * Description: Returns the person added or edited.
     * Date:        5/12/16
     * @author      Niko Culevski
     * @return      Person
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
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
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(quitJButton);

        jLabel1.setText("Predators:");

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
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       quitJButtonActionPerformed()
     * Description  Dispose the Add form. Uses the Validation class to
     *              validate input fields.
     * Date         4/26/2021
     * @param       evt java.awt.event.ActionEvent
     * @author      <i>Niko Culevski</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitJButtonActionPerformed
    {//GEN-HEADEREND:event_quitJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_quitJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       addJButtonActionPerformed()
     * Description  Add new person.
     * Date         4/26/2021
     * @param       evt java.awt.event.ActionEvent
     * @author      <i>Niko Culevski</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editJButtonActionPerformed
    {//GEN-HEADEREND:event_editJButtonActionPerformed

          if (editNameJTextField.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String newName = editNameJTextField.getText().trim();
    String genus = editGenusJTextField.getText().trim();
    int population;
    try {
        population = Integer.parseInt(editPopulationJTextField.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid population number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    String diet = editDietJTextField.getText().trim();
    String habitat = editHabitatJTextField.getText().trim();
    String predators = editPredatorsJTextField.getText().trim();

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

   /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       firstJTextFieldFocusGained()
     * Description  Highlight firstJTextFieldFocusGained as focus is gained.
     * @parem       java.awt.event.FocusEvent
     * @author      <i>Niko Culevski</i>
     * Date         4/5/2021
     * History log  8/24/2016, 4/3/2020
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void editNameJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editNameJTextFieldFocusGained
    {//GEN-HEADEREND:event_editNameJTextFieldFocusGained
        editNameJTextField.selectAll();
    }//GEN-LAST:event_editNameJTextFieldFocusGained
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       firstJTextFieldFocusLost()
     * Description  Change color of firstJTextField according to valid input.
     * @parem       java.awt.event.FocusEvent
     * @author      <i>Niko Culevski</i>
     * Date         4/5/2021
     * History log  8/24/2016, 4/3/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void editNameJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editNameJTextFieldFocusLost
    {//GEN-HEADEREND:event_editNameJTextFieldFocusLost
        String input = editNameJTextField.getText();
        if(Validation.isValidName(input))
            editNameJTextField.setBackground(white);
        else
            editNameJTextField.setBackground(pink);
    }//GEN-LAST:event_editNameJTextFieldFocusLost
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       lastJTextFieldFocusGained()
     * Description  Highlight lastJTextField as focus is gained.
     * @parem       java.awt.event.FocusEvent
     * @author      <i>Niko Culevski</i>
     * Date         4/5/2021
     * History log  8/24/2016, 4/3/2020
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void editGenusJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editGenusJTextFieldFocusGained
    {//GEN-HEADEREND:event_editGenusJTextFieldFocusGained
        editGenusJTextField.selectAll();
    }//GEN-LAST:event_editGenusJTextFieldFocusGained
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       lastJTextFieldFocusLost()
     * Description  Change color of lastJTextField according to valid input.
     * @parem       java.awt.event.FocusEvent
     * @author      <i>Niko Culevski</i>
     * Date         4/5/2021
     * History log  8/24/2016, 4/3/2020
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void editGenusJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editGenusJTextFieldFocusLost
    {//GEN-HEADEREND:event_editGenusJTextFieldFocusLost
        String input = editGenusJTextField.getText();
        if(Validation.isValidName(input))
            editGenusJTextField.setBackground(white);
        else
            editGenusJTextField.setBackground(pink);
    }//GEN-LAST:event_editGenusJTextFieldFocusLost
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       ageJTextFieldFocusGained()
     * Description  Highlight ageJTextField as focus is gained.
     * @parem       java.awt.event.FocusEvent
     * @author      <i>Niko Culevski</i>
     * Date         4/5/2021
     * History log  8/24/2016, 4/3/2020
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void editPopulationJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editPopulationJTextFieldFocusGained
    {//GEN-HEADEREND:event_editPopulationJTextFieldFocusGained
        editPopulationJTextField.selectAll();
    }//GEN-LAST:event_editPopulationJTextFieldFocusGained
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       ageJTextFieldFocusLost()
     * Description  Change color of lastJTextField according to valid input.
     * @parem       java.awt.event.FocusEvent
     * @author      <i>Niko Culevski</i>
     * Date         4/5/2021
     * History log  8/24/2016, 4/3/2020
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void editPopulationJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editPopulationJTextFieldFocusLost
    {//GEN-HEADEREND:event_editPopulationJTextFieldFocusLost
        String input = editPopulationJTextField.getText();
        if(Validation.isInteger(input, 5, 140))     //valid age: [5,140]
            editPopulationJTextField.setBackground(white);
        else
            editPopulationJTextField.setBackground(pink);
    }//GEN-LAST:event_editPopulationJTextFieldFocusLost
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       cityJTextFieldFocusGained()
     * Description  Highlight cityJTextField as focus is gained.
     * @parem       java.awt.event.FocusEvent
     * @author      <i>Niko Culevski</i>
     * Date         4/5/2021
     * History log  8/24/2016, 4/3/2020
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void editHabitatJTextFieldFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editHabitatJTextFieldFocusGained
    {//GEN-HEADEREND:event_editHabitatJTextFieldFocusGained
        editHabitatJTextField.selectAll();
    }//GEN-LAST:event_editHabitatJTextFieldFocusGained
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       cityJTextFieldFocusLost()
     * Description  Change color of cityJTextField according to valid input.
     * @parem       java.awt.event.FocusEvent
     * @author      <i>Niko Culevski</i>
     * Date         4/5/2021
     * History log  8/24/2016, 4/3/2020
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void editHabitatJTextFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_editHabitatJTextFieldFocusLost
    {//GEN-HEADEREND:event_editHabitatJTextFieldFocusLost
        String input = editHabitatJTextField.getText();
        if(Validation.isValidName(input))
            editHabitatJTextField.setBackground(white);
        else
            editHabitatJTextField.setBackground(pink);
    }//GEN-LAST:event_editHabitatJTextFieldFocusLost

    private void editPredatorsJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPredatorsJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editPredatorsJTextFieldActionPerformed

    private void editPredatorsJTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editPredatorsJTextFieldFocusGained
        // TODO add your handling code here:
            editPredatorsJTextField.selectAll();

    }//GEN-LAST:event_editPredatorsJTextFieldFocusGained

    private void editPredatorsJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editPredatorsJTextFieldFocusLost
        // TODO add your handling code here:
            String input = editPredatorsJTextField.getText();
    if (Validation.isValidName(input))
        editPredatorsJTextField.setBackground(white);
    else
        editPredatorsJTextField.setBackground(pink);
    }//GEN-LAST:event_editPredatorsJTextFieldFocusLost

    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       predatorsJTextFieldFocusGained()
 * Description  Highlight predatorsJTextField as focus is gained.
 * @param       java.awt.event.FocusEvent
 * @author      <i>Niko Culevski</i>
 * Date         4/5/2021
 * History log  8/24/2016, 4/3/2020
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
                                          

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       predatorsJTextFieldFocusLost()
 * Description  Change color of predatorsJTextField according to valid input.
 * @param       java.awt.event.FocusEvent
 * @author      <i>Niko Culevski</i>
 * Date         4/5/2021
 * History log  8/24/2016, 4/3/2020
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


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

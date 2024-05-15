
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
import javax.swing.JOptionPane;



/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class        CreateAddressBookDB.java
 * Description  A class used to create the Address book DB
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; PC Windows 10
 * Course       CS 143
 * Hourse       4 hours and 17 minutes
 * Date         4/5/2021
  History Log   7/18/2018, 5/7/2020
 * @author	<i>Steven Halla</i>
 * @version 	%1% %2%
 * @see     	javax.swing.JFrame
 * @see         java.awt.Toolkit 
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class CreateAddressBookDB implements MySQLConnection {
    
    private static final String SPECIES_TEXT_FILE = "src/project2species/SpeciesList.txt";
    private static final ArrayList<Species> animals = new ArrayList<Species>();
    private Species mySpecies = new Species();

    
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method       main().
 * Description  Reads data from external text file, creates the address table
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; PC Windows 10
 * Course       CS 143
 * Hourse       4 hours and 17 minutes
 * Date         4/5/2021
  History Log   7/18/2018, 5/7/2020
 * @author	<i>Steven Halla</i>
 * @param        args are the command line strings
 
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String[] args) {
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
    if(table.next())
    {
        stmt.executeUpdate("DROP TABLE SpeciesTable");
    }

    stmt.executeUpdate("CREATE TABLE SpeciesTable (speciesID"
            + " SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, name"
            + " VARCHAR(20), genus VARCHAR(20), population INTEGER,"
            + " diet VARCHAR(30), habitat"
            + " VARCHAR(50), predators VARCHAR(50),"
            + " PRIMARY KEY (speciesID))");
    
    for(int i = 0; i < animals.size(); i++)
    {
        stmt.executeUpdate
                (
                "INSERT INTO SpeciesTable (name, genus, population, diet, habitat, predators) VALUES("
                + "'" + animals.get(i).getName() + "',"
                + "'" + animals.get(i).getGenus() + "',"
                + animals.get(i).getPopulation() + ","
                + "'" + animals.get(i).getDiet() + "'"  + ","
                + "'" + animals.get(i).getHabitat() + "'"  + ","
                + "'" + animals.get(i).getPredators() + "')"
                );                                                                   
    }
    stmt.close();
}
catch(SQLException exp)
{
    JOptionPane.showMessageDialog(null, "SQL error: " + exp.getMessage(),
            "SQL Error!", JOptionPane.ERROR_MESSAGE);
}

    
}
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       readFromTextFile()
     * Description   Reads a text file containing species data, parses each line 
     *              to create Species objects, and adds them to an ArrayList.
     *              The text file should contain comma-separated values for each 
     *              species, with the following fields in order: name, genus, 
     *              population, diet, habitat, and predators.
     * Date:        4/23/2019
     * @author      <i>Steven Halla</i>
     * @param       textFile String
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private static void readFromTextFile(String textFile)
    {        
       try
{            
    FileReader freader = new FileReader(textFile);
    BufferedReader input = new BufferedReader(freader);
    String line = input.readLine();
    
    while(line != null)
    {
        Species tempSpecies = new Species();
        StringTokenizer token = new StringTokenizer(line, ",");
        while(token.hasMoreElements())
        {
            tempSpecies.setName(token.nextToken());
            tempSpecies.setGenus(token.nextToken());
            tempSpecies.setPopulation(Integer.parseInt(token.nextToken()));
            tempSpecies.setDiet(token.nextToken());
            tempSpecies.setHabitat(token.nextToken());
            tempSpecies.setPredators(token.nextToken());
        }
        animals.add(tempSpecies);
        line = input.readLine();
    }
    input.close();
}
catch(FileNotFoundException fnfexp)
{
    fnfexp.printStackTrace();
    JOptionPane.showMessageDialog(null, "Input error -- "
            + "File not found.",
            "File Not Found Error!", JOptionPane.ERROR_MESSAGE);
}
catch(IOException | NumberFormatException exp)
{
 
    JOptionPane.showMessageDialog(null, "Input error -- "
            + "File could not be read or data format is incorrect.",
            "File Read Error!", JOptionPane.ERROR_MESSAGE);
}

    }       
}

package project2species;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class: Species
 * Description: Represents a species, capturing essential biological information such as name, genus, population,
 * diet, habitat, and known predators. This class implements the `Comparable<Species>` interface to enable sorting
 * and comparison based on specified criteria, typically used for organizing species by name, genus, or any other
 * characteristic deemed relevant. This class is designed to provide structured access to species data within
 * ecological or biological studies and applications.
 *
 * Attributes:
 *  name - The common name of the species.
 *  genus - The genus to which the species belongs.
 *  population - An estimate of the global population of the species.
 *  diet - The typical diet of the species.
 *  habitat - The primary natural habitat of the species.
 *  predators - Predators known to commonly prey on the species.
 *
 * Project      QuizSpecies Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; mac sonoma 14
 * Course       CS 141
 * Hours        8 hours and 45 minutes
 * Date         5/17/2024
 * History Log  4/4/2016, 11/21/2017
 * Author       <i>Steven Halla</i>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Species implements Comparable<Species> {
    private String name;
    private String genus; 
    private int population;
    private String diet;
    private String habitat;
    private String predators;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor: Species
 * Description: Initializes a new instance of the Species class with default values for all fields. This constructor sets
 * the name, genus, population, diet, habitat, and predators to their initial states, typically empty strings or zero.
 * It is useful when creating a Species object before all specific details are known or when initializing collections of
 * Species objects.
 *
 * Project      QuizSpecies Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; mac sonoma 14
 * Course       CS 141
 * Hours        8 hours and 45 minutes
 * Date         5/17/2024
 * History Log  4/4/2016, 11/21/2017
 * Author       <i>Steven Halla</i>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Species() {
        this.name = "";
        this.genus = "";
        this.population = 0;
        this.diet = "";
        this.habitat = "";
        this.predators = "";
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor: Species
 * Description: Initializes a new instance of the Species class with specified values for its properties. This constructor
 * sets the species' name, genus, population count, diet, natural habitat, and known predators. It provides a means to create
 * a fully defined Species object at the time of instantiation, facilitating the immediate use of the object with complete data.
 *
 * Parameters:
 *  name - The common name of the species.
 *  genus - The biological genus to which the species belongs.
 *  population - An estimate of the total global population of the species.
 *  diet - The typical diet of the species, describing what the species primarily consumes.
 *  habitat - The primary natural environment in which the species lives.
 *  predators - Descriptions of known natural predators that typically prey on the species.
 *
 * Project      QuizSpecies Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; mac sonoma 14
 * Course       CS 141
 * Hours        8 hours and 45 minutes
 * Date         5/17/2024
 * History Log  4/4/2016, 11/21/2017
 * Author       <i>Steven Halla</i>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Species(String name, String genus, int population, String diet, String habitat, String predators) {
        this.name = name;
        this.genus = genus;
        this.population = population;
        this.diet = diet;
        this.habitat = habitat;
        this.predators = predators;
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Constructor: Species
 * Description: Initializes a new instance of the Species class using another Species object as a source. This copy constructor
 * copies all properties from the provided `other` Species object, ensuring the new instance replicates the same attributes as
 * the source. This is particularly useful for creating a new, separate Species object when modifications are needed without
 * altering the original object.
 *
 * Parameters:
 *  other - The Species object from which to copy properties.
 *
 * Project      QuizSpecies Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; mac sonoma 14
 * Course       CS 141
 * Hours        8 hours and 45 minutes
 * Date         5/17/2024
 * History Log  4/4/2016, 11/21/2017
 * Author       <i>Steven Halla</i>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Species(Species other) {
        this.name = other.name;
        this.genus = other.genus;
        this.population = other.population;
        this.diet = other.diet;
        this.habitat = other.habitat;
        this.predators = other.predators;
    }
    
    
    
    public Species(String name, String genus) {
    this.name = name;
    this.genus = genus;
    // Initialize other fields to defaults if necessary
    this.population = 0;
    this.diet = "";
    this.habitat = "";
    this.predators = "";
}

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method: getName
 * Description: Retrieves the name of the species. This method provides access to the private name attribute
 * of a Species instance, allowing for read-only access to this field from outside the class.
 * The name typically represents the common name used to refer to the species in scientific and popular contexts.
 *
 * Project      QuizSpecies Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; mac sonoma 14
 * Course       CS 141
 * Hours        8 hours and 45 minutes
 * Date         5/17/2024
 * History Log  4/4/2016, 11/21/2017
 * Author       <i>Steven Halla</i>
 * @return String The name of the species.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getName() {
        return name;
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method: setName
 * Description: Sets the name of the species to the specified value. This method allows
 * for the modification of the private name attribute of a Species instance from outside
 * the class, enabling the updating of the species name.
 *
 * Project      QuizSpecies Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 11.3; mac sonoma 14
 * Course       CS 141
 * Hours        8 hours and 45 minutes
 * Date         5/17/2024
 * History Log  4/4/2016, 11/21/2017
 * Author       <i>Steven Halla</i>
 * @param name The new name of the species.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setName(String name) {
        this.name = name;
    }


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method: getGenus
 * Description: Retrieves the genus of the species.
 *
 * @return The genus of the species.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getGenus() {
        return genus;
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method: setGenus
 * Description: Sets the genus of the species.
 *
 * @param genus The genus to set.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setGenus(String genus) {
        this.genus = genus;
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method: getPopulation
 * Description: Retrieves the population of the species.
 *
 * @return The population of the species.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getPopulation() {
        return population;
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method: setPopulation
 * Description: Sets the population of the species.
 *
 * @param population The population to set.
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setPopulation(int population) {
        this.population = population;
    }
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Method: getDiet
 * Description: get the diet
 *
= *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public String getDiet() {
        return diet;
    }

    /**
 * Method: setDiet
 * Description: Sets the diet of the species.
 *
 * @param diet The diet to set.
 */
    public void setDiet(String diet) {
        this.diet = diet;
    }
/**
 * Method: getHabitat
 * Description: Retrieves the habitat of the species.
 *
 * @return String The habitat of the species.
 */
    public String getHabitat() {
        return habitat;
    }
/**
 * Method: setHabitat
 * Description: Sets the habitat of the species.
 *
 * @param habitat The habitat to set.
 */
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
/**
 * Method: getPredators
 * Description: Retrieves the predators of the species. This method provides access to the private predators attribute
 * of a Species instance, allowing for read-only access to this field from outside the class.
 * Predators are organisms that hunt and consume other organisms for food.
 *
 * @return String The predators of the species.
 */
    public String getPredators() {
        return predators;
    }
/**
 * Method: setPredators
 * Description: Sets the predators of the species. This method allows for modifying the predators attribute
 * of a Species instance.
 *
 * @param predators The predators to set.
 */
    public void setPredators(String predators) {
        this.predators = predators;
    }
/**
 * Method: toString
 * Description: Returns a string representation of the species. This method concatenates the values of
 * the name, genus, population, diet, habitat, and predators attributes into a single string separated by commas.
 *
 * @return String A string representation of the species.
 */
    @Override
    public String toString() {
        return name + "," + genus + "," + population + "," + diet + "," + habitat + "," + predators;
    }
/**
 * Method: equals
 * Description: Indicates whether some other object is "equal to" this one.
 *
 * @param obj The reference object with which to compare.
 * @return boolean True if this object is the same as the obj argument; false otherwise.
 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Species species = (Species) obj;
        return population == species.population &&
               name.equals(species.name) &&
               genus.equals(species.genus) &&
               diet.equals(species.diet) &&
               habitat.equals(species.habitat) &&
               predators.equals(species.predators);
    }
/**
 * Method: hashCode
 * Description: Returns a hash code value for the object. This method is supported for the benefit of hash tables
 * such as those provided by HashMap.
 *
 * @return int A hash code value for this object.
 */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, genus, population, diet, habitat, predators);
    }
/**
 * Method: compareTo
 * Description: Compares this species to another species based on their populations. Returns a negative integer,
 * zero, or a positive integer as this species population is less than, equal to, or greater than the other
 * species population.
 *
 * @param other The other species to compare to.
 * @return int A negative integer, zero, or a positive integer as this species population is less than,
 * equal to, or greater than the other species population.
 */
    @Override
    public int compareTo(Species other) {
        return Integer.compare(this.population, other.population);
    }
}


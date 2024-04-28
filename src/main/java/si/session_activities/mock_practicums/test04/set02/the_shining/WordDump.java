package si.session_activities.mock_practicums.test04.set02.the_shining;

import java.util.HashMap;
import java.util.Map;

public class WordDump {
    /**
     * The path to the myStory.txt file (you will change this).
     * Also, this is an array as the program can work with any story.
     * For this activity you only need this one. It is at the 0th index.
     */
    public static final String[] STORY_FILES = {
        "C://Users//Christian Morgado//Repos//SI//SI_Sessions_124//src//main//java//si//session_activities//mock_practicums//test04//set02//the_shining//myStory.txt",
    };

    /**
     * A selection of possible students used to fill in student blanks.
     */
    public static final String[] STUDENTS = {
        "Makenna", "Sonia", "Raafay", "Katie", "Kaden", "Aman", "Nhi", "Minh", "Emmalee", "Michael", "Jameson", "James"
    };

    /**
     * A selection of possible SI Leaders used to fill in leaders blanks.
     */
    public static final String[] SIleader = {
       "Faria", "Christian", "Alice", "Teddy", "Jared", "Philip", "Alfonso", "Abe", "Olivia", "Nicholas", "Austin", "Asha", "Mary Beth"
    };

    
    /**
     * A map that can be used to easily retrieve the selection of possible 
     * words by type.
     */
    public static final Map<String,String[]> PLACEHOLDERS = new HashMap<>();

    // build the map of types
    static {
        PLACEHOLDERS.put("STUDENT", WordDump.STUDENTS);
        PLACEHOLDERS.put("SIleader", WordDump.SIleader);
    }
}


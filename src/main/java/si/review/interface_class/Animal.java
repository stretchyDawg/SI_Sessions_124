package si.review.interface_class;

public interface Animal {
    public static final String KINGDOM = "Animalia";
    
    public static String getKingdom() {
       return KINGDOM;
    }
    
    String speak();  
}
    
package si.review.enum_class;

public class Pokemon {
    private String name;
    private Type type;
    private int level;

    public Pokemon(String name, Type type, int level){
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public Pokemon(String name, Type type){
        this.name = name;
        this.type = type;
        this.level = 1;
    }

    public String getName(){
        return this.name;
    }

    public Type getType(){
        return this.type;
    }

    public int getLevel(){
        return this.level;
    }

    public void increaseLevel(){
        if(this.level < 100){
            this.level = this.level + 1;
        }
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Pokemon{name=<" + this.name + ">, type=<" + this.type + ">, level=<" + this.level + ">}";
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Pokemon){
            Pokemon other = (Pokemon)obj;
            return ((this.type == other.type) && (this.level == other.level));
        }
        else{
            return false;
        }
    }
}

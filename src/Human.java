public class Human {
    private String name;
    Human(String s){
        name=s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ""+name;
    }
}

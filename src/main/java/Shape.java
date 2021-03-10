public class Shape {
    private final int numberOfSides;

    public Shape(int numberOfSides) {
        if (numberOfSides < 1 || numberOfSides == Integer.MAX_VALUE){
            throw new IllegalArgumentException();
        }
        this.numberOfSides = numberOfSides;
    }

    public String description(){
        return "I'm a shape";
    }

    public String imWeird(){
        return "I'm just a shape";
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }
}

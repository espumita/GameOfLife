import java.util.ArrayList;
import java.util.List;

public class World {
    private List<CellLocation> population;

    public World() {
        this.population = new ArrayList<>();
    }

    public void addCell(CellLocation location) {
        population.add(location);
    }

    public int getPopulationSize() {
        return population.size();
    }

    public void newGeneration() {
        for(CellLocation location : population) checkPerimeter(location);
    }

    private void checkPerimeter(CellLocation location) {
        int count = 0;
        if(population.contains(new CellLocation(location.getX()+1,location.getY()+1))) count++;
        if(population.contains(new CellLocation(location.getX()+1,location.getY()))) count++;
        if(population.contains(new CellLocation(location.getX()+1,location.getY()-1))) count++;
        if(population.contains(new CellLocation(location.getX(),location.getY()+1))) count++;
        if(population.contains(new CellLocation(location.getX(),location.getY()-1))) count++;
        if(population.contains(new CellLocation(location.getX()-1,location.getY()+1))) count++;
        if(population.contains(new CellLocation(location.getX()-1,location.getY()))) count++;
        if(population.contains(new CellLocation(location.getX()-1,location.getY()-1))) count++;
        checkPerimeterRules(location,count);
    }

    private void checkPerimeterRules(CellLocation location, int count) {
        if(count  < 2) population.remove(location);
    }
}

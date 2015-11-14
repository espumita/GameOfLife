import java.util.ArrayList;
import java.util.List;

public class World {
    private List<CellLocation> population;
    private List<CellLocation> futureDeads;
    private List<CellLocation> futureBorns;

    public World() {
        this.population = new ArrayList<>();
        this.futureDeads = new ArrayList<>();
        this.futureBorns = new ArrayList<>();
    }

    public void addCell(CellLocation location) {
        population.add(location);
    }

    public int getPopulationSize() {
        return population.size();
    }

    public void newGeneration() {
        for(CellLocation location : population) checkPerimeter(location);
        displayNewGeneration();
    }

    private void displayNewGeneration() {
        population.removeAll(futureDeads);
        futureDeads.clear();
        population.addAll(futureBorns);
        futureBorns.clear();
    }

    private void checkPerimeter(CellLocation location) {
        if (futureDeads.contains(location)) return;
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
        if(count  < 2) futureDeads.add(location); System.out.println(location.getX()+"_"+location.getY()+" loniless");
        if(count  > 3) futureDeads.add(location);System.out.println(location.getX()+"_"+location.getY()+" overpopulation");

    }
}

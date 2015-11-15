import java.util.HashSet;
import java.util.Set;

public class World {
    private Set<String> population;
    private Set<String> futureDeads;
    private Set<String> futureBorns;

    public World() {
        this.population = new HashSet<>();
        this.futureDeads = new HashSet<>();
        this.futureBorns = new HashSet<>();
    }

    public void addCell(String location) {
        population.add(location);
    }

    public int getPopulationSize() {
        return population.size();
    }

    public void newGeneration() {
        for(String location : population) checkPerimeter(location);
        displayNewGeneration();
    }

    private void displayNewGeneration() {
        population.removeAll(futureDeads);
        futureDeads.clear();
        population.addAll(futureBorns);
        futureBorns.clear();
    }

    private void checkPerimeter(String location) {
        String[] parts = location.split("_");
        int i = Integer.parseInt(parts[0]);
        int j = Integer.parseInt(parts[1]);
        if (futureDeads.contains(location)) return;
        int count = 0;
        if(population.contains((i+1)+"_"+(j+1))) count++;
        if(population.contains((i+1)+"_"+(j))) count++;
        if(population.contains((i+1)+"_"+(j-1))) count++;
        if(population.contains((i)+"_"+(j+1))) count++;
        if(population.contains((i)+"_"+(j-1))) count++;
        if(population.contains((i-1)+"_"+(j+1))) count++;
        if(population.contains((i-1)+"_"+(j))) count++;
        if(population.contains((i-1)+"_"+(j-1))) count++;
        checkPerimeterRules(location,count);
    }

    private void checkPerimeterRules(String location, int count) {
        if(count  < 2 || count  > 3) futureDeads.add(location);

    }
}

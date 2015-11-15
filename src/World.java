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
        for(String location : population) checkPerimeter(true,location);
        displayNewGeneration();
    }

    private void displayNewGeneration() {
        population.removeAll(futureDeads);
        futureDeads.clear();
        population.addAll(futureBorns);
        futureBorns.clear();
    }

    private void checkPerimeter(boolean exists, String location) {
        String[] parts = location.split("_");
        int i = Integer.parseInt(parts[0]);
        int j = Integer.parseInt(parts[1]);
        int count = 0;
        if(population.contains((i+1)+"_"+(j+1))) count++; else if(exists) checkPerimeter(false,(i+1)+"_"+(j+1));
        if(population.contains((i+1)+"_"+(j))) count++; else if(exists) checkPerimeter(false,(i+1)+"_"+(j));
        if(population.contains((i+1)+"_"+(j-1))) count++; else if(exists) checkPerimeter(false,(i+1)+"_"+(j-1));
        if(population.contains((i)+"_"+(j+1))) count++; else if(exists) checkPerimeter(false,(i)+"_"+(j+1));
        if(population.contains((i)+"_"+(j-1))) count++; else if(exists) checkPerimeter(false,(i)+"_"+(j-1));
        if(population.contains((i-1)+"_"+(j+1))) count++; else if(exists) checkPerimeter(false,(i-1)+"_"+(j+1));
        if(population.contains((i-1)+"_"+(j))) count++; else if(exists) checkPerimeter(false,(i-1)+"_"+(j));
        if(population.contains((i-1)+"_"+(j-1))) count++; else if(exists) checkPerimeter(false,(i-1)+"_"+(j-1));
        checkPerimeterRules(exists,location,count);
    }

    private void checkPerimeterRules(boolean exists, String location, int count) {
        if(exists && count  < 2 || count  > 3) futureDeads.add(location);
        if(!exists && count == 3) futureBorns.add(location);

    }

    public void print() {
        System.out.println("----------------------------------------");
        for(String location : population) System.out.println(location);;
        System.out.println("----------------------------------------");
    }
}

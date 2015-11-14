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
}

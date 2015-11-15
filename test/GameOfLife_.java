import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLife_ {
    private World world;
    @Before
    public void setUp(){
        world = new World();
        world.addCell("0_0");
    }

    @Test
    public void when_you_got_only_one_cell_in_the_world() throws Exception {
        assertThat(world.getPopulationSize(),is(1));
    }

    @Test
    public void when_only_one_cell_and_it_dies_in_new_generation_cause_loneliness() throws Exception {
        world.newGeneration();
        assertThat(world.getPopulationSize(),is(0));
    }

    @Test
    public void when_one_cell_dies_cause_overpopulation_in_new_generation() throws Exception {
        world.addCell("0_1");
        world.addCell("-1_0");
        world.addCell("-1_1");
        world.addCell("-1_-1");
        world.newGeneration();
        assertThat(world.getPopulationSize(),is(3));
    }
}

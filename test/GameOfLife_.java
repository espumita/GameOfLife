import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLife_ {
    private World world;
    @Before
    public void setUp(){
        world = new World();
    }

    @Test
    public void when_you_got_only_one_cell_in_the_world() throws Exception {
        world.addCell(new CellLocation(0,0));
        assertThat(world.getPopulationSize(),is(1));

    }


}

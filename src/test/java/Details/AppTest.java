package Details;

import Details.config.RedisClientTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest
{
    /**
     * Rigorous Test :-)
     */

    @Autowired
    public RedisClientTemplate clientTemplate;
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void getConfigValue(){

        for (int i = 0; i < 100; i++) {
            System.out.print(i + "_" + clientTemplate.setToRedis(String.valueOf(i), String.valueOf(i)) + "\n");
        }
    }

}

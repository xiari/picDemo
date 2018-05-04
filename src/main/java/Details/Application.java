package Details;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 10:06
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

@SpringBootApplication
@MapperScan("Details.Mapper")
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}

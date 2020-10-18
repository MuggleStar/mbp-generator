package tests;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.mugglestar.utils.GeneratorHelp;
import org.junit.Test;

/**
 * @author MuggleStar
 * @date 2020/6/2 23:06
 */
public class GeneratorTest {

    @Test
    public void testExecute() {

        DataSourceConfig dataSourceConfig = new DataSourceConfig();

        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://192.168.0.104:3306/generator?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        GeneratorHelp generatorHelp = new GeneratorHelp(dataSourceConfig);
        generatorHelp.setAuthor("Madison");
        generatorHelp.setPackageName("com.mugglestar");

        generatorHelp.execute("order","t_order","t_");
        generatorHelp.execute("order","t_order_item","t_");

    }


}

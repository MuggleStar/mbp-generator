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
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/d_customer?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Hongkong&autoReconnect=true");
        dataSourceConfig.setUsername("123456");
        dataSourceConfig.setPassword("123456");
        GeneratorHelp generatorHelp = new GeneratorHelp(dataSourceConfig);
        generatorHelp.setAuthor("Madison");
        generatorHelp.setPackageName("com.aios.server");

        generatorHelp.execute("business","decoration_approval","");


    }


}

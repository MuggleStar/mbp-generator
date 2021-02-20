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
        dataSourceConfig.setUrl("jdbc:mysql://mysql.tenet.com:3306/tenet-goods?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        GeneratorHelp generatorHelp = new GeneratorHelp(dataSourceConfig);
        generatorHelp.setAuthor("Madison");
        generatorHelp.setPackageName("com.generate");

        generatorHelp.execute("brand","go_brand","");
        generatorHelp.execute("category","go_category","");
        generatorHelp.execute("category","go_category_brand","");
        generatorHelp.execute("specification","go_spec_group","");
        generatorHelp.execute("specification","go_spec_param","");
        generatorHelp.execute("goods","go_sku","");
        generatorHelp.execute("goods","go_sku_stock","");
        generatorHelp.execute("goods","go_spu","");
        generatorHelp.execute("goods","go_spu_detail","");

    }


}

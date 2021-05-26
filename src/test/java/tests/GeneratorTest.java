package tests;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.mugglestar.utils.GeneratorHelp;
import org.junit.Test;


/**
 * @author MuggleStar
 * @date 2020/6/2 23:06
 */
public class GeneratorTest {

    @Test
    public void testExecute() throws Exception {

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("org.postgresql.Driver");
        dataSourceConfig.setUrl("jdbc:postgresql://192.168.43.100:5432/lingxi");
        dataSourceConfig.setUsername("postgres");
        dataSourceConfig.setPassword("postgres");
        dataSourceConfig.setSchemaName("lingxi");
        dataSourceConfig.setDbType(DbType.POSTGRE_SQL);

        GeneratorHelp generatorHelp = new GeneratorHelp(dataSourceConfig);
        generatorHelp.setAuthor("lujianrong");
        generatorHelp.setPackageName("com.lingxi");

        generatorHelp.execute("server","advertise","");
        generatorHelp.execute("server","advertise_item","");
        generatorHelp.execute("server","advertise_material","");
        generatorHelp.execute("server","advertise_material_group","");
        generatorHelp.execute("server","advertise_to_shop","");
        generatorHelp.execute("server","shop","");
        generatorHelp.execute("server","cashier","");
        generatorHelp.execute("server","equipment","");
        generatorHelp.execute("server","equipment_apk","");
        generatorHelp.execute("server","equipment_prop_name","");
        generatorHelp.execute("server","sys_dict_data","");
        generatorHelp.execute("server","sys_dict_type","");


    }


}

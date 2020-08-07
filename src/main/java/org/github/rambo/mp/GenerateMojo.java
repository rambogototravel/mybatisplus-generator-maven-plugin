package org.github.rambo.mp;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * 生成文件。
 *
 * @author ramboy
 */
@Mojo(name = "generator", threadSafe = true)
public class GenerateMojo extends AbstractGenerateMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        log.info("==========================准备生成文件...==========================");

        //代码生成器
        AutoGenerator generator = new AutoGenerator();

        generator.setConfig(initConfig());

        generator.execute();

        log.info("==========================文件生成完成！！！==========================");
//        if (dataSourceConfig.getDbType().equals(DbType.MYSQL)) {
//            dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
//        }
//        generator.setDataSource(dataSourceConfig);
//
//        if (null == globalConfig) {
//            globalConfig = new GlobalConfig();
//        }
//        if (StringUtils.isEmpty(globalConfig.getAuthor())) {
//            globalConfig.setAuthor(System.getenv("USERNAME"));
//        }
//        if (StringUtils.isNotEmpty(globalConfig.getOutputDir())) {
//
//            if (globalConfig.getOutputDir().equals("D://")) {
//
//                if (OSinfo.isLinux()) {
//                    globalConfig.setOutputDir("/home/" + System.getenv("USERNAME") + "/Desktop");
//                }
//            } else {
//
//                if (globalConfig.getOutputDir().indexOf("/") != 0) {
//
//                    String path = System.getProperty("user.dir") + File.separator + globalConfig.getOutputDir();
//                    globalConfig.setOutputDir(path);
//                }
//            }
//        }
//        generator.setGlobalConfig(globalConfig);
//
//        if (null == packageConfig) {
//            packageConfig = new PackageConfig();
//        }
//        generator.setPackageInfo(packageConfig);
//
//        if (null == strategyConfig) {
//            strategyConfig = new StrategyConfig();
//        }
//        generator.setStrategy(strategyConfig);
//
//        if (null == templateConfig) {
//            templateConfig = new TemplateConfig();
//        }
//        generator.setTemplate(templateConfig);
    }
}

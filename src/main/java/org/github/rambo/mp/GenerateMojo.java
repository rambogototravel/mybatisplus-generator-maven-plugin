package org.github.rambo.mp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 * 生成文件。
 *
 * @author rambo yang
 */
@Mojo(name = "generator", threadSafe = true)
public class GenerateMojo extends AbstractMojo {

    /**
     * 数据源配置
     */
    @Parameter(required = true)
    private DataSourceConfig dataSourceConfig;

    @Parameter
    private GlobalConfig globalConfig;

    @Parameter
    private PackageConfig packageConfig;

    @Parameter
    private StrategyConfig strategyConfig;

    @Parameter
    private TemplateConfig templateConfig;


    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        //代码生成器
        AutoGenerator generator = new AutoGenerator();

        if (dataSourceConfig.getDbType().equals(DbType.MYSQL)) {
            dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        }
        generator.setDataSource(dataSourceConfig);

        if (null == globalConfig) {
            globalConfig = new GlobalConfig();
        }
        if (StringUtils.isEmpty(globalConfig.getAuthor())) {
            globalConfig.setAuthor(System.getenv("USERNAME"));
        }
        if (StringUtils.isNotEmpty(globalConfig.getOutputDir())) {

            if (globalConfig.getOutputDir().equals("D://")) {

                if (OSinfo.isLinux()) {
                    globalConfig.setOutputDir("/home/" + System.getenv("USERNAME") + "/Desktop");
                }
            } else {

                if (globalConfig.getOutputDir().indexOf("/") != 0) {

                    String path = System.getProperty("user.dir") + File.separator + globalConfig.getOutputDir();
                    globalConfig.setOutputDir(path);
                }
            }
        }
        generator.setGlobalConfig(globalConfig);

        if (null == packageConfig) {
            packageConfig = new PackageConfig();
        }
        generator.setPackageInfo(packageConfig);

        if (null == strategyConfig) {
            strategyConfig = new StrategyConfig();
        }
        generator.setStrategy(strategyConfig);

        if (null == templateConfig) {
            templateConfig = new TemplateConfig();
        }
        generator.setTemplate(templateConfig);

        generator.execute();
    }
}

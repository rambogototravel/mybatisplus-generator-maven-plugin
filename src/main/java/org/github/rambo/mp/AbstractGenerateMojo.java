package org.github.rambo.mp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @author ramboy
 */
public abstract class AbstractGenerateMojo extends AbstractMojo {

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

    protected ConfigBuilder config;

    /**
     * 日志工具
     */
    protected Log log = getLog();

    /**
     * 初始化配置
     */
    protected ConfigBuilder initConfig() {

        if (dataSourceConfig.getDbType().equals(DbType.MYSQL)) {
            dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        }

        if (null == config) {
            config = new ConfigBuilder(packageConfig, dataSourceConfig, strategyConfig, templateConfig, globalConfig);
        }
        return config;
    }
}

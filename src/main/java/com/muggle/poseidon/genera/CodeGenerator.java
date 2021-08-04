package com.muggle.poseidon.genera;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.muggle.poseidon.entity.ProjectMessage;

/**
 * @program: poseidon-generator
 * @description:
 * @author: muggle
 * @create: 2019-12-05
 **/

public abstract class CodeGenerator {


    private  ProjectMessage message;

    private FreemarkerTemplateEngine freemarkerTemplateEngine;

    public void init(ProjectMessage projectMessage){
        this.message=projectMessage;
    }

    public CodeGenerator() {
    }

    public CodeGenerator(ProjectMessage message) {
        this.message = message;
    }


    /**
     * 数据库配置
     *
     * @param dsc
     * @return
     */
    abstract DataSourceConfig configDataSource(ProjectMessage dsc);

    /**
     * 类属性配置
     *
     * @param message 代码生成实体信息
     * @return
     */
    abstract GlobalConfig configGlobal(ProjectMessage message);

    /**
     * 包属性配置
     *
     * @param message
     * @return
     */
    abstract PackageConfig configPc(ProjectMessage message);

    /**
     * 文件属性配置
     *
     * @param message
     * @return
     */
    abstract InjectionConfig fileConfig(ProjectMessage message);

    /**
     * 代码模板配置
     *
     * @param message
     * @return
     */
    abstract TemplateConfig configTemp(ProjectMessage message);

    /**
     * 父类相关配置
     *
     * @param message
     * @return
     */
    abstract StrategyConfig configStrategy(ProjectMessage message);

    /**
     * 实际执行生成代码的方法
     */
    public void createCode() {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        DataSourceConfig dataSourceConfig = configDataSource(this.message);
        GlobalConfig globalConfig = configGlobal(this.message);
        PackageConfig packageConfig = configPc(this.message);
        InjectionConfig config = fileConfig(this.message);
        mpg.setPackageInfo(packageConfig);
        mpg.setDataSource(dataSourceConfig);
        mpg.setGlobalConfig(globalConfig);
        mpg.setCfg(config);
        TemplateConfig templateConfig = configTemp(this.message);
        mpg.setTemplate(templateConfig);
        StrategyConfig strategyConfig = configStrategy(message);
        mpg.setStrategy(strategyConfig);
        FreemarkerTemplateEngine freemarkerTemplateEngine = new FreemarkerTemplateEngine();
        this.freemarkerTemplateEngine=freemarkerTemplateEngine;
        mpg.setTemplateEngine(freemarkerTemplateEngine);
        mpg.execute();
    }


    public FreemarkerTemplateEngine getFreemarkerTemplateEngine() {
        return freemarkerTemplateEngine;
    }

    public void setFreemarkerTemplateEngine(FreemarkerTemplateEngine freemarkerTemplateEngine) {
        this.freemarkerTemplateEngine = freemarkerTemplateEngine;
    }
}

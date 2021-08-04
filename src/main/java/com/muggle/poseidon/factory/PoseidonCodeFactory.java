package com.muggle.poseidon.factory;

import com.muggle.poseidon.constant.GlobalConstant;
import com.muggle.poseidon.entity.ProjectMessage;
import com.muggle.poseidon.genera.CodeGenerator;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Description
 * Date 2021/7/29
 * Created by muggle
 */
public class PoseidonCodeFactory extends CodeFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(PoseidonCodeFactory.class);

    public static void createProject(ProjectMessage projectMessage) throws Exception {
        if (!(Boolean.getBoolean("skipJdbc") || projectMessage.isSkipJdbc())) {
            LOGGER.info("skipJdbc== false》》》》》》》》》》》》》》》》》》》》》》》》》》》》");
            createCode(projectMessage);
        }
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
        if (!(Boolean.getBoolean("skipBase") || projectMessage.isSkipBase())) {
            LOGGER.info("skipBase== false》》》》》》》》》》》》》》》》》》》》》》》》》》》》");
            createBanner(projectMessage);
            createMainClass( projectMessage);
            createPom( projectMessage);
            createProperties("bootstrap",  projectMessage);
            createProperties("application", projectMessage);
            createReadme(projectMessage);
            createLogback( projectMessage);
        }
        if (!(Boolean.getBoolean("skipConfig") || projectMessage.isSkipConfig())) {
            LOGGER.info("skipConfig== false》》》》》》》》》》》》》》》》》》》》》》》》》》》》");
            String filePath = CodeGenerator.class.getClassLoader().getResource(GlobalConstant.OTHER).getFile();
            createConfig(projectMessage);
        }


    }


}

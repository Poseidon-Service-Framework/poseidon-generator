package com.muggle.poseidon.factory;

import com.muggle.poseidon.constant.GlobalConstant;
import com.muggle.poseidon.entity.ProjectMessage;
import com.muggle.poseidon.genera.CodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

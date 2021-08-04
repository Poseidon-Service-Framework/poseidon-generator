package com.muggle.poseidon;

import com.muggle.poseidon.entity.ProjectMessage;
import com.muggle.poseidon.factory.PoseidonCodeFactory;
import com.muggle.poseidon.genera.SimpleCodeGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, TemplateException {
        Map<String, String> otherfield=new HashMap<>();
        otherfield.put("parentVersion","1.0-SNAPSHOT");
        ProjectMessage build = ProjectMessage.builder().author("muggle").driver("com.mysql.jdbc.Driver").username("root")
                .swagger(true).tableName(Arrays.asList("oa_url_info")).parentPack("com.muggle.base")
                .jdbcUrl("jdbc:mysql:///p_oa?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC")
                .suffix("user").password("root").module("muggle-generator").projectPackage("com.muggle")
                .otherField(otherfield).skipJdbc(false).skipBase(false).skipConfig(false).build();
        PoseidonCodeFactory.init(new SimpleCodeGenerator());
        PoseidonCodeFactory.createProject(build);
    }
}
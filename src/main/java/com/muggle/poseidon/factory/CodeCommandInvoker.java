package com.muggle.poseidon.factory;

import com.muggle.poseidon.entity.CodeCommand;
import com.muggle.poseidon.entity.ProjectMessage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description
 * Date 2021/8/5
 * Created by muggle
 */
public class CodeCommandInvoker extends CodeFactory {

    private Queue<CodeCommand> commandQueue;

    private final ProjectMessage projectMessage;

    public CodeCommandInvoker(ProjectMessage projectMessage) {
        this.commandQueue= new LinkedList<>();
        this.projectMessage=projectMessage;
        commandQueue.add(new CodeCommand() {
            @Override
            public String getName() {
                return "createPom";
            }
            @Override
            public void excute() throws Exception {
                createPom(projectMessage);
            }
        });
        commandQueue.add(new CodeCommand() {
            @Override
            public String getName() {
                return "createApplication";
            }
            @Override
            public void excute() throws Exception {
                createProperties("application",projectMessage);
            }
        });
        commandQueue.add(new CodeCommand() {
            @Override
            public String getName() {
                return "createBootstrap";
            }
            @Override
            public void excute() throws Exception {
                createProperties("bootstrap",projectMessage);
            }
        });
        commandQueue.add(new CodeCommand() {
            @Override
            public String getName() {
                return "createBanner";
            }
            @Override
            public void excute() throws Exception {
                createBanner(projectMessage);
            }
        });
        commandQueue.add(new CodeCommand() {
            @Override
            public String getName() {
                return "createCode";
            }
            @Override
            public void excute() throws Exception {
                createCode(projectMessage);
            }
        });
        commandQueue.add(new CodeCommand() {
            @Override
            public String getName() {
                return "createConfig";
            }
            @Override
            public void excute() throws Exception {
                createConfig(projectMessage);
            }
        });
        commandQueue.add(new CodeCommand() {
            @Override
            public String getName() {
                return "createLogback";
            }
            @Override
            public void excute() throws Exception {
                createLogback(projectMessage);
            }
        });
        commandQueue.add(new CodeCommand() {
            @Override
            public String getName() {
                return "createMainClass";
            }
            @Override
            public void excute() throws Exception {
                createMainClass(projectMessage);
            }
        });
        commandQueue.add(new CodeCommand() {
            @Override
            public String getName() {
                return "createReadme";
            }
            @Override
            public void excute() throws Exception {
                createReadme(projectMessage);
            }
        });

    }

    public void execute(){
        commandQueue.forEach(codeCommand -> {
            try {
                codeCommand.excute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    public void addCommond(CodeCommand codeCommand){
        commandQueue.add(codeCommand);
    }

    public void popCommond(String commandName){
        Iterator<CodeCommand> iterator = commandQueue.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(commandName)) {
                iterator.remove();
            }
        }
    }

}

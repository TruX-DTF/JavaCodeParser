package edu.lu.uni.serval;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by anilkoyuncu on 12/10/2018.
 */
public class Launcher {
    private static Logger log = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) throws IOException {


        String filename = args[0];

//        String filename = "/Users/anil.koyuncu/KUI/Defects4JData/Math_106/src/java/org/apache/commons/math/fraction/ProperFractionFormat.java";
//        String filename = "/Users/anil.koyuncu/KUI/Defects4JData/Math_12/src/main/java/org/apache/commons/math3/random/BitsStreamGenerator.java";
//        String filename = "/Users/anilkoyuncu/projects/bugLocalization/gitrepo/fuse/fabric/fabric-itests/basic/src/test/java/io/fabric8/itests/basic/mq/MQProfileTest.java";
        try {

//        String filename = "/Volumes/anil.koyuncu/gitrepo/hive/itests/util/src/main/java/org/apache/hadoop/hive/cli/control/CoreBeeLineDriver.java";
//        String filename = "/Volumes/anil.koyuncu/gitrepo/camel/tooling/maven/camel-api-component-maven-plugin/src/test/java/org/apache/camel/maven/AbstractGeneratorMojoTest.java";
//        String filename = "/Volumes/anil.koyuncu/gitrepo/camel/tooling/maven/camel-api-component-maven-plugin/src/main/java/org/apache/camel/maven/Substitution.java";
//        String filename = "/Volumes/anil.koyuncu/gitrepo/camel/tooling/maven/camel-api-component-maven-plugin/src/main/java/org/apache/camel/maven/DocumentGeneratorMojo.java";
//        String filename = "/Users/anilkoyuncu/projects/bugLocalization/DocumentGeneratorMojo.java";

            File javaFile = new File(filename);
            javaFile.setReadOnly();

            CompilationUnit compilationUnit = JavaParser.parse(javaFile);

            Map map = new HashMap();

            List<String> comments = compilationUnit.getAllContainedComments()
                    .stream()
                    .map(Comment::getContent)
                    .collect(Collectors.toList());

            List<String> packageName = compilationUnit.
                    findAll(PackageDeclaration.class)
                    .stream()
                    .map(PackageDeclaration::getName)
                    .map(Name::toString)
                    .collect(Collectors.toList());

            List<String> classNames = compilationUnit.
                    findAll(ClassOrInterfaceDeclaration.class, x -> x.isClassOrInterfaceDeclaration())
                    .stream()
                    .map(ClassOrInterfaceDeclaration::getName)
                    .map(SimpleName::getIdentifier)
                    .collect(Collectors.toList());

            List<String> ext = compilationUnit.
                    findAll(ClassOrInterfaceType.class, x -> x.isClassOrInterfaceType())
                    .stream()
                    .map(ClassOrInterfaceType::getName)
                    .map(SimpleName::getIdentifier)
                    .collect(Collectors.toList());

//        classNames.addAll(ext);

//      methodNames
            List<String> methodDecs = compilationUnit.
                    findAll(MethodDeclaration.class, x -> x.isMethodDeclaration())
                    .stream()
                    .map(MethodDeclaration::getName)
                    .map(SimpleName::getIdentifier)
                    .collect(Collectors.toList());
//        methodInvocation
            List<String> methodCalls = compilationUnit.
                    findAll(MethodCallExpr.class, x -> x.isMethodCallExpr())
                    .stream()
                    .map(MethodCallExpr::getName)
                    .map(SimpleName::getIdentifier)
                    .collect(Collectors.toList());
            //member reference
            List<String> memberReference = compilationUnit.
                    findAll(NameExpr.class, x -> x.isNameExpr())
                    .stream()
                    .map(NameExpr::getName)
                    .map(SimpleName::getIdentifier)
                    .collect(Collectors.toList());

            List<String> literals = compilationUnit.
                    findAll(LiteralExpr.class, x -> x.isLiteralExpr())
                    .stream()
                    .map(LiteralExpr::toString)

                    .collect(Collectors.toList());

            List<String> formalParameters = compilationUnit.
                    findAll(Parameter.class)
                    .stream()
                    .map(Parameter::getName)
                    .map(SimpleName::getIdentifier)
                    .collect(Collectors.toList());
//                .collect(Collectors.joining("',' "));


            List<ClassOrInterfaceDeclaration> classNamesL = compilationUnit.
                    findAll(ClassOrInterfaceDeclaration.class, x -> x.isClassOrInterfaceDeclaration())
                    .stream()
                    .collect(Collectors.toList());

            List<String> classExtentions = new ArrayList<>();
            for (ClassOrInterfaceDeclaration c : classNamesL) {
                List<String> localExtented = c.getExtendedTypes().stream()
                        .map(ClassOrInterfaceType::getName)
                        .map(SimpleName::getIdentifier)
                        .collect(Collectors.toList());
                List<String> localImplemented = c.getImplementedTypes().stream()
                        .map(ClassOrInterfaceType::getName)
                        .map(SimpleName::getIdentifier)
                        .collect(Collectors.toList());
                if (!localExtented.isEmpty())
                    classExtentions.addAll(localExtented);
                if (!localImplemented.isEmpty())
                    classExtentions.addAll(localImplemented);

            }
            List<String> classNamesMap = new ArrayList<>();
            classNamesMap.addAll(classNames);
            classNamesMap.addAll(classExtentions);
            classNames.addAll(ext);
            map.put("className", classNamesMap);
            map.put("methodNames", methodDecs);
            map.put("formalParameter", formalParameters);
            map.put("methodInvocation", methodCalls);
            map.put("memberReference", memberReference);
            map.put("documentation", comments);
            map.put("packageName", packageName);
            map.put("literal", literals);
            map.put("classNameExt", classNames);

            String json = new ObjectMapper().writeValueAsString(map);
            System.out.println(json);
        }catch (java.io.FileNotFoundException ex){
            System.err.print(ex);

        }catch (Exception ex){

            Map map = new HashMap();
            map.put("className", "");
            map.put("methodNames", "");
            map.put("formalParameter", "");
            map.put("methodInvocation", "");
            map.put("memberReference", "");
            map.put("documentation", "");
            map.put("packageName", "");
            map.put("literal", "");
            map.put("classNameExt", "");

            String json = new ObjectMapper().writeValueAsString(map);
            System.out.println(json);
        }
    }

}

package edu.lu.uni.serval;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javaparser.JavaParser;
import com.github.javaparser.Position;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
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
public class LauncherWithRanges {
    private static Logger log = LoggerFactory.getLogger(LauncherWithRanges.class);

    public static void main(String[] args) throws IOException {


        String filename = args[0];

//        String filename = "/Users/anil.koyuncu/KUI/Defects4JData/Math_1/src/main/java/org/apache/commons/math3/fraction/Fraction.java";
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

//            Map map = new HashMap();
            MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();



//            List<AssertStmt> assertStmts = compilationUnit.
//                    findAll(AssertStmt.class, x -> x.isAssertStmt())
//                    .stream()
//                    .collect(Collectors.toList());
//
//            List<BlockStmt>  blockStmts = compilationUnit.
//                    findAll(BlockStmt.class, x -> x.isBlockStmt())
//                    .stream()
//                    .collect(Collectors.toList());
//
//            List<BreakStmt>  breakStmts = compilationUnit.
//                    findAll(BreakStmt.class, x -> x.isBreakStmt())
//                    .stream()
//                    .collect(Collectors.toList());
//
//            List<CatchClause>  catchClauses = compilationUnit.
//                    findAll(CatchClause.class)
//                    .stream()
//                    .collect(Collectors.toList());
//
//            List<ContinueStmt>  continueStmts = compilationUnit.
//                    findAll(ContinueStmt.class,x->x.isContinueStmt())
//                    .stream()
//                    .collect(Collectors.toList());
//
//            List<DoStmt>  doStmts = compilationUnit.
//                    findAll(DoStmt.class,x->x.isDoStmt())
//                    .stream()
//                    .collect(Collectors.toList());
//
//            List<EmptyStmt>  emptyStmts = compilationUnit.
//                    findAll(EmptyStmt.class,x->x.isEmptyStmt())
//                    .stream()
//                    .collect(Collectors.toList());
//
//            List<ExplicitConstructorInvocationStmt>  explicitConstructorInvocationStmts = compilationUnit.
//                    findAll(ExplicitConstructorInvocationStmt.class,x->x.isExplicitConstructorInvocationStmt())
//                    .stream()
//                    .collect(Collectors.toList());
//
//            List<ExpressionStmt>  ExpressionStmt = compilationUnit.
//                    findAll(ExpressionStmt.class,x->x.isExpressionStmt())
//                    .stream()
//                    .collect(Collectors.toList());
//
//            List<ForeachStmt>  foreachStmts = compilationUnit.
//                    findAll(ForeachStmt.class,x->x.isForeachStmt())
//                    .stream()
//                    .collect(Collectors.toList());
//
//
//            List<ForStmt>  forStmts = compilationUnit.
//                    findAll(ForStmt.class,x->x.isForStmt())
//                    .stream()
//                    .collect(Collectors.toList());

            List<Statement>  statements = compilationUnit.
                    findAll(Statement.class,x->x.isExplicitConstructorInvocationStmt() || x.isExpressionStmt() || x.isIfStmt() || x.isReturnStmt() || x.isLocalClassDeclarationStmt())
                    .stream()
                    .collect(Collectors.toList());





//            List<ClassOrInterfaceDeclaration> classOrInterfaceDecs = compilationUnit.
//                    findAll(ClassOrInterfaceDeclaration.class, x -> x.isClassOrInterfaceDeclaration())
//                    .stream()
////                    .map(ConstructorDeclaration::getName)
//                    .collect(Collectors.toList());
//
//            List<ConstructorDeclaration> constructorDecs = compilationUnit.
//                    findAll(ConstructorDeclaration.class, x -> x.isConstructorDeclaration())
//                    .stream()
////                    .map(ConstructorDeclaration::getName)
//                    .collect(Collectors.toList());
//
//            List<EnumDeclaration> enumDecs = compilationUnit.
//                    findAll(EnumDeclaration.class, x -> x.isEnumDeclaration())
//                    .stream()
////                    .map(EnumDeclaration::getName)
//                    .collect(Collectors.toList());
//
//            List<EnumConstantDeclaration> enumConstDecs = compilationUnit.
//                    findAll(EnumConstantDeclaration.class, x -> x.isEnumConstantDeclaration())
//                    .stream()
////                    .map(EnumDeclaration::getName)
//                    .collect(Collectors.toList());
//
////      methodNames
//            List<MethodDeclaration> methodDecs = compilationUnit.
//                    findAll(MethodDeclaration.class, x -> x.isMethodDeclaration())
//                    .stream()
////                    .map(MethodDeclaration::getName)
//                    .collect(Collectors.toList());









            //            List<FieldDeclaration> fieldDecs = compilationUnit.
//                    findAll(FieldDeclaration.class, x -> x.isFieldDeclaration())
//                    .stream()
////                    .map(ConstructorDeclaration::getName)
//                    .collect(Collectors.toList());

//            List<InitializerDeclaration> initDecs = compilationUnit.
//                    findAll(InitializerDeclaration.class, x -> x.isInitializerDeclaration())
//                    .stream()
////                    .map(ConstructorDeclaration::getName)
//                    .collect(Collectors.toList());

//            List<TypeDeclaration> typeDecs = compilationUnit.
//                    findAll(TypeDeclaration.class, x -> x.isTypeDeclaration())
//                    .stream()
////                    .map(MethodDeclaration::getName)
//                    .collect(Collectors.toList());

//            List<VariableDeclarator> varDecs = compilationUnit.
//                    findAll(VariableDeclarator.class)
//                    .stream()
////                    .map(MethodDeclaration::getName)
//                    .collect(Collectors.toList());
//            List<SimpleName> constructoprDecs = compilationUnit.
//                    findAll(ConstructorDeclaration.class, x -> x.isConstructorDeclaration())
//                    .stream()
//                    .map(ConstructorDeclaration::getName)
//                    .collect(Collectors.toList());

//            List<SimpleName> fieldDec = compilationUnit.
//                    findAll(FieldDeclaration.class, x -> x.isFieldDeclaration())
//                    .stream()
//                    .map(FieldDeclaration::getVariables)
//                    .collect(Collectors.toList());


//            for (ClassOrInterfaceDeclaration cd : classOrInterfaceDecs){
////                String identifier = cd.getName().getIdentifier();
//                String identifier = cd.getTokenRange().toString();
////                Position end = cd.getBody().getRange().get().end;
//                Position begin = cd.getName().getRange().get().begin;
//                map.put(identifier,String.valueOf(begin.line) );
//            }
//            for (ConstructorDeclaration cd : constructorDecs){
////                String identifier = cd.getName().getIdentifier();
//                String identifier = cd.getTokenRange().get().toString();
//                Position end = cd.getBody().getRange().get().end;
//                Position begin = cd.getName().getRange().get().begin;
//                map.put(identifier,String.valueOf(begin.line) + "-" + String.valueOf(end.line));
//            }
//
//            for (EnumDeclaration cd : enumDecs){
////                String identifier = cd.getName().getIdentifier();
//                String identifier = cd.getTokenRange().get().toString();
//                Position begin = cd.getName().getRange().get().begin;
//                map.put(identifier,String.valueOf(begin.line));
//            }
//
//            for (EnumConstantDeclaration cd : enumConstDecs){
////                String identifier = cd.getName().getIdentifier();
//                String identifier = cd.getTokenRange().get().toString();
//                Position begin = cd.getName().getRange().get().begin;
//                map.put(identifier,String.valueOf(begin.line));
//            }

//            for (FieldDeclaration cd : fieldDecs){
//                String identifier = cd.getVariables().get(0).getName().getIdentifier();
////                Position end = cd.getBody().getRange().get().end;
//                Position begin = cd.getRange().get().begin;
//                map.put(identifier,String.valueOf(begin.line));
//            }

//            for (InitializerDeclaration cd : initDecs){
//                String identifier = cd.ge.toString();
////                Position end = cd.getBody().getRange().get().end;
//                Position begin = cd.getRange().get().begin;
//                map.put(identifier,String.valueOf(begin.line));
//            }

//            for (MethodDeclaration cd : methodDecs){
////                String identifier = cd.getName().getIdentifier();
//                String identifier = cd.getTokenRange().get().toString();
//                if (cd.getBody().isPresent()){
//                    Position end = cd.getBody().get().getRange().get().end;
//                    Position begin = cd.getName().getRange().get().begin;
//                    map.put(identifier,String.valueOf(begin.line) + "-" + String.valueOf(end.line));
//                }else{
//                    Position begin = cd.getName().getRange().get().begin;
//                    map.put(identifier,String.valueOf(begin.line) );
//
//
//                }
//            }

//            for (TypeDeclaration cd : typeDecs){
//                String identifier = cd.getName().getIdentifier();
////                Position end = cd.getBody().get().getRange().get().end;
//                Position begin = cd.getName().getRange().get().begin;
//                map.put(identifier,String.valueOf(begin.line));
//            }




            for (Statement cd : statements){
//                String identifier = cd.getName().getIdentifier();
                String identifier = cd.getTokenRange().get().toString();
                if (cd.getRange().isPresent()){
                    Position end = cd.getRange().get().end;
                    Position begin = cd.getRange().get().begin;
                    map.put(identifier,String.valueOf(begin.line) + "-" + String.valueOf(end.line));
                }
            }












//            classNamesMap.addAll(classNames);
//            classNamesMap.addAll(classExtentions);
//            classNames.addAll(ext);
//            map.put("className", classNamesMap);
//            map.put("methodNames", methodDecs);
//            map.put("formalParameter", formalParameters);
//            map.put("methodInvocation", methodCalls);
//            map.put("memberReference", memberReference);
//            map.put("documentation", comments);
//            map.put("packageName", packageName);
//            map.put("literal", literals);
//            map.put("classNameExt", classNames);
//

            String json = new ObjectMapper().writeValueAsString(map.asMap());
            System.out.println(json);
        }catch (java.io.FileNotFoundException ex){
            System.err.print(ex);

        }catch (Exception ex){

            Map map = new HashMap();
//            map.put("", "");
//            map.put("methodNames", "");
//            map.put("formalParameter", "");
//            map.put("methodInvocation", "");
//            map.put("memberReference", "");
//            map.put("documentation", "");
//            map.put("packageName", "");
//            map.put("literal", "");
//            map.put("classNameExt", "");

            String json = new ObjectMapper().writeValueAsString(map);
            System.out.println(json);
        }
    }

}

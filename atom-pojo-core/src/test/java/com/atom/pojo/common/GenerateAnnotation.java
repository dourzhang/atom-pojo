package com.atom.pojo.common;

import java.io.File;
import java.lang.reflect.Field;

/**
 * mybatis生成注解类
 *
 * @author haoge
 */
public class GenerateAnnotation {

    public static void main(String[] args) throws Exception {
        String className = "com.atom.pojo.model.Pojo";
        generator(className);
    }

    /**
     * 生成语句并输出
     *
     * @param className
     * @throws Exception
     */
    public static void generator(String className) throws Exception {
        System.out.println("插入语句:");
        System.out.println("================================================================================");
        generateInsertAnnotation(className);
        System.out.println("================================================================================");
        System.out.println("更新语句:");
        System.out.println("================================================================================");
        generateUpdateAnnotation(className);
        System.out.println("================================================================================");
        System.out.println("查询语句:");
        System.out.println("================================================================================");
        generateSelectAnnotation(className);
        System.out.println("================================================================================");
        generateDeleteAnnotation(className);
        System.out.println("================================================================================");
    }

    public static void generateDeleteAnnotation(String clzName) throws Exception {
        Class<?> clz = Class.forName(clzName);
        String className = clz.getSimpleName();
        String tableName = camelToUnderline(className);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Delete(");
        stringBuilder.append("\"");
        stringBuilder.append("delete from ");
        stringBuilder.append(tableName);


        stringBuilder.append(" where id=#{");


        stringBuilder.append(convertFirstCharacterLower(className));
        stringBuilder.append(".id}");
        stringBuilder.append("\"");
        stringBuilder.append(")");
        System.out.println(stringBuilder.toString());
    }

    public static void generateSelectAnnotation(String clzName) throws Exception {

        Class<?> clz = Class.forName(clzName);
        String className = clz.getSimpleName();
        String tableName = camelToUnderline(className);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Select(");
        stringBuilder.append("\"");
        stringBuilder.append("select ");
        Field[] fields = clz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String columnName = fields[i].getName();

            if (!isAcronym(columnName)) {
                stringBuilder.append(camelToUnderline(columnName));
                stringBuilder.append(" as ");
                stringBuilder.append(convertFirstCharacterLower(columnName));


            } else {
                stringBuilder.append(camelToUnderline(columnName));
            }
            if (i < fields.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" from ");
        stringBuilder.append(tableName);
        stringBuilder.append(" where id=#{");


        stringBuilder.append(convertFirstCharacterLower(className));
        stringBuilder.append(".id}");
        stringBuilder.append("\"");
        stringBuilder.append(")");
        stringBuilder.append("\r\n");
        stringBuilder.append("@SelectKey(before=false,keyProperty=\"" + convertFirstCharacterLower(className) + ".id\",resultType=Long.class,statementType= StatementType.STATEMENT,statement=\"SELECT LAST_INSERT_ID() AS id\"");
        stringBuilder.append(")");
        System.out.println(stringBuilder.toString());
    }

    /**
     * 为类生成update注解语句
     *
     * @param clzName
     * @throws Exception
     */
    public static void generateUpdateAnnotation(String clzName) throws Exception {
        Class<?> clz = Class.forName(clzName);
        String className = clz.getSimpleName();
        String tableName = camelToUnderline(className);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Update(");
        stringBuilder.append("\"");
        stringBuilder.append("update ");
        stringBuilder.append(tableName);
        stringBuilder.append(" set ");
        Field[] fields = clz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String columnName = fields[i].getName();
            if (columnName.equals("id")) {
                continue;
            }
            stringBuilder.append(camelToUnderline(columnName));
            stringBuilder.append("=#{");
            stringBuilder.append(convertFirstCharacterLower(className));
            stringBuilder.append(".");
            stringBuilder.append(columnName);
            stringBuilder.append("}");
            if (i < fields.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" where id=#{");
        stringBuilder.append(convertFirstCharacterLower(className));
        stringBuilder.append(".id}");
        stringBuilder.append("\"");
        stringBuilder.append(")");
        System.out.println(stringBuilder.toString());
    }

    /**
     * 为类生成insert注解语句
     *
     * @param clzName
     * @throws Exception
     */
    public static void generateInsertAnnotation(String clzName) throws Exception {
        Class<?> clz = Class.forName(clzName);
        String className = clz.getSimpleName();
        String tableName = camelToUnderline(className);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Insert(");
        stringBuilder.append("\"");
        stringBuilder.append("insert into ");
        stringBuilder.append(tableName);
        stringBuilder.append("(");

        Field[] fields = clz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String columnName = fields[i].getName();
            if (columnName.equals("id")) {
                continue;
            }
            stringBuilder.append(camelToUnderline(columnName));
            if (i < fields.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        stringBuilder.append(" values (");
        for (int i = 0; i < fields.length; i++) {

            String columnName = fields[i].getName();
            if (columnName.equals("id")) {
                continue;
            }
            stringBuilder.append("#{");
            stringBuilder.append(convertFirstCharacterLower(className));
            stringBuilder.append(".");
            stringBuilder.append(columnName);
            stringBuilder.append("}");
            if (i < fields.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        stringBuilder.append("\")");
        stringBuilder.append("\r\n");
        stringBuilder.append("@SelectKey(before=false,keyProperty=\"" + convertFirstCharacterLower(className) + ".id\",resultType=Long.class,statementType= StatementType.STATEMENT,statement=\"SELECT LAST_INSERT_ID() AS id\"");
        stringBuilder.append(")");
        System.out.println(stringBuilder.toString());
    }

    /**
     * 将字符串转化成小写,并以"_"分割
     *
     * @param param
     * @return
     */
    public static String camelToUnderline(String param) {
        char UNDERLINE = '_';
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i != 0) {
                    sb.append(UNDERLINE);
                }
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串首字母转化成小写
     *
     * @param param
     * @return
     */
    public static String convertFirstCharacterLower(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (i == 0) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 递归文件夹下文件
     *
     * @param path
     */
    public static void traverseFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        traverseFolder(file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());

                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    public static boolean isAcronym(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}

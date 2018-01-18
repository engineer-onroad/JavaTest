package com.java.javassist.test;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wudi06 on 2018/1/11.
 */
public class HelloTest {
	
    private static  final Logger logger= LoggerFactory.getLogger(HelloTest.class);

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
       /* ClassClassPath classPath = new ClassClassPath(Hello.class);
        pool.insertClassPath(classPath);*/
        CtClass cc = pool.get("com.java.javassist.test.Hello");
        CtMethod m = cc.getDeclaredMethod("say");
        m.insertBefore("{ System.out.println(\"Hello.say():\"); }");
        Class c = cc.toClass();
        Hello h = (Hello)c.newInstance();
        h.say();
        logger.info("it's end");
    }
}

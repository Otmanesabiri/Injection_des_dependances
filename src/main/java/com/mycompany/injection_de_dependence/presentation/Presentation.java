package com.mycompany.injection_de_dependence.presentation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mycompany.injection_de_dependence.dao.DaoImpl;
import com.mycompany.injection_de_dependence.dao.IDao;
import com.mycompany.injection_de_dependence.metier.IMetier;
import com.mycompany.injection_de_dependence.metier.MetierImpl;

public class Presentation {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        System.out.println("Injection Statique");
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao);
        metier.setDao(dao);
        System.out.println("Resultat=" + metier.calcul());

        System.out.println("Injection Dynamique");
        List<String> lines = Files.readAllLines(Paths.get("config.txt"));
        String daoClassName = lines.get(0);
        String metierClassName = lines.get(1);

        Class<?> cDao = Class.forName(daoClassName);
        Class<?> cMetier = Class.forName(metierClassName);

        IDao dao1 = (IDao) cDao.getDeclaredConstructor().newInstance();
        IMetier metier1 = (IMetier) cMetier.getDeclaredConstructor().newInstance();

        Method setDao = cMetier.getMethod("setDao", IDao.class);
        setDao.invoke(metier1, dao1);

        System.out.println("Resultat=" + metier1.calcul());

        System.out.println("Injection par Spring XML");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml")) {
            IMetier metier2 = (IMetier) context.getBean("metier");
            System.out.println("Resultat=" + metier2.calcul());
        }

        System.out.println("Injection par Spring Annotation");
        try (AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext("com.mycompany.ijection_de_dependence")) {
            IMetier metier3 = (IMetier) context1.getBean("metier");
            System.out.println("Resultat=" + metier3.calcul());
        }
    }
}

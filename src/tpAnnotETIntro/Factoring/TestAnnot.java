package src.tpAnnotETIntro.Factoring;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class TestAnnot{
    public static void main(String[] args) throws Exception {

        if (args.length == 0){
            System.out.println("Il faut fournir le nom d'une classe en argument");
            return;
        }

        int totalAnnotations = 0;
        int totalAnnotMethodes = 0;
        int totalAnnotClasses = 0;
        int totalAnnotAttributs = 0;
        Class c = Class.forName(args[0]);

        //Annotation sur les méthodes

        for (Method m : c.getDeclaredMethods()){
            if (m.isAnnotationPresent(OpFactoring.class) || m.isAnnotationPresent(OpFactorings.class)){ // Selon si on utilise @OpFactoring ou @OpFactorings dans le cas de plusieurs annotations
                totalAnnotations++;
                totalAnnotMethodes++;
            }
            else {
                System.out.println("La méthode "+m.getName()+" n'est pas annotée");
            }
        }

        //Annotation sur la classe
        if (c.isAnnotationPresent(OpFactoring.class) || c.isAnnotationPresent(OpFactorings.class)){ // Selon si on utilise @OpFactoring ou @OpFactorings dans le cas de plusieurs annotations
            totalAnnotations++;
            totalAnnotClasses++;
        }
        else {
            System.out.println("La classe "+c.getName()+" n'est pas annotée");
        }

        //Annotation sur les attributs
        for (Field f : c.getDeclaredFields()){
            if (f.isAnnotationPresent(OpFactorings.class) || f.isAnnotationPresent(OpFactoring.class)){ // Selon si on utilise @OpFactoring ou @OpFactorings dans le cas de plusieurs annotations
                totalAnnotations++;
                totalAnnotAttributs++;
            }
            else {
                System.out.println("L'attribut "+f.getName()+" n'est pas annoté");
            }
        }

        System.out.println("Total annotations methodes : "+totalAnnotMethodes);
        System.out.println("Total annotations classes : "+totalAnnotClasses);
        System.out.println("Total annotations attributs : "+totalAnnotAttributs);
        System.out.println("Total annotations : "+totalAnnotations);

    }
}
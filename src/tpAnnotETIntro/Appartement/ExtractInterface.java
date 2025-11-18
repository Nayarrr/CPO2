package src.tpAnnotETIntro.Appartement;

import java.lang.reflect.*;
import java.util.*;

public class ExtractInterface {
    
    public static void main(String[] args) throws Exception {
        if (args.length == 0){
            System.out.println("Il faut fournir le nom d'une classe en argument");
            return;
        }

        Class c = Class.forName(args[0]);
        String interfaceCode = genererCodeInterface(c);
        System.out.println(interfaceCode);
    }

    private static String genererCodeInterface(Class c) {
        StringBuilder sb = new StringBuilder();

        sb.append("public interface I").append(c.getSimpleName());

        List<String> extendsInterfaces = new ArrayList<>();

        Class superClasse = c.getSuperclass(); // UNE SEULE classe possible
        if (superClasse != null && !superClasse.equals(Object.class)) {
            extendsInterfaces.add("I" + superClasse.getSimpleName());
        } else if (superClasse != null && superClasse.equals(Object.class)) {
            extendsInterfaces.add("IObject");
        }


        Class[] interfaces = c.getInterfaces(); // PLUSIEURS interfaces possibles
        for (Class inter : interfaces) {
            extendsInterfaces.add(inter.getSimpleName());
        }

        if (!extendsInterfaces.isEmpty()) {
            sb.append(" extends ").append(String.join(", ", extendsInterfaces));
        }

        sb.append(" {\n");


        // Recuperer les noms des methodes du parent
        List<String> methodesParent = new ArrayList<>();
        if (superClasse != null) {
            for (Method m : superClasse.getDeclaredMethods()) {
                int mod = m.getModifiers();
                if (Modifier.isPublic(mod) && !Modifier.isStatic(mod)) {
                    methodesParent.add(getSignatureMethode(m));
                }
            }
        }

        // Ajouter les methodes de la classe
        Method[] methodes = c.getDeclaredMethods();
        for (Method m : methodes) {
            int mod = m.getModifiers();
            
            if (Modifier.isPublic(mod) && !Modifier.isStatic(mod)) {
                String sig = getSignatureMethode(m);
                
                if (!methodesParent.contains(sig)) {
                    sb.append("    ");
                    sb.append(genererSignatureMethode(m));
                    sb.append(";\n");
                }
            }
        }

        sb.append("}\n");
        return sb.toString();
    }

    private static String getSignatureMethode(Method m) {
        StringBuilder sign = new StringBuilder();
        sign.append(m.getName()).append("(");
        
        Class[] params = m.getParameterTypes();
        for (int i = 0; i < params.length; i++) {
            sign.append(params[i].getName());
            if (i < params.length - 1) {
                sign.append(",");
            }
        }
        sign.append(")");
        
        return sign.toString();
    }

    private static String genererSignatureMethode(Method m) {
        StringBuilder s = new StringBuilder();
        
        s.append(m.getReturnType().getSimpleName());
        s.append(" ");
        s.append(m.getName());
        s.append("(");
        
        Class[] params = m.getParameterTypes();
        for (int i = 0; i < params.length; i++) {
            s.append(params[i].getSimpleName());
            s.append(" p").append(i);
            if (i < params.length - 1) {
                s.append(", ");
            }
        }
        
        s.append(")");
        
        return s.toString();
    }
    

}

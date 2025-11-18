import java.lang.reflect.*;
import java.util.Scanner;

public class TestReflexion{
    public static void afficheSignaturesMethodes(Class cl){
        Method[] methodes = cl.getMethods();
        for (int i=0; i<methodes.length; i++){
            Method m = methodes[i];
            String m_name = m.getName();
            Class m_returnType = m.getReturnType();
            Class[] m_paramTypes = m.getParameterTypes();
            System.out.print(" "+m_returnType.getName()+ " "+m_name + "(");
            for (int j=0; j<m_paramTypes.length; j++){
                System.out.print(""+ m_paramTypes[j].getName());
                System.out.println(")");
            }
        }
    }

    public static void main(String[] argv) throws java.lang.ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {
        // System.out.println("Saisir un nom de classe");
        // Scanner s = new Scanner(System.in);
        // String nomClasse = s.next();
        // Class c = Class.forName(nomClasse);
        // TestReflexion. afficheSignaturesMethodes(c);
        Livre l = new Livre("X23","Paroles de Prévert",25,"Folio");
        Class p = l.getClass();
        System.out.println(l.getClass());
        Field f = p.getField("editeur");
        System.out.println(f);
        Constructor c = p.getConstructor();
        System.out.println(c);

        
    }
}
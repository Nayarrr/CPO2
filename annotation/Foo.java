public class Foo{
    @Test(risque=NiveauRisque.faible)
        public static void m1() {System.out.println("m1");}
    public static void m2() {System.out.println("m2");}
    @Test(risque=NiveauRisque.moyen)
        public static void m3() {throw new RuntimeException("Boom");}
    public static void m4() {System.out.println("m4");}
    @Test(risque=NiveauRisque.moyen)
        public static void m5() {System.out.println("m5");}
    public static void m6() {System.out.println("m6");}
    @Test(risque=NiveauRisque.eleve)
        public static void m7() {throw new RuntimeException("Crash");}
    public static void m8() {System.out.println("m7");}
}


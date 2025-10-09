package src.tpAnnotETIntro.Factoring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Repeatable(OpFactorings.class)
public @interface OpFactoring {
    String nomP();
    RefactoringName nomRefact();
    String commentaire();
    boolean isEclipse();
    int nbrCas();
} 
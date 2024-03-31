import java.lang.annotation.Repeatable;

@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String value() default "something";
}

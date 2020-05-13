package algorithm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author onion
 * @date 2020/4/27 -3:52 下午
 */
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface AnotherSolution {
    String complexity() default "";
}

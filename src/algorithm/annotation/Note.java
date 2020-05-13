package algorithm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author onion
 * @date 2020/4/27 -10:59 上午
 */
@Target(ElementType.METHOD)
public @interface Note {
    String value();
}

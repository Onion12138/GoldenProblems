package algorithm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author onion
 * @date 2020/4/27 -10:55 上午
 */
@Target(ElementType.TYPE)
public @interface Similar {
    String value();
}

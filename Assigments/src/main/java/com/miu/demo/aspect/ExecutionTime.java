package com.miu.demo.aspect.annotation;
import java.lang.annotation.*;

@Target(ElementType.METHOD) // Метод дээр ашиглах боломжтой
@Retention(RetentionPolicy.RUNTIME) // Runtime дээр хадгалагдана
public @interface ExecutionTime {
}

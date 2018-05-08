/*
 * Copyright 2017-2018 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.micronaut.context.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Allows specifying an annotation member alias. In other words, a value of an annotation member can be used to
 * represent the value of another annotation's member or a another member within the same annotation.</p>
 * <p>
 * <p>The representation is constructed via the {@link io.micronaut.core.annotation.AnnotationMetadata} interface</p>
 *
 * @author Graeme Rocher
 * @see io.micronaut.core.annotation.AnnotationMetadata
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface AliasFor {

    /**
     * Used to declare aliases of members within the current annotation.
     *
     * @return The alias
     */
    String value() default "";

    /**
     * @return The name of the member that <code>this</code> member is an alias for
     */
    String member() default "";

    /**
     * @return The type of annotation in which the aliased {@link #member()} is declared.
     * If not specified the alias is applied to the current annotation.
     */
    Class<? extends Annotation> annotation() default Annotation.class;
}

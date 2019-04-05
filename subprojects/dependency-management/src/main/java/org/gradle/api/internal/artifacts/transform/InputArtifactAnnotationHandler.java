/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.artifacts.transform;

import com.google.common.collect.ImmutableSet;
import org.gradle.api.artifacts.transform.InputArtifact;
import org.gradle.api.internal.tasks.properties.InputFilePropertyType;
import org.gradle.api.internal.tasks.properties.annotations.AbstractInputFilePropertyAnnotationHandler;
import org.gradle.api.tasks.Classpath;
import org.gradle.api.tasks.CompileClasspath;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.internal.instantiation.InjectAnnotationHandler;
import org.gradle.work.Incremental;

import java.lang.annotation.Annotation;

public class InputArtifactAnnotationHandler extends AbstractInputFilePropertyAnnotationHandler implements InjectAnnotationHandler {
    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return InputArtifact.class;
    }

    @Override
    public ImmutableSet<Class<? extends Annotation>> getAllowedModifiers() {
        return ImmutableSet.of(
            Classpath.class,
            CompileClasspath.class,
            Incremental.class,
            PathSensitive.class
        );
    }

    @Override
    protected InputFilePropertyType getFilePropertyType() {
        return InputFilePropertyType.FILE;
    }
}

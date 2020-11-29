package com.shijingfeng.apt_processor;

import com.google.auto.service.AutoService;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

/**
 * Function:
 * Date: 2020/11/29 18:31
 * Description:
 *
 * @author ShiJingFeng
 */
@AutoService(Processor.class)
public class ProcessorJava extends AbstractProcessor {

    private Messager mMessager;
    private Filer mFiler;
    private Elements mElements;
    private Types mTypes;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mMessager = processingEnv.getMessager();
        mFiler = processingEnv.getFiler();
        mElements = processingEnv.getElementUtils();
        mTypes = processingEnv.getTypeUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations != null && !annotations.isEmpty()) {
            final StringBuilder stringBuilder = new StringBuilder();

            for (TypeElement element : annotations) {
                stringBuilder.append(element.getSimpleName());
                stringBuilder.append(", ");
            }
            printError("要执行的注解列表: " + stringBuilder.toString());
        } else {
            printError("要注解的注册列表: null");
        }
        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }

    private void printError(String error) {
        if (!"".equals(error)) {
            mMessager.printMessage(Diagnostic.Kind.ERROR, error);
        }
    }

}

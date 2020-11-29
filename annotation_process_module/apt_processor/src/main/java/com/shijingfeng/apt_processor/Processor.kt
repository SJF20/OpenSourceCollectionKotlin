package com.shijingfeng.apt_processor
//
////import com.google.auto.service.AutoService
//import com.shijingfeng.apt_annotation.ModuleDispatcher
//import javax.annotation.processing.*
//import javax.lang.model.SourceVersion
//import javax.lang.model.element.TypeElement
//import javax.lang.model.util.Elements
//import javax.lang.model.util.Types
//import javax.tools.Diagnostic
//
///**
// * Function: 注解执行器
// * Date: 2020/11/29 16:33
// * Description:
// * @author ShiJingFeng
// */
//@AutoService
//class Processor : AbstractProcessor() {
//
//    private var mMessager: Messager? = null
//    private var mFiler: Filer? = null
//    private var mElements: Elements? = null
//    private var mTypes: Types? = null
//
//    /**
//     * 初始化回调
//     */
//    override fun init(processingEnv: ProcessingEnvironment?) {
//        super.init(processingEnv)
//        processingEnv?.run {
//            mMessager = messager
//            mFiler = filer
//            mElements = elementUtils
//            mTypes = typeUtils
//        }
//    }
//
//    /**
//     * 执行回调
//     *
//     * @return true: 后续的注解执行器 就不会处理 当前注解执行器中指定的这些注解
//     */
//    override fun process(
//        annotations: MutableSet<out TypeElement>?,
//        roundEnv: RoundEnvironment?
//    ): Boolean {
//        printError("要执行的注解列表: ${annotations?.joinToString(",") { it.simpleName } ?: "null"}")
//        roundEnv?.getElementsAnnotatedWith(ModuleDispatcher::class.java)?.forEach { element ->
//            printError("Element名称: ${element.simpleName}")
//            printError("EnclosingElement名称: ${element.enclosingElement?.simpleName ?: "null"}")
//            printError("EnclosedElements名称: ${element.enclosedElements?.joinToString(",") { it.simpleName } ?: "null"}")
//
//            printError("模块名: ${element?.enclosingElement?.enclosingElement?.simpleName ?: "null"}")
//            printError("包名: ${mElements?.getPackageOf(element)?.qualifiedName ?: "null"}")
//        }
//        return true
//    }
//
//    /**
//     * 设置支持的Java版本名称
//     */
//    override fun getSupportedSourceVersion() = SourceVersion.RELEASE_8
//
//    /**
//     * 设置支持的 注解类型全限定名称 集合
//     */
//    override fun getSupportedAnnotationTypes() = setOf(ModuleDispatcher::class.qualifiedName!!)
//
//    private fun printError(error: String) {
//        if (error.isNotEmpty()) {
//            mMessager?.printMessage(Diagnostic.Kind.ERROR, error)
//        }
//    }
//}
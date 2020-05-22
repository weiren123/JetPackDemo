# 自定义注解 #
## 自动产生随机数字和随机字符串##
- @Target 该注解所能修饰的元素类型，可选类型如下：
		
		public enum ElementType {
			TYPE, //类
			FIELD, //属性
			METHOD, //方法
			PARAMETER, //参数
			CONSTRUCTOR, //构造函数
			LOCAL_VARIABLE,
			ANNOTATION_TYPE,
			PACKAGE,
			TYPE_PARAMETER,
			TYPE_USE;
			private ElementType() {
			}
		}
- @Retention 该注解的保留策略，有三种选项：
		
		public enum RetentionPolicy {
		SOURCE, //被编译器所忽略
		CLASS, //被编译器保留至类文件，但不会保留至运行时
		RUNTIME //保留至类文件，且保留至运行时，能在运行时反射该注解修饰的对象
		}
一：创建注解处理器继承AbstractProcessor接口，实现相应方法：
- init() 可选 在该方法中可以获取到 processingEnvironment 对象，借由该
对象可以获取到生成代码的文件对象, debug 输出对象，以及一些相关工
具类
- getSupportedSourceVersion() 返回所支持的 java 版本，一般返回当前
所支持的最新 java 版本即可
- getSupportedAnnotationTypes() 你所需要处理的所有注解，该方法的
返回值会被 process() 方法所接收
- process() 必须实现 扫描所有被注解的元素，并作处理，最后生成文件。
该方法的返回值为 boolean 类型，若返回 true,则代表本次处理的注解已
经都被处理，不希望下一个注解处理器继续处理，否则下一个注解处理器
会继续处理。
	

[RandomInt]

com.wmj.lib_annotations.RandomInt ： []

com.wmj.lib_annotations.RandomInt ： [AnnotateRandomInt]
> createConstructor(AnnotateRandomInt):
>> Public AnnotateRandomInt(AnnotateRandomInt target){
>> target.minValue = **;
>> target.mRandomString = **;}
>
> createClass():
>> public final class MainActivity_Random{}

>JavaFile.builder():
>> package com.wmj.jetpackdemo;
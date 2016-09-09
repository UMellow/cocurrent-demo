package demo.javaapi;

/**
 * 一个类说明Java泛型的使用.
 * 
 * 类定义中的A，无特殊意义，不会关联到具体的其它类，仅表明在创建该类的实例时需要加入泛型.
 * 在JDK中，经常会看到E、T、K、V、N、? 的写法，它们也是语义化的东西：
 * 
 * E：Element，在集合中使用，因为集合中存放的是元素；
 * T：Type，Java类；
 * K：Key，键；
 * V：Value，值；
 * N：Number，数值类型；
 * ?：任意类型
 * 
 * @author zhaoyi 
 * @date 2016年9月9日 下午2:32:02 
 * @param <A>
 */
public class GenericTest<A> {

	@SuppressWarnings("unchecked")
	public A getX() {
		// 泛型类型A将自动转型为String
		return (A) "Something";
	}
	
	/**
	 * 注意：该方法参数中使用泛型类型T，但在该类中并未定义该泛型类型，
	 * 因此需在方法定义中添加对该类型的声明<T>，否则编译报错
	 */
	public <T> void y(T t) {
		System.out.println(t.getClass().getName());
	}
	
	
	
}

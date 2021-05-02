package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import practice.SingletonClass;

//Overcome reflection issue: To overcome issue raised by reflection, enums are used because java ensures internally that enum value is instantiated only once. Since java Enums are globally accessible, they can be used for singletons. Its only drawback is that it is not flexible i.e it does not allow lazy initialization.
public class BreakSingletonUsingReflection {

	public static void main(String[] args) {
		SingletonClass instance1 = SingletonClass.getInstance();
		SingletonClass instance2 = null;
		Constructor[] constructors = SingletonClass.class
				.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			try {
				instance2 = (SingletonClass) constructor.newInstance();
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			break;
		}
		System.out.println("instance1.hashCode():" + instance1.hashCode());
		System.out.println("instance2.hashCode():" + instance2.hashCode());

	}
}
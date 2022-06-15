### 1. 单例模式
1. 饿汉模式
	- 饿汉模式推荐使用
	- 缺点：不管类使用与否，都进行了加载。  
	- [直达链接](./src/main/java/com/dliberty/demo/singleton/Mgr01.java)
2. 懒汉模式
	- 懒汉模式，使用时加载，线程不安全。
	- [直达链接](./src/main/java/com/dliberty/demo/singleton/Mgr02.java)
3. 懒汉模式加锁
	- 懒汉模式，在方法上面加synchronize
	- 缺点：效率低
	- [直达链接](./src/main/java/com/dliberty/demo/singleton/Mgr03.java)
4. 懒汉模式双重锁判断，减轻锁力度
	- 懒汉模式，在方法内部加锁
	- 需要双重判断
	- INSTANCE实例需要加volatile关键字，防止指令重排序
	- [直达链接](./src/main/java/com/dliberty/demo/singleton/Mgr04.java)
5. 静态内部类方式
	- 静态内部类方式，jvm 加载外部类的时候不会加载内部类，这样可以实现懒加载
	- [直达链接](./src/main/java/com/dliberty/demo/singleton/Mgr05.java)
6. 枚举方式
	- 枚举方式，jvm 保证单例，可以预防反序列化
	- [直达链接](./src/main/java/com/dliberty/demo/singleton/Mgr06.java)

### 2. 策略模式
- 策略模式也就是面向对象编程中的多态
- 制定统一的接口，根据不同的策略来进行实现
- [直达链接](./src/main/java/com/dliberty/demo/strategy/Test.java)
### 3. 工厂方法模式
### 4. 抽象方法模式
### 5. 门面模式
### 6. 调停者模式
### 7. 装饰器模式
### 8. 责任链模式
### 9. 观察者模式
### 10. 组合模式
### 11. 享元模式
### 12. 代理模式
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
- 内部系统错综复杂，提供一个门面统一对外服务
- 服务器部署时的网关，将所有的请求拦截，具体的方法转发由网关决定
### 6. 调停者模式
- 内部系统错综复杂，提供一个对内的协调中间件
- 消息队列，zookeeper等
### 7. 装饰器模式
### 8. 责任链模式
### 9. 观察者模式
### 10. 组合模式
### 11. 享元模式
- 共享元对象模式
- String 常量池，Integer 常量池，线程池等
- [直达链接](./src/main/java/com/dliberty/demo/flyweight/Test.java)
### 12. 代理模式
1. 静态代理
	- 静态代理从逻辑上将和装饰器模式一样
	- [直达链接](./src/main/java/com/dliberty/demo/proxy/Test.java)
2. 动态代理
	- jdkProxy 必须面向接口，可将动态生成的代理类进行保存反编译
	- [直达链接](./src/main/java/com/dliberty/demo/proxy/JdkProxy.java)
	- [动态代理类直达链接](./com/dliberty/demo/proxy/$Proxy0.class)
	- cglib 生成一个被代理类的子类，如果被代理类是final的话则无法生成，jdkproxy可以
	- [直达链接](./src/main/java/com/dliberty/demo/proxy/Cglib.java)
	- jdkProxy和cglib的底层都是asm，对二进制文件进行修改
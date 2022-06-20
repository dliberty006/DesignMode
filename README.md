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
1. 装饰器模式实现步骤
	a. 定义一个接口Animal，一个方法run
	b. 定义一个具体的装饰对象Dog，继承自Animal，实现自己的run方法
	c. 定义一个通用装饰器类AnimalDecorator，继承自Animal，定义一个成员变量Animal，有参构造方法，重写run方法，在run方法里面调用成员变量Animal的run方法
	d. 定义一个具体装饰器DogDecorator,继承自AnimalDecorator，重新run方法，在run方法里面调用super.run
	e. 调用super.run 的前后可加上自定义装饰代码
2. 主要优点：
	- 装饰器是继承的有力补充，比继承灵活，在不改变原有对象的情况下，动态的给一个对象扩展功能，即插即用
	- 通过使用装饰类及这些装饰类的排列组合，可以实现不同效果
	- 装饰器模式完全遵守开闭原则
3. 主要缺点：
	- 会出现更多的代码、更多的类，增加程序的复杂性
4. [直达链接](./src/main/java/com/dliberty/demo/decorator/Test.java)

### 8. 责任链模式
- 避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。
- 类似于过滤器，将所有过滤器串成一条链，逐条进行过滤
- [直达链接](./src/main/java/com/dliberty/demo/chain_of_responsibility/Test.java)
- request->1->2->3->response->3->2->1 双向模式[直达链接](./src/main/java/com/dliberty/demo/chain_of_responsibility/filter/Test.java)

### 9. 观察者模式
1. 事件源对象，被观察者
2. 观察者对象
3. event 事件对象
4. 在被观察者里面动态封装观察者集合
5. 在被观察者触发指定事件的同时通知不同的观察者，并且发送event事件对象
6. event 会封装被观察者本身
7. [直达链接](./src/main/java/com/dliberty/demo/observer/Test.java)

### 10. 组合模式
- 树状结构常用设计模式
- [直达链接](./src/main/java/com/dliberty/demo/composite/Test.java)

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
	
### 13. Iterator模式
- 模拟ArrayList和LinkedList的迭代器
- [直达链接](./src/main/java/com/dliberty/demo/iterator/Test.java)

### 14. visitor访问者模式
- 在结构不变的情况下动态改变对于内部元素的动作
- 决策方案在访问者实现
- [直达链接](./src/main/java/com/dliberty/demo/visitor/Test.java)

### 15. Builder 构造器
- 分离复杂对象的构建和标识
- [直达链接](./src/main/java/com/dliberty/demo/builder/Test.java)

### 16. Adapter适配器模式

### 17. Bridge桥接模式

### 18. Command命令模式

### 19. prototype原型模式

### 20. memento备忘录模式

### 21. TemplateMethod模板方法模式

### 22. State状态模式

### 23. Intepreter解释器模式
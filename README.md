# How to reproduce

* Set the `JAVA_9` environment variable to your JDK 9 installation path
* run `git clone https://github.com/melix/repro-cglib-bug-jdk9.git`
* `cd repro-cglib-bug-jdk9`
* `./gradlew test`

The test will fail with the following exception:

```
Caused by: java.lang.IllegalArgumentException
	at net.sf.cglib.proxy.BridgeMethodResolver.resolveAll(BridgeMethodResolver.java:63)
	at net.sf.cglib.proxy.Enhancer.emitMethods(Enhancer.java:1132)
	at net.sf.cglib.proxy.Enhancer.generateClass(Enhancer.java:630)
	at net.sf.cglib.core.DefaultGeneratorStrategy.generate(DefaultGeneratorStrategy.java:25)
	at net.sf.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:329)
	at net.sf.cglib.proxy.Enhancer.generate(Enhancer.java:492)
	at net.sf.cglib.core.AbstractClassGenerator$ClassLoaderData$3.apply(AbstractClassGenerator.java:93)
	at net.sf.cglib.core.AbstractClassGenerator$ClassLoaderData$3.apply(AbstractClassGenerator.java:91)
	at net.sf.cglib.core.internal.LoadingCache$2.call(LoadingCache.java:54)
	at java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at net.sf.cglib.core.internal.LoadingCache.createEntry(LoadingCache.java:61)
	at net.sf.cglib.core.internal.LoadingCache.get(LoadingCache.java:34)
	at net.sf.cglib.core.AbstractClassGenerator$ClassLoaderData.get(AbstractClassGenerator.java:116)
	at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:291)
	at net.sf.cglib.proxy.Enhancer.createHelper(Enhancer.java:480)
	at net.sf.cglib.proxy.Enhancer.createClass(Enhancer.java:337)
	at org.spockframework.mock.runtime.ProxyBasedMockFactory$CglibMockFactory.createMock(ProxyBasedMockFactory.java:91)
	at org.spockframework.mock.runtime.ProxyBasedMockFactory.create(ProxyBasedMockFactory.java:49)
	at org.spockframework.mock.runtime.JavaMockFactory.create(JavaMockFactory.java:51)
	at org.spockframework.mock.runtime.CompositeMockFactory.create(CompositeMockFactory.java:44)
	at org.spockframework.lang.SpecInternals.createMock(SpecInternals.java:45)
	at org.spockframework.lang.SpecInternals.createMockImpl(SpecInternals.java:281)
	at org.spockframework.lang.SpecInternals.MockImpl(SpecInternals.java:83)
	at jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at ReproSpec.should not throw IllegalArgumentException(ReproSpec.groovy:6)
```



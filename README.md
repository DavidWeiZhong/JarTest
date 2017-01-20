# JarTest
将一个moudle整体打成jar，这样就不存在什么资源文件不能打成jar包的情况了



好吧，先来讲一下步骤吧，jar（Jar Archive,jar文档）我们有的时候想要把什么资源文件，还有一些什么assert文件，xml文件也一并打包进jar中
但是一般的步骤是不可以的，只能打包进一些java代码，在Android Studio中打包一个moudle为jar包就显得尤为重要

#步骤


1，新建一个工程就不用将了吧，在新建的工程中新建一个Moudle，名字就叫做MyLibrary吧，注意要选择library这个才可以哦，鉴定一个Moudle是application还是library，主要看

moudle中的build.gradle中的开头部分


apply plugin: 'com.android.application'//为application ,相应的library就为library了


2，要在你的MyLibrary中新建一个类，什么类都好，方便测试，在类中写一个静态方法就可以了，接下来，就是一些可视化的操作了



3，打开MyLIbrary下的bulid.gradle在最后面加入以下代码，不要问我为什么，这是官网写的

task deleteOldJar(type: Delete) {

    delete 'build/outputs/test.jar'//这行真的是不知道是什么意思
}

task exportJar(type: Copy) {

    from('build/intermediates/bundles/release/')
    into('build/libs/')//生成jar包的位置，可以改
    include('classes.jar')
    rename ('classes.jar', 'test.jar')//test为你生成jar的名字可以改的
}

exportJar.dependsOn(deleteOldJar, build)



4，然后就是在你的Android Studio中的最右面找到Ｇｒａｄｌｅ，然后依次Ｔａｓｋｓ＞ｏｔｈｅｒ＞ｅｘｐｏｒｔＪａｒ，

接下来就是静静的等待了，然后你去你的ｂｕｉｌｄ／ｌｉｂｓ下面就可以看到那个ｔｅｓｔ．ｊａｒ包了

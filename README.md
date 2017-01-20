# JarTest，讲解生成jar包，和生成arr包，引用arr包
将一个moudle整体打成jar,其实也就是一般的jar包，没有支援文件的


好吧，先来讲一下步骤吧，jar（Jar Archive,jar文档）中只能打包进一些java代码，

在Android Studio中打包一个moudle为jar包

#，生成jar包步骤


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



4，然后就是在你的Android Studio中的最右面找到Ｇｒａｄｌｅ，


gradle图标在这里![image](https://github.com/DavidWeiZhong/JarTest/blob/master/Picture/p1.png)


然后依次Ｔａｓｋｓ＞ｏｔｈｅｒ＞ｅｘｐｏｒｔＪａｒ，

接下来就是静静的等待了，然后你去你的ｂｕｉｌｄ／ｌｉｂｓ下面就可以看到那个ｔｅｓｔ．ｊａｒ包了
怎么用jar包就不用我说了吧


#生成arr包，并引用 ，步骤

1，生成arr，新建一个library，在Bulid》ReBulidProject，然后就可以在build》outputs》arr下面看到你生成的arr包了


2，引用，在你的Moudle下面的bulid.gradle中添加
repositories {
    
    flatDir { dirs 'libs' }
}


在再dependencies下添加


compile(name:'jarlibrary-debug.aar', ext:'aar')//写上你的arr包的全名


接下来就是Rebuild Project就可以了，然后可以在app/build/intermediates/exploded-aar看到你引用的arr包，搞定！！！


#ps,怎样在redeme中插入图片呢，


1，首先在你的项目中新建一个文件夹，Picture把你要上传的图片放上去，然后同步到github


2，在github中打开你上传的图片，然后复制下url


3，接下来在github上面编辑你的readme就可以了格式为![image](url),搞定，我想上传gif也差不多吧

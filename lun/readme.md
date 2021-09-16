# lun上传至git

作为一个复习，有很多地方值得复习，也有很多设计上值得多想

lun这个东西只是小东西，所以只是一个面向我自己的复习，但我依旧在这里面复习到了一些知识点，毕竟太久没动手了

只是这么个东西，不用登陆，也不是什么长连接的聊天室，只是不能用户命名重复，甚至连非空都没做

![Untitled](lun%E4%B8%8A%E4%BC%A0%E8%87%B3git%2073e5ebafa10f4a3b953ebd0850cbe3cd/Untitled.png)

前言

在做这个东西的时候，脑子突然想到了这个前端图，就想着把他做出来，对于我这个好久没用thymeleaf和mybatis的人来说，还是需要边做边谷歌，

  首先是前端，先搭起来随便写个数据在上面当框子，把构造写好就写样式，排好了顺便写个ajax

不用完成，能看就行

![Untitled](lun%E4%B8%8A%E4%BC%A0%E8%87%B3git%2073e5ebafa10f4a3b953ebd0850cbe3cd/Untitled%201.png)

这是之前随便写的

  然后是建表，毫无疑问是两个表加个外键就行，其实也可以加个日期

![Untitled](lun%E4%B8%8A%E4%BC%A0%E8%87%B3git%2073e5ebafa10f4a3b953ebd0850cbe3cd/Untitled%202.png)

建表的同时顺便配置创建项目，带web、thymeleaf和mybatis就可以，然后配置数据源、实体类、dao层（因为懒所以写的是注解版），写个index路由测试一下findAllUser

![Untitled](lun%E4%B8%8A%E4%BC%A0%E8%87%B3git%2073e5ebafa10f4a3b953ebd0850cbe3cd/Untitled%203.png)

这是之后的图

然后把html弄进来加th标签，这里**查了下thymeleaf怎么循环**（想当然for结果没找到。。）

![Untitled](lun%E4%B8%8A%E4%BC%A0%E8%87%B3git%2073e5ebafa10f4a3b953ebd0850cbe3cd/Untitled%204.png)

首先是显示全部评论，自己在数据库里生成了几个，然后连上user看下效果，

  之后就是添加评论，添加之前我有个问题就是想用ajax找name，然后再决定是否添加，**结果onsubmit一直不行，各种问题，最后还是弄不了就用了onclick ，**

  这里我想着**找到了相同名字返回什么好**，user和null还是boolean，最后还是用的user或null，

  其实还个坑就是我路由返回boolean但**我怕实际上返回给前端的是string**，所以我一直再想到底怎么判断，最后输出出来看到谷歌浏览器直接右键选中看得到类型，

  还有的是创建用户并返回字段id，之前一直找的是selectKey，结果Options注解一下就好了，

就没了

参考：

idea创建jsp

[为什么一定要用implements Serializable？](https://www.huaweicloud.com/articles/8354077.html) 好像比起实用性更像一个规范

mysql中mybatis用中文做参数加单引号解决 `unknown column in 'where clause'`

onsubmit的我就不写了，没用上

mybatis中$与#的区别

mybatis中创建字段并返回主键

ajax “Maximum call stack size exceeded”栈溢出

```
var a=$("#a").val()
var b=$("#b").val()
console.log(a+b)
```

[使用button按钮配合onclick事件提交表单，或者使用submit按钮配合onsubmit事件提交表单，二者只能选择其中一个。](https://blog.csdn.net/NN_nan/article/details/84980423)

[Mybatis传递多个参数的4种方式](https://blog.csdn.net/moakun/article/details/80057181)

[mybatis注解方式创建字段返回主键](http://www.yayihouse.com/yayishuwu/chapter/1889)，selectKey我就不写了没用上
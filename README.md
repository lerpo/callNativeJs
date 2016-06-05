说明：js调用原生的插件，js要调用的原生功能可自己自定义
安装：ionic plugin add callNativeJs   (也可以用cordova的命令进行安装)
使用：
$scope.popDialog = function(){
    window.callNativeJs.coolMethod("jump","112",function(data){
                                            alert (data);
                                           },function(error){
                                            alert(error);
                                           
                                           });
            };
  参数说明：jump 是我们要传入的方法名，
            112  是我们要传入一些值信息
  我们在原生代码中通过拦截jump方法名，然后通过112这些传进去的值，在原生代码中做我们想做的任何事

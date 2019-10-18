[JavaGuide-RPC](https://snailclimb.top/JavaGuide/#/system-design/data-communication/summary)

## rabbitMQ

[消息队列之 RabbitMQ - 简书](https://www.jianshu.com/p/79ca08116d57)

[Installing on Debian and Ubuntu — RabbitMQ](https://www.rabbitmq.com/install-debian.html#erlang-repositories)

## QA
#### [Spring AMQP + RabbitMQ 3.3.5 ACCESS_REFUSED - Login was refused using authentication mechanism PLAIN - Stack Overflow](https://stackoverflow.com/questions/26811924/spring-amqp-rabbitmq-3-3-5-access-refused-login-was-refused-using-authentica/26820152)
```sh
$ rabbitmqctl add_user guess guess
$ rabbitmqctl set_user_tags guess administrator
$ rabbitmqctl set_permissions -p / guess ".*" ".*" ".*"
```

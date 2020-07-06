import Mock from 'mockjs'

Mock.mock('http://localhost:8001/login', {
    'token': '332fr3e3rfsdfd', //令牌
})

Mock.mock('http://localhost:8080/user', {
    'name': '@name', //隨機生成姓名
    'email': '@email', //隨機生成email
    'age|1-10': 5, //年齡在 1-10 歲之間
})

Mock.mock('http://localhost:8080/menu', {
    'id': '@increment', //id自增
    'name': '@menu', //名稱為menu
    'order|1-20': 5, //排序在 1-20 之間
})




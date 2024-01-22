package com.pn.news.common

object Result {
     private var code: Int? = null // 响应码，1 代表成功; 0 代表失败
     private var msg: String? = null // 响应信息 描述字符串
     var data: Any? = null // 返回的数据

     // 增删改 成功响应
     fun success(): Result {
          code = 1
          msg = "success"
          data = null
          return this
     }

     // 查询 成功响应
     fun success(data: Any?): Result {
          code = 1
          msg = "success"
          Result.data = data
          return this
     }

     // 失败响应
     fun error(msg: String?): Result {
          code = 0
          Result.msg = msg
          data = null
          return this
     }
}

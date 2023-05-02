import request from '@/utils/request'

/**
 * 商家注册
 * @param {Object} params
 */
export function shopRegisterApi(data) {
  return request({
    url: '/front/enterprise/add',
    method: 'post',
    data
  })
}


/**
 * 商家资料重新提交
 * @param {Object} params
 */
export function shopResubmitRegisterApi(data) {
  return request({
    url: '/front/enterprise/update',
    method: 'put',
    data
  })
}



/**
 * 查看商家入住审核申请
 * @param {Object} loginName 手机号
 */
export function processHistoryApi(loginName){
  return request({
      url: '/front/enterprise/process/'+loginName,
      method: 'get'
  })
}

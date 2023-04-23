import request from '@/utils/request'

/**
 * 查询
 * @param {Object} params
 */
export function dataApi(params) {
    return request({
        url: '/api/${entityName?lower_case}/data',
        method: 'get',
        params
    })
}


/**
 * 新增
 * @param {Object} data
 */
export function addApi(data) {
    return request({
        url: '/api/${entityName?lower_case}',
        method: 'post',
        data
    })
}

/**
 * 修改
 * @param {Object} data
 */
export function editApi(data) {
    return request({
        url: '/api/${entityName?lower_case}',
        method: 'put',
        data
    })
}


/** 根据主键查询
 * @param {Object} id
 */
export function findByIdApi(id) {
    return request({
        url: '/api/${entityName?lower_case}/'+id,
        method: 'get'
    })
}

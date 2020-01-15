import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listApply(query) {
  return request({
    url: '/forest/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getApply(orderNo) {
  return request({
    url: '/system/apply/' + orderNo,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addApply(data) {
  return request({
    url: '/system/apply',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateApply(data) {
  return request({
    url: '/system/apply',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delApply(orderNo) {
  return request({
    url: '/system/apply/' + orderNo,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportApply(query) {
  return request({
    url: '/forestExport/export',
    method: 'get',
    params: query
  })
}
import request from '@/utils/request'

export function show() {
    return request({
      url: '/student/show',
      method: 'get',
    })
  }
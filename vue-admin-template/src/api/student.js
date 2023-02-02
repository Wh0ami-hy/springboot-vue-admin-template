import request from '@/utils/request'

export function show() {
    return request({
      url: '/student/show',
      method: 'get',
    })
  }

export function deleted(id) {
  return request({
    url: '/student/deleted/' + id,
    method: 'post',
  })
}

export function update(data) {
  return request({
    url: '/student/update',
    method: 'post',
    data
  })
}

export function insert(data) {
  return request({
    url: '/student/insert',
    method: 'post',
    data
  })
}

export function selected(data) {
  return request({
    url: '/student/selected',
    method: 'post',
    data
  })
}

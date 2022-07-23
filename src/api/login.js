import request from '@/utils/request'

export const userLogin = (data) => {
  return request('/user/login', 'get', data)
}

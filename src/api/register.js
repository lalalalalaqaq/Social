import request from '@/utils/request.js'

export const userRegister = (data) => {
  return request('/user/register', 'get', data)
}

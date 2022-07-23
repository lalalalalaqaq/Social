import store from '@/store'
import axios from 'axios'
import nProgress from 'nprogress'
import 'nprogress/nprogress.css'
import { t } from 'vue-i18n'
import { getToken, setToken, getRefreshToken } from '@/utils/token.js'

let isRefreshing = false
let retryRequest = []

const refreshToken = () => {
  return request.post('/auth/refresh', { refresh_token: getRefreshToken() }, true)
}

const request = axios.create({
  baseURL: process.env.VUE_APP_BASE_API,
  timeout: 5000,
  headers: {
    'Content-Type': 'application/json'
  }
})

request.interceptors.request.use(config => {
  if (store.state.user.profile.token) {
    config.headers.Authorization = `Bearer ${getToken()}`
  }
  nProgress.start()
  return config
})

request.interceptors.response.use(response => {
  nProgress.done()
  return response.data
}, (error) => {
  if (!error.response) {
    return Promise.reject(new Error(error))
  }
  if (error.response.status === 401 && !error.config.url.includes('/user/refresh')) {
    const { config } = error
    if (!isRefreshing) {
      isRefreshing = true
      return refreshToken().then(res => {
        const { token } = res.data
        setToken(token)
        config.headers.Authorization = `Bearer ${token}`
        retryRequest.forEach(reQuest => reQuest(token))
        retryRequest = []
        return request(config)
      }).catch((error) => {
        console.log(t('checkToken'))
        return Promise.reject(error)
      }).finally(() => {
        isRefreshing = false
      })
    } else {
      return new Promise(resolve => {
        retryRequest.push(token => {
          config.headers.Authorization = `Bearer ${token}`
          resolve(request(config))
        })
      })
    }
  }
  return Promise.reject(new Error(error))
})

export default (url, method = 'GET', data) => {
  method = method.toUpperCase()
  return request({
    url,
    method,
    data
  })
}

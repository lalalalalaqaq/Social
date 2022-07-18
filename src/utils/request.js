import store from '@/store'
import axios from 'axios'
import nProgress from 'nprogress'
import 'nprogress/nprogress.css'

const requests = axios.create({
  baseURL: process.env.VUE_APP_BASE_API,
  timeout: 5000
})

requests.interceptors.request.use(config => {
  if (store.state.user.token) {
    config.headers.token = store.state.user.token
  }
  nProgress.start()
  return config
})

requests.interceptors.response.use(response => {
  nProgress.done()
  return response.data
}, (error) => {
  return Promise.reject(new Error(error))
})

export default requests

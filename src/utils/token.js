export const setToken = (value) => {
  localStorage.setItem('social-site-pc-token', value)
}
export const getToken = () => {
  return localStorage.getItem('social-site-pc-token')
}
export const getRefreshToken = () => {
  localStorage.getItem('social-site-pc-token')
}

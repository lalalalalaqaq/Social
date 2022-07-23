import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    redirect: '/register',
    path: '/',
    component: () => import('@/views/register/RegisterPage.vue')
  },
  {
    path: '/login',
    component: () => import('@/views/login/LoginPage.vue')
  }, {
    path: '/register',
    component: () => import('@/views/register/RegisterPage.vue')
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router

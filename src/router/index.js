import { createRouter, createWebHistory } from 'vue-router'

const routes = [
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

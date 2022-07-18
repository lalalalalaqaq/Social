import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueI18n from './i18n/i18n.js'

import 'normalize.css'
import '@/assets/styles/variables.scss'
import '@/assets/styles/common.scss'
import '@/assets/styles/mixins.scss'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

createApp(App).use(ElementPlus).use(store).use(router).use(VueI18n).mount('#app')

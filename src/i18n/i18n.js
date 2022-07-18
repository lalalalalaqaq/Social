import { createI18n } from 'vue-i18n'
import cn from './lang/cn'
import en from './lang/en'

const messages = {
  cn,
  en
}

// let locale = getLocale()
// if (!locale) {
//   locale = 'cn'
//   saveLocale(locale)
// }

const i18n = createI18n({
  locale: 'en',
  messages,
  globalInjection: true
})

export default i18n

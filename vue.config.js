// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true,
//   chainWebpack: config => {
//     config.resolve.alias.set('vue-i18n', 'vue-i18n/dist/vue-i18n.cjs.js')
//   }
// })

module.exports = {
  devServer: {
    proxy: {
      '/api': {
        target: 'http://127.0.0.1:4523/m1/1246658-0-default',
        changeOrigin: true
      }
    }
  }
}

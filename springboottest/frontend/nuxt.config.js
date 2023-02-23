module.exports = {
  ssr: false,
  /*
  ** Headers of the page
  */
  head: {
    title: 'frontend',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: 'Nuxt.js + Vuetify.js project' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' },
      { rel: 'stylesheet', href: 'https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons' }
    ]
  },
  buildModules:[

  ],
  modules: [
    '@nuxtjs/axios',
    '@nuxtjs/proxy',
    [
      '@nuxtjs/i18n',
      {
        // 대응할 언어들 셋팅
        locales: [
          { code: 'ko', name: 'Korean', iso: 'ko_KR', file: 'ko/index.js' },
          { code: 'en', name: 'English', iso: 'en_US', file: 'en/index.js' },
        ],
        defaultLocale: 'ko',
        langDir: 'locales/',
        strategy: 'no_prefix',
        vueI18n: {
          fallbackLocale: 'ko',
        },
        lazy: true,
        vueI18nLoader: true,
        vuex: {
          moduleName: 'i18n',
          syncLocale: true,
          syncMessages: true,
          syncRouteParams: true,
        }
      }
    ]
  ],
  axios: {
    proxy: true,
   // baseURL: 'http://localhost:3000/'
  },
  proxy: {
    '/api': {
        target: 'http://localhost:8081/',
        changeOrigin: true // cross origin 허용
    }
  },
  plugins: ['~/plugins/vuetify.js',
            '~/plugins/apexcharts.js'
           ],
  css: ['~/assets/style/app.styl'],
  /*
  ** Customize the progress bar color
  */
  loading: { color: '#3B8070' },
  /*
  ** Build configuration
  */
  build: {
    analyze: true,
    extractCSS: true,
    extend (config, ctx) {
      // Run ESLint on save
      if (ctx.isDev && ctx.isClient) {
        config.module.rules.push({
          enforce: 'pre',
          test: /\.(js|vue)$/,
          loader: 'eslint-loader',
          exclude: /(node_modules)/
        })
      }
    }
  },
  cli: {
    badgeMessages: ['Hello World!'],
    bannerColor: 'red'
  }
 // target: 'static'
}

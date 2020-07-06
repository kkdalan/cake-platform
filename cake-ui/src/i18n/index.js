import Vue from 'vue'
import VueI18n from 'vue-i18n'

Vue.use(VueI18n)
 
// 注册i18n实例并引入语言文件，文件格式等下解析
const i18n = new VueI18n({
  locale: 'zh_tw',
  messages: {
    'zh_tw': require('@/assets/languages/zh_tw.json'),
    'zh_cn': require('@/assets/languages/zh_cn.json'),
    'en_us': require('@/assets/languages/en_us.json')
  }
})

export default i18n
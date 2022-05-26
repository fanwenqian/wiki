import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
/* Ant Design Vue */
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';

createApp(App).use(store).use(router).use(Antd).mount('#app')
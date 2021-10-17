import Vue from 'vue';
import App from './App.vue';
import router from '@/routes/index';
import store from '@/store/index';
import {
  BootstrapVue,
  IconsPlugin,
  BIcon,
  BIconArrowUp,
  BIconArrowDown,
} from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import { formatDate } from '@/utils/filters';
import VueMoment from 'vue-moment';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faUserSecret, faUserPlus } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

library.add(faUserSecret, faUserPlus);

Vue.component('font-awesome-icon', FontAwesomeIcon);
Vue.component('BIcon', BIcon);
Vue.component('BIconArrowUp', BIconArrowUp);
Vue.component('BIconArrowDown', BIconArrowDown);
Vue.use(VueMoment);
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.filter('formatDate', formatDate);
Vue.config.productionTip = false;

new Vue({
  render: h => h(App),
  router,

  store,
}).$mount('#app');

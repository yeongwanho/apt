import Vue from 'vue';
import App from './App.vue';
import router from '@/routes/index';
import store from '@/store/index';

import { formatDate } from '@/utils/filters';
import VueMoment from 'vue-moment';
import { library } from '@fortawesome/fontawesome-svg-core';
import {
  faUserSecret,
  faUserPlus,
  faPlus,
  faInfo,
  faTrashAlt,
  faTrash,
} from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

library.add(faUserSecret, faUserPlus, faPlus, faInfo, faTrashAlt, faTrash);

Vue.component('font-awesome-icon', FontAwesomeIcon);

Vue.use(VueMoment);

Vue.filter('formatDate', formatDate);
Vue.config.productionTip = false;

new Vue({
  render: h => h(App),
  router,

  store,
}).$mount('#app');

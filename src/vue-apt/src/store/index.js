import Vue from 'vue';
import Vuex from 'vuex';
import {
  getAuthFromCookie,
  getUserFromCookie,
  saveAuthToCookie,
  saveUserToCookie,
} from '@/utils/cookies';
import { loginUser } from '@/api/auth';
import { fetchAPT } from '@/api/posts';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    loginId: getUserFromCookie() || '',
    token: getAuthFromCookie() || '',
  },
  getters: {
    isLogin(state) {
      return state.loginId !== '';
    },
  },
  mutations: {
    setUsername(state, loginId) {
      state.loginId = loginId;
    },
    clearUsername(state) {
      state.loginId = '';
    },
    setToken(state, token) {
      state.token = token;
    },
    clearToken(state) {
      state.token = '';
    },
  },
  actions: {
    async LOGIN({ commit }, userData) {
      console.log(userData);
      const { data } = await loginUser(userData);
      commit('setToken', data.token);
      commit('setUsername', data.loginId);
      saveAuthToCookie(data.token);
      saveUserToCookie(data.loginId);
      return data;
    },
  },
});

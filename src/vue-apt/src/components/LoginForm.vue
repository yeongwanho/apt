<template>
  <div class="contents">
    <div class="form-wrapper form-wrapper-sm">
      <form @submit.prevent="submitForm" class="form">
        <div>
          <label for="loginId">id:</label>
          <input id="loginId" type="text" v-model="loginId" />
          <p class="validation-text">
            <span class="warning" v-if="!isUsernameValid && loginId">
              Please enter an email address
            </span>
          </p>
        </div>
        <div>
          <label for="password">pw:</label>
          <input id="password" type="password" v-model="password" />
        </div>
        <button
          :disabled="!isUsernameValid || !password"
          type="submit"
          class="btn"
        >
          로그인
        </button>
      </form>
      <p class="log">{{ logMessage }}</p>
    </div>
  </div>
</template>

<script>
import { validateEmail } from '@/utils/validation';

export default {
  data() {
    return {
      // form values
      loginId: '',
      password: '',
      // log
      logMessage: '',
    };
  },
  computed: {
    isUsernameValid() {
      return validateEmail(this.loginId);
    },
  },
  methods: {
    async submitForm() {
      try {
        // 비즈니스 로직
        const userData = {
          loginId: this.loginId,
          password: this.password,
        };
        await this.$store.dispatch('LOGIN', userData);

        this.$router.push('/main');
        console.log('*****************');
      } catch (error) {
        // 에러 핸들링할 코드
        //console.log(error);
        //console.log(error.response.data);
        // this.logMessage = error.response.data;
        console.log(error);
      } finally {
        this.initForm();
      }
    },
    initForm() {
      this.loginId = '';
      this.password = '';
    },
  },
};
</script>

<style>
.btn {
  color: white;
}
</style>

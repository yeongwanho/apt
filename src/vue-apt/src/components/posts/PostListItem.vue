<template>
  <li>
    <div class="post-city">
      {{ postItem.cityL }}
      {{ postItem.cityM }}
      {{ postItem.cityS }}
    </div>
    <div class="post-contents">
      {{ postItem.aptName }}

      {{ postItem.aptRow }} 층 {{ postItem.price }} 만원
      <font-awesome-icon
        icon="info"
        @click="aptDetail"
        class="ion-md-create"
      ></font-awesome-icon>
    </div>
    <div class="post-time">
      {{ $moment(postItem.contractDate).format('YYYY-MM-DD') }}
    </div>
  </li>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { deletePost } from '@/api/posts';
import VueCookies from 'vue-cookies';
import Vue from 'vue';
Vue.use(VueCookies);

export default {
  props: {
    postItem: {
      type: Object,
      required: true,
    },
  },
  components: {
    FontAwesomeIcon,
  },
  methods: {
    routeEditPage() {
      const id = this.postItem._id;
      this.$router.push(`/post/${id}`);
    },
    aptName() {
      if (!this.postItem.aptName.includes('아파트')) {
        this.postItem.aptName = this.postItem.aptName + '아파트';
      }
    },
    aptDetail() {
      console.log(this.postItem);
      const id = this.postItem.aptId;
      const aptName = this.postItem.aptName;

      this.$router.push({ name: 'APT', query: { id: id, aptName: aptName } });
    },
  },
  created() {
    this.aptName();
  },
};
</script>

<style></style>

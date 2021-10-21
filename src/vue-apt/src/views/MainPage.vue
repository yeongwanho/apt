<template>
  <div>
    <div class="main list-container contents">
      <h1 class="page-header-title">부동산 실거래</h1>
      <check-box
        class="page-header"
        v-on:childEvent="searchCityData"
      ></check-box>
      <LoadingSpinner v-if="isLoading"></LoadingSpinner>
      <ul v-else>
        <PostListItem
          v-for="(postItem, $index) in postItems"
          :key="$index"
          :postItem="postItem"
          @refresh="infiniteHandler"
        ></PostListItem>
      </ul>
    </div>
    <router-link to="/add" class="create-button">
      <i class="ion-md-add"></i>
    </router-link>

    <div class="overflow-auto">
      <div class="mt-3"></div>
      <infinite-loading
        :identifier="infiniteId"
        @infinite="infiniteHandler"
      ></infinite-loading>
    </div>
  </div>
</template>

<script>
import infiniteLoading from 'vue-infinite-loading';
import checkBox from '@/components/checkBox.vue';
import PostListItem from '@/components/posts/PostListItem.vue';
import LoadingSpinner from '@/components/common/LoadingSpinner.vue';
import { fetchAPT } from '@/api/posts';

export default {
  components: {
    PostListItem,
    LoadingSpinner,
    checkBox,
    infiniteLoading,
  },
  data() {
    return {
      page: 0,
      pagerows: 20,
      rows: 100,
      postItems: [],
      isLoading: false,
      infiniteId: +new Date(),
      cityL: '',
      cityM: '',
      cityS: '',
    };
  },
  methods: {
    async infiniteHandler($state) {
      // this.isLoading = true;
      const aptData = {
        cityL: this.cityL,
        cityM: this.cityM,
        cityS: this.cityS,
        page: this.page,
      };

      const { data } = await fetchAPT(aptData);
      if (data.content) {
        this.page += 1;
        this.postItems.push(...data.content);

        if (data.content.length < 20) {
          $state.complete();
        }
        // this.isLoading = false;
        $state.loaded();
      } else {
        $state.complete();
        console.log();
      }
      // this.postItems.push = data.content;
    },
    searchCityData(aptData) {
      this.cityL = aptData.cityL;
      this.cityM = aptData.cityM;
      this.cityS = aptData.cityS;
      this.infiniteId += 1;
      this.page = 0;
      this.postItems = [];
    },
  },
};
</script>

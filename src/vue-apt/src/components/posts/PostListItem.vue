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
      <b-icon icon="plus-circle" @click="aptDetail"></b-icon>
    </div>
    <div class="post-time">
      {{ $moment(postItem.contractDate).format('YYYY-MM-DD') }}
    </div>
  </li>
</template>

<script>
import { deletePost } from '@/api/posts';

export default {
  props: {
    postItem: {
      type: Object,
      required: true,
    },
  },
  methods: {
    async deleteItem() {
      if (confirm('You want to delete it?')) {
        await deletePost(this.postItem._id);
        this.$emit('refresh');
      }
    },
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
      const id = this.postItem.id;
      const aptName = this.postItem.aptName;

      this.$router.push({ name: 'APT', params: { id: id, aptName: aptName } });
    },
  },
  created() {
    this.aptName();
  },
};
</script>

<style></style>

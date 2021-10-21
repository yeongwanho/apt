<template>
  <div class="container">
    <line-chart
      v-if="loaded"
      :aptPrice="aptPrice"
      :aptDate="aptDate"
      :aptName="aptName"
    />
    <div class="comment-form">
      <textarea
        type="text"
        v-model="reply"
        placeholder="Comment is here: with markdown"
      ></textarea>

      <button @click="addComment">Add Comment</button>
    </div>
    <comments
      v-for="comment in comments"
      :comment="comment"
      :aptId="aptId"
    ></comments>
  </div>
</template>

<script>
import LineChart from '@/components/common/Chart.vue';
import Comments from '@/components/Comments.vue';
import { fetchPost, fetchDetailApt } from '@/api/posts';

export default {
  data() {
    return {
      aptId: this.$route.query.id,
      reply: '',
      loaded: false,
      chartdata: null,
      aptName: this.$route.query.aptName,
      loginId: '',
      aptPrice: [],
      comments: [],
      content: '',
      logMessage: '',
      aptDate: [],
    };
  },
  name: 'LinChartContainer',
  components: {
    LineChart,
    Comments,
  },
  methods: {
    async addComment() {
      const commentData = {
        content: this.reply,
        loginId: this.loginId,
        aptId: this.aptId,
      };
      if (this.reply) {
        console.log(commentData);
        await fetchDetailApt(commentData);
      } else {
        alert('Fields Empty');
      }
    },
  },

  async mounted() {
    const aptData = {
      id: this.$route.query.id,
      aptName: this.$route.query.aptName,
    };
    this.loaded = false;

    try {
      const { data } = await fetchPost(aptData);
      console.log('데이터');
      console.log(data);

      this.comments = data.comments;

      this.aptDate = data.aptDate;
      this.aptPrice = data.aptPrice.map(Number);

      console.log('아파트 이름');

      this.loaded = true;
    } catch (e) {
      console.log(e);
    }
  },
  created() {
    if (this.loginId) {
      this.loginId = this.$cookies.get('til_user');
    }

    console.log(this.loginId);
    console.log(this.aptName);
  },
};
</script>

<style scoped>
.form-wrapper .form {
  width: 100%;
}
.btn {
  color: white;
}
.comment-form {
  display: block;
  width: 80%;
  margin: auto;
}

textarea {
  width: 100%;
  border: 2px solid #ccc;
  border-radius: 7px;
  height: 70px;
  font-family: Verdana, Helvetica, sans-serif;
  padding: 5px;
}
</style>

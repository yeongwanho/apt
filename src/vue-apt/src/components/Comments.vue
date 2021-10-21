<template>
  <div>
    <li class="comments-box">
      <p class="author">{{ comment.loginId }}</p>
      <p class="content-comment">{{ comment.content }}</p>

      <font-awesome-icon
        icon="trash"
        @click="removeComment"
        class="ion-md-create"
      ></font-awesome-icon>
    </li>
  </div>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { fetchDetailApt } from '@/api/posts';
export default {
  props: {
    comment: [
      {
        type: Array,
      },
    ],
    aptId: String,
  },
  data() {
    return {
      content: '',
      reply: '',
      loginId: '',
    };
  },
  components: {
    FontAwesomeIcon,
  },
  methods: {
    removeComment: function () {
      console.log(this.comment);
      console.log(this.comment.commentId);
    },
  },
  created() {
    console.log('comments 내부');
    console.log(this.reply);
    console.log('체크');
    console.log(this.loginId);
    console.log(this.aptId);
  },
};
</script>

<style scoped>
.content-comment {
  margin-bottom: 10px;
}

* {
  padding: 0;
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 16px;
}

#demo {
  margin: 20px 0 0 0;
}

.comment-form {
  display: block;
  width: 80%;
  margin: auto;
}

input {
  border: 2px solid #ccc;
  border-radius: 5px;
  padding: 5px;
}

button {
  background: #333;
  color: #ccc;
  border: 0;
  padding: 5px;
  cursor: pointer;
}

/*Comment Box*/

.comments-box {
  width: 90%;
  margin: auto;
  padding: 20px 0;
  border-bottom: 1px solid #000;
}

.delete {
  background: red;
  color: #fff;
  font-size: 12px;
  cursor: pointer;
  display: inline;
  padding: 3px;
}

.author {
  margin: 10px 0;
  font-weight: bold;
}
</style>

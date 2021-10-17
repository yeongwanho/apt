<template>
  <div class="container">
    <line-chart
      v-if="loaded"
      :aptPrice="aptPrice"
      :aptDate="aptDate"
      :aptName="aptName"
    />
  </div>
</template>

<script>
import LineChart from '@/components/common/Chart.vue';
import { fetchPost, editPost } from '@/api/posts';

export default {
  data() {
    return {
      loaded: false,
      chartdata: null,
      aptName: '',
      aptPrice: [],
      contents: '',
      logMessage: '',
      aptDate: [],
    };
  },
  name: 'LinChartContainer',
  components: {
    LineChart,
  },
  computed: {
    isContentsValid() {
      return this.contents.length <= 200;
    },
  },

  async mounted() {
    const aptData = {
      id: this.$route.params.id,
      aptName: this.$route.params.aptName,
    };
    this.loaded = false;
    try {
      const { data } = await fetchPost(aptData);

      this.aptDate = data.aptDate;
      this.aptPrice = data.aptPrice.map(Number);
      this.aptName = data.aptName;
      console.log('아파트 이름');
      console.log(this.aptName);

      this.loaded = true;
    } catch (e) {
      console.log(e);
    }
  },
  methods: {
    async submitForm() {
      const id = this.$route.params.id;
      try {
        await editPost(id, {
          contents: this.contents,
        });
        this.$router.push('/main');
      } catch (error) {
        console.log(error);
        this.logMessage = error;
      }
    },
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
</style>

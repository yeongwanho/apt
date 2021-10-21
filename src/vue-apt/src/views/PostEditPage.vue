<template>
  <div class="form-container">
    <chart-view></chart-view>
  </div>
</template>

<script>
import ChartView from '@/components/posts/chartView.vue';

export default {
  components: {
    ChartView,
  },
};
</script>
<style scoped>
.form-container {
  margin: auto;
  width: auto;
  display: grid;
  gap: 30px;
}
</style>

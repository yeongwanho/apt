<script>
import { Line } from 'vue-chartjs';

export default {
  extends: Line,
  // data() {
  //   return {
  //     aptDate: [],
  //     aptPrice: [],
  //   };
  // },
  props: {
    aptDate: Array,
    aptPrice: Array,
    aptName: String,
  },
  mounted() {
    this.gradient = this.$refs.canvas
      .getContext('2d')
      .createLinearGradient(0, 0, 0, 450);

    this.gradient.addColorStop(0, 'rgba(255, 0,0, 0.5)');
    this.gradient.addColorStop(0.5, 'rgba(255, 0, 0, 0.25)');
    this.gradient.addColorStop(1, 'rgba(255, 0, 0, 0)');

    console.log('차트내부');
    console.log(this.aptDate);
    console.log(this.aptPrice);
    console.log(this.aptName);
    this.renderChart(
      {
        labels: this.aptDate,

        datasets: [
          {
            label: this.aptName,
            backgroundColor: this.gradient,
            pointBackgroundColor: 'white',
            data: this.aptPrice,
          },
        ],
      },
      {
        scales: {
          xAxes: [
            {
              display: true,
              scaleLabel: {
                display: true,
                labelString: '실거래일',
              },
              ticks: {
                major: {
                  fontStyle: 'bold',
                  fontColor: '#FF0000',
                },
              },
            },
          ],
          yAxes: [
            {
              display: true,
              scaleLabel: {
                display: true,
                labelString: '만원',
              },
            },
          ],
        },
        responsive: true,
        maintainAspectRatio: false,
      },
    );
  },
};
</script>

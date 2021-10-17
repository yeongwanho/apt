module.exports = {
  devServer: {
    overlay: false,
    proxy: 'http://localhost:8080/api',
  },
  outputDir: '../main/resources/static',
  indexPath: './index.html',

  chainWebpack: config => {
    const svgRule = config.module.rule('svg');
    svgRule.uses.clear();
    svgRule.use('vue-svg-loader').loader('vue-svg-loader');
  },
};

(function(e){function t(t){for(var r,o,a=t[0],i=t[1],s=t[2],f=0,l=[];f<a.length;f++)o=a[f],Object.prototype.hasOwnProperty.call(c,o)&&c[o]&&l.push(c[o][0]),c[o]=0;for(r in i)Object.prototype.hasOwnProperty.call(i,r)&&(e[r]=i[r]);d&&d(t);while(l.length)l.shift()();return u.push.apply(u,s||[]),n()}function n(){for(var e,t=0;t<u.length;t++){for(var n=u[t],r=!0,o=1;o<n.length;o++){var a=n[o];0!==c[a]&&(r=!1)}r&&(u.splice(t--,1),e=i(i.s=n[0]))}return e}var r={},o={app:0},c={app:0},u=[];function a(e){return i.p+"js/"+({}[e]||e)+"."+{"chunk-24fcc7da":"c0e005bb","chunk-2d0aed93":"60d3f390","chunk-2d0c898d":"e26ca790","chunk-38a5fea7":"f3270044","chunk-d75fc4c8":"143bafe8","chunk-f65f3e26":"f6407848"}[e]+".js"}function i(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,i),n.l=!0,n.exports}i.e=function(e){var t=[],n={"chunk-24fcc7da":1,"chunk-38a5fea7":1,"chunk-d75fc4c8":1,"chunk-f65f3e26":1};o[e]?t.push(o[e]):0!==o[e]&&n[e]&&t.push(o[e]=new Promise((function(t,n){for(var r="css/"+({}[e]||e)+"."+{"chunk-24fcc7da":"363ca342","chunk-2d0aed93":"31d6cfe0","chunk-2d0c898d":"31d6cfe0","chunk-38a5fea7":"36181412","chunk-d75fc4c8":"937894d9","chunk-f65f3e26":"621781d4"}[e]+".css",c=i.p+r,u=document.getElementsByTagName("link"),a=0;a<u.length;a++){var s=u[a],f=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(f===r||f===c))return t()}var l=document.getElementsByTagName("style");for(a=0;a<l.length;a++){s=l[a],f=s.getAttribute("data-href");if(f===r||f===c)return t()}var d=document.createElement("link");d.rel="stylesheet",d.type="text/css",d.onload=t,d.onerror=function(t){var r=t&&t.target&&t.target.src||c,u=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");u.code="CSS_CHUNK_LOAD_FAILED",u.request=r,delete o[e],d.parentNode.removeChild(d),n(u)},d.href=c;var p=document.getElementsByTagName("head")[0];p.appendChild(d)})).then((function(){o[e]=0})));var r=c[e];if(0!==r)if(r)t.push(r[2]);else{var u=new Promise((function(t,n){r=c[e]=[t,n]}));t.push(r[2]=u);var s,f=document.createElement("script");f.charset="utf-8",f.timeout=120,i.nc&&f.setAttribute("nonce",i.nc),f.src=a(e);var l=new Error;s=function(t){f.onerror=f.onload=null,clearTimeout(d);var n=c[e];if(0!==n){if(n){var r=t&&("load"===t.type?"missing":t.type),o=t&&t.target&&t.target.src;l.message="Loading chunk "+e+" failed.\n("+r+": "+o+")",l.name="ChunkLoadError",l.type=r,l.request=o,n[1](l)}c[e]=void 0}};var d=setTimeout((function(){s({type:"timeout",target:f})}),12e4);f.onerror=f.onload=s,document.head.appendChild(f)}return Promise.all(t)},i.m=e,i.c=r,i.d=function(e,t,n){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)i.d(n,r,function(t){return e[t]}.bind(null,r));return n},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/",i.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],f=s.push.bind(s);s.push=t,s=s.slice();for(var l=0;l<s.length;l++)t(s[l]);var d=f;u.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"034f":function(e,t,n){"use strict";n("85ec")},"365c":function(e,t,n){"use strict";n.d(t,"a",(function(){return s})),n.d(t,"b",(function(){return f}));n("99af");var r=n("bc3a"),o=n.n(r),c=(n("d3b7"),n("4360"));function u(e){return e.interceptors.request.use((function(e){return e.headers.Authorization=c["a"].state.token,e}),(function(e){return Promise.reject(e)})),e.interceptors.response.use((function(e){return e}),(function(e){return Promise.reject(e)})),e}function a(){return o.a.create({baseURL:"http://localhost:8080/"})}function i(e){var t=o.a.create({baseURL:"".concat("http://localhost:8080/").concat(e)});return u(t)}var s=a(),f=i("posts")},3786:function(e,t,n){"use strict";n.d(t,"b",(function(){return o})),n.d(t,"a",(function(){return c}));var r=n("365c");function o(e){return r["a"].post("signup",e)}function c(e){return r["a"].post("login",e)}},4360:function(e,t,n){"use strict";var r=n("1da1"),o=(n("96cf"),n("2b0e")),c=n("2f62"),u=n("6a1d"),a=n("3786");o["a"].use(c["a"]),t["a"]=new c["a"].Store({state:{username:Object(u["c"])()||"",token:Object(u["b"])()||""},getters:{isLogin:function(e){return""!==e.username}},mutations:{setUsername:function(e,t){e.username=t},clearUsername:function(e){e.username=""},setToken:function(e,t){e.token=t},clearToken:function(e){e.token=""}},actions:{LOGIN:function(e,t){return Object(r["a"])(regeneratorRuntime.mark((function n(){var r,o,c;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return r=e.commit,n.next=3,Object(a["a"])(t);case 3:return o=n.sent,c=o.data,console.log(c.token),r("setToken",c.token),r("setUsername",c.user.username),Object(u["d"])(c.token),Object(u["e"])(c.user.username),n.abrupt("return",c);case 11:case"end":return n.stop()}}),n)})))()}}})},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d"),n("4de4");var r=n("2b0e"),o=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"app"},[n("AppHeader"),n("div",{staticClass:"app-contents"},[n("router-view")],1)],1)},c=[],u=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("header",[n("div",[n("router-link",{staticClass:"logo",attrs:{to:e.logoLink}},[e._v(" TIL "),e.isUserLogin?n("span",[e._v("by "+e._s(e.$store.state.username))]):e._e()])],1),n("div",{staticClass:"navigations"},[e.isUserLogin?[n("a",{staticClass:"logout-button",attrs:{href:"javascript:;"},on:{click:e.logoutUser}},[e._v(" Logout ")])]:[n("router-link",{attrs:{to:"/login"}},[e._v("로그인")]),n("router-link",{attrs:{to:"/signup"}},[e._v("회원가입")])]],2)])},a=[],i=n("6a1d"),s={computed:{isUserLogin:function(){return this.$store.getters.isLogin},logoLink:function(){return this.$store.getters.isLogin?"/main":"/login"}},methods:{logoutUser:function(){this.$store.commit("clearUsername"),this.$store.commit("clearToken"),Object(i["a"])("til_auth"),Object(i["a"])("til_user"),this.$router.push("/login")}}},f=s,l=(n("db20"),n("2877")),d=Object(l["a"])(f,u,a,!1,null,"6c90afef",null),p=d.exports,h={components:{AppHeader:p}},m=h,g=(n("034f"),Object(l["a"])(m,o,c,!1,null,null,null)),b=g.exports,v=(n("d3b7"),n("3ca3"),n("ddb0"),n("8c4f")),k=n("4360");r["a"].use(v["a"]);var y=new v["a"]({mode:"history",routes:[{path:"/",redirect:"/login"},{path:"/login",component:function(){return n.e("chunk-38a5fea7").then(n.bind(null,"48ca"))}},{path:"/signup",component:function(){return n.e("chunk-2d0c898d").then(n.bind(null,"560f"))}},{path:"/main",component:function(){return n.e("chunk-d75fc4c8").then(n.bind(null,"4385"))},meta:{auth:!0}},{path:"/add",component:function(){return n.e("chunk-f65f3e26").then(n.bind(null,"e111"))},meta:{auth:!0}},{path:"/post/:id",component:function(){return n.e("chunk-24fcc7da").then(n.bind(null,"b2f6"))},meta:{auth:!0}},{path:"*",component:function(){return n.e("chunk-2d0aed93").then(n.bind(null,"0c8b"))}}]});y.beforeEach((function(e,t,n){if(e.meta.auth&&!k["a"].getters.isLogin)return console.log("인증이 필요합니다"),void n("/login");n()}));var _=y;n("99af");function j(e){var t=new Date(e),n=t.getFullYear(),r=t.getMonth()+1;r=r>9?r:"0".concat(r);var o=t.getDate(),c=t.getHours();c=c>9?c:"0".concat(c);var u=t.getMinutes();return"".concat(n,"-").concat(r,"-").concat(o," ").concat(c,":").concat(u)}r["a"].filter("formatDate",j),r["a"].config.productionTip=!1,new r["a"]({render:function(e){return e(b)},router:_,store:k["a"]}).$mount("#app")},"6a1d":function(e,t,n){"use strict";n.d(t,"d",(function(){return r})),n.d(t,"e",(function(){return o})),n.d(t,"b",(function(){return c})),n.d(t,"c",(function(){return u})),n.d(t,"a",(function(){return a}));n("ac1f"),n("5319");function r(e){document.cookie="til_auth=".concat(e)}function o(e){document.cookie="til_user=".concat(e)}function c(){return document.cookie.replace(/(?:(?:^|.*;\s*)til_auth\s*=\s*([^;]*).*$)|^.*$/,"$1")}function u(){return document.cookie.replace(/(?:(?:^|.*;\s*)til_user\s*=\s*([^;]*).*$)|^.*$/,"$1")}function a(e){document.cookie="".concat(e,"=; expires=Thu, 01 Jan 1970 00:00:01 GMT;")}},"85ec":function(e,t,n){},db20:function(e,t,n){"use strict";n("fbd7")},fbd7:function(e,t,n){}});
//# sourceMappingURL=app.1d076341.js.map
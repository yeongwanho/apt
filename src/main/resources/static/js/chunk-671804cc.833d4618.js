(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-671804cc"],{"013b":function(t,e,s){"use strict";s("f74f")},"48ca":function(t,e,s){"use strict";s.r(e);var n=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("h1",{staticClass:"page-header"},[t._v("로그인 페이지")]),s("LoginForm")],1)},a=[],r=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"contents"},[s("div",{staticClass:"form-wrapper form-wrapper-sm"},[s("form",{staticClass:"form",on:{submit:function(e){return e.preventDefault(),t.submitForm.apply(null,arguments)}}},[s("div",[s("label",{attrs:{for:"loginId"}},[t._v("id:")]),s("input",{directives:[{name:"model",rawName:"v-model",value:t.loginId,expression:"loginId"}],attrs:{id:"loginId",type:"text"},domProps:{value:t.loginId},on:{input:function(e){e.target.composing||(t.loginId=e.target.value)}}}),s("p",{staticClass:"validation-text"},[!t.isUsernameValid&&t.loginId?s("span",{staticClass:"warning"},[t._v(" Please enter an email address ")]):t._e()])]),s("div",[s("label",{attrs:{for:"password"}},[t._v("pw:")]),s("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],attrs:{id:"password",type:"text"},domProps:{value:t.password},on:{input:function(e){e.target.composing||(t.password=e.target.value)}}})]),s("button",{staticClass:"btn",attrs:{disabled:!t.isUsernameValid||!t.password,type:"submit"}},[t._v(" 로그인 ")])]),s("p",{staticClass:"log"},[t._v(t._s(t.logMessage))])])])},i=[],o=s("1da1");s("96cf");function l(t){var e=/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;return e.test(String(t).toLowerCase())}var u={data:function(){return{loginId:"",password:"",logMessage:""}},computed:{isUsernameValid:function(){return l(this.loginId)}},methods:{submitForm:function(){var t=this;return Object(o["a"])(regeneratorRuntime.mark((function e(){var s;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,s={loginId:t.loginId,password:t.password},e.next=4,t.$store.dispatch("LOGIN",s);case 4:t.$router.push("/main"),console.log("*****************"),e.next=10;break;case 8:e.prev=8,e.t0=e["catch"](0);case 10:return e.prev=10,t.initForm(),e.finish(10);case 13:case"end":return e.stop()}}),e,null,[[0,8,10,13]])})))()},initForm:function(){this.loginId="",this.password=""}}},c=u,d=(s("013b"),s("2877")),p=Object(d["a"])(c,r,i,!1,null,null,null),m=p.exports,v={components:{LoginForm:m}},f=v,g=Object(d["a"])(f,n,a,!1,null,null,null);e["default"]=g.exports},f74f:function(t,e,s){}}]);
//# sourceMappingURL=chunk-671804cc.833d4618.js.map
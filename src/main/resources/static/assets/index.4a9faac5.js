var e=Object.defineProperty,t=Object.defineProperties,a=Object.getOwnPropertyDescriptors,n=Object.getOwnPropertySymbols,l=Object.prototype.hasOwnProperty,s=Object.prototype.propertyIsEnumerable,r=(t,a,n)=>a in t?e(t,a,{enumerable:!0,configurable:!0,writable:!0,value:n}):t[a]=n,o=(e,t)=>{for(var a in t||(t={}))l.call(t,a)&&r(e,a,t[a]);if(n)for(var a of n(t))s.call(t,a)&&r(e,a,t[a]);return e};import{r as i,o as u,t as c,c as d,C as p,p as m,i as v,d as h,h as f,S as y,N as w,R as b,w as g,a as _,b as x,e as P,I as k,H as C,f as j,g as q,u as E,j as S,F as O,k as H,l as $,m as I,n as W,q as B,B as A,s as L,v as M,x as z,y as D,z as U,A as R,D as T,E as V,G as N,J,K as F,L as X,M as Y,T as G,P as K,O as Q,Q as Z,U as ee,V as te,W as ae,X as ne,Y as le,Z as se,_ as re,$ as oe,a0 as ie,a1 as ue,a2 as ce,a3 as de,a4 as pe,a5 as me}from"./vendor.031f8059.js";function ve(){const e=i({}),t=i(250),a=i(!!e.value.mobile);u((()=>{const e=c((()=>{n()}),300);window.onresize=e,n()}));const n=()=>{const t=window.innerHeight,a=document.documentElement.getBoundingClientRect().width,{hpad:n,pad:l,mobile:s}=e.value;e.value.h&&Math.abs(t-e.value.h)<80&&a===e.value.w&&(n||l||s)||(e.value={w:a,h:t,mobile:window.screen.width<=568||window.innerWidth<=568,pad:window.innerWidth<=768&&window.innerWidth>568,hpad:window.innerWidth<=1024&&window.innerWidth>768,wider:window.innerWidth>1024&&window.innerWidth<1920,widest:window.innerWidth>=1920})},l=d((()=>e.value.w-t.value+(a.value?e.value.mobile?50:100:0))),s=d((()=>l.value-6*parseInt(getComputedStyle(document.documentElement).fontSize)));return{viewport:e,contentWidth:l,sidebarWidth:t,contentInsetWidth:s,sidebarCollapse:a}}function he(){return p.get("mx-admin-token")?JSON.parse(p.get("mx-admin-token")):null}const fe=(e,t,a)=>{var n,l,s,r,o;const i=((e,t)=>{let a=/^\//.test(e)?e:"/"+e;if(!a.match(/(\/?:)/))return a;if(!t||"[object Object]"!==Object.prototype.toString.call(t))throw new TypeError("params must be object");for(const n in t)a=a.replaceAll(":"+n,t[n]);return a})(e.path,null==(n=e.meta)?void 0:n.params),u=a+"/"+i;return{title:(null==(l=e.meta)?void 0:l.title)||(null==(s=e.name)?void 0:s.toString())||i,path:i,icon:null==(r=e.meta)?void 0:r.icon,subItems:ye(e,u),hasParent:t,fullPath:u.replaceAll("//","/"),query:null==(o=e.meta)?void 0:o.query}};function ye(e,t=""){return Array.isArray(e.children)?e.children.filter((e=>!e.meta||!0!==e.meta.hide)).map((e=>fe(e,!0,t))):[]}function we(e,t){const a=e.token,n=e.root;switch(t){case"optional":return v(a)||e.root||null;case"root":return e.root||(e.root=e()),e.root;default:if(v(a))return v(a);if(n)return e.root;throw new Error(`状态钩子函数${e.name}未在上层组件通过调用useProvider提供`)}}let be;const ge={},_e=function(e,t){if(!t)return e();if(void 0===be){const e=document.createElement("link").relList;be=e&&e.supports&&e.supports("modulepreload")?"modulepreload":"preload"}return Promise.all(t.map((e=>{if(e in ge)return;ge[e]=!0;const t=e.endsWith(".css"),a=t?'[rel="stylesheet"]':"";if(document.querySelector(`link[href="${e}"]${a}`))return;const n=document.createElement("link");return n.rel=t?"stylesheet":be,t||(n.as="script",n.crossOrigin=""),n.href=e,document.head.appendChild(n),t?new Promise(((e,t)=>{n.addEventListener("load",e),n.addEventListener("error",t)})):void 0}))).then((()=>e()))},xe=h({setup:()=>()=>f(b,null,{default:({Component:e})=>f(y,null,{default:()=>e,fallback:()=>()=>f("div",{class:"fixed left-1/2 top-1/2 transform text-primary-default -translate-y-1/2 -translate-x-1/2"},f(w,{strokeWidth:14}))})})});var Pe="一个后台",ke="https://gitee.com/xun7788/my-imagination/raw/master/uPic/1615516941397.jpg",Ce="#1a9cf3",je={primary:{default:"#3B82DC",deep:"#0984e3",shallow:"#5D8CDC",suppl:"#00a8ff"}},qe=h({props:{size:{type:Number,default:50},src:{type:String,required:!0}},setup(e){const t=i(!1),a=()=>{const a=new Image;a.src=e.src,a.onload=e=>{t.value=!0}};return u((()=>{a()})),g((()=>e.src),(()=>{a()})),{loaded:t}}});const Ee=P("div",{class:"sr-only"},"一个头像",-1);qe.render=function(e,t,a,n,l,s){return _(),x("div",{class:"avatar",style:{height:`${e.size}px`,width:`${e.size}px`}},[P("img",{src:e.src,alt:"",style:{display:e.loaded?"":"none"}},null,12,["src"]),Ee],4)};var Se="_root_1tb4q_1",Oe="_collapse_1tb4q_5",He="_item-title_1tb4q_8",$e="_has-child_1tb4q_12",Ie="_collapse-button_1tb4q_23",We="_sidebar_1tb4q_31",Be="_items_1tb4q_38",Ae="_active_1tb4q_50",Le="_expand_1tb4q_51",Me="_item_1tb4q_8",ze="_menu_1tb4q_89";const De=h({name:"SidebarComp",props:{collapse:{type:Boolean,required:!0},width:{type:Number,required:!0},onCollapseChange:{type:Function,required:!0}},setup(e){const t=E(),{user:a}=we(bt),n=d((()=>t.currentRoute.value)),l=i([]);u((()=>{l.value=t.getRoutes().find((e=>"home"===e.name&&"/"===e.path)).children.filter((e=>{var t;return"*"!==e.path&&!0!==(null==(t=e.meta)?void 0:t.hide)})).map((e=>fe(e,!1,"")))}));const s=i(0);function r(e){e!==s.value?s.value=e:s.value=-1}function o(e,a){var n;(null==(n=e.subItems)?void 0:n.length)||(t.push({path:e.fullPath,query:e.query}),a&&r(a))}const c=Pe;return()=>{var t,i,u;return f("div",{class:q(Se,e.collapse?Oe:null),style:{width:!e.collapse&&e.width?e.width+"px":""}},f("div",{class:"fixed left-0 top-0 h-screen overflow-hidden z-10 text-white "+We},f("div",{class:"title relative font-medium text-center text-2xl"},f("h1",{class:"py-6",style:{display:e.collapse?"none":""}},c),f("button",{class:Ie,onClick:()=>{e.onCollapseChange(!e.collapse)}},f(k,null,f(C,null)))),f(j,{class:ze,nativeScrollbar:!1},f("div",{class:Be},l.value.map(((e,t)=>{var a;return f("div",{class:q("py-2",n.value.fullPath===e.fullPath||n.value.fullPath.startsWith(e.fullPath)?Ae:"",Me),"data-path":e.fullPath},f("button",{key:e.title,class:"py-2 flex w-full items-center",onClick:(null==(a=e.subItems)?void 0:a.length)?()=>r(t):()=>o(e,t)},f("span",{style:{flexBasis:"3rem"},class:"flex justify-center"},e.icon),f("span",{class:He},e.title)),e.subItems&&f("ul",{class:q("overflow-hidden  "+(e.subItems.length?$e:""),s.value===t?Le:""),style:{maxHeight:s.value===t?3.5*e.subItems.length+"rem":"0"}},e.subItems.map((e=>f("li",{key:e.path,class:q(n.value.fullPath===e.fullPath||n.value.fullPath.startsWith(e.fullPath)?Ae:"",Me)},f("button",{onClick:()=>o(e),class:"flex w-full items-center py-4"},f("span",{class:"flex justify-center items-center",style:{flexBasis:"3rem"}},e.icon),f("span",{class:He},e.title)))))))})))),f("button",{class:q("bottom-bar flex space-x-2 items-center  transform translate-y-1/3 phone:hidden",e.collapse?"px-8":"px-12"),onClick:()=>{window.open("http://localhost:2323")}},f(qe,{src:null==(t=a.value)?void 0:t.avatar,size:40}),e.collapse?null:f("span",{class:"pl-12"},null==(i=a.value)?void 0:i.username)),f("button",{class:"hidden phone:flex w-full items-center justify-center absolute bottom-0 pb-4",onClick:()=>{window.open("http://localhost:2323")}},f(qe,{src:null==(u=a.value)?void 0:u.avatar,size:40}))))}}});var Ue="_root_5exgh_1",Re="_content_5exgh_2";const Te=h({name:"SidebarLayout",setup(e){const t=we(ve),a=t.sidebarCollapse;S((()=>{a.value=!!t.viewport.value.mobile}));const n=t.sidebarWidth;return()=>f("div",{class:Ue},f(De,{collapse:a.value,width:n.value,onCollapseChange:e=>{a.value=e}}),f(j,{embedded:!0,nativeScrollbar:!1,class:Re,style:{left:a.value?"100px":n.value+"px"}},f(xe,null)))}});var Ve="_header_1fxaw_1",Ne="_header-blur_1fxaw_9",Je="_title_1fxaw_23",Fe="_main_1fxaw_30",Xe="_buttons_1fxaw_42",Ye="_header-actions_1fxaw_69";const Ge=h({props:{actionsElement:{type:Object,required:!1},footerButtonElement:{type:Object,required:!1},title:{type:String}},setup(e,t){const{slots:a}=t,n=E(),l=d((()=>n.currentRoute)),s=()=>{var t;return null!=(t=e.actionsElement)?t:null},r=()=>{var t;return null!=(t=e.footerButtonElement)?t:null};return()=>{var t,n,o,i;return f(O,null,f("header",{class:Ve},f("div",{class:Ne}),f("h1",{class:Je},null!=(t=e.title)?t:l.value.value.meta.title),f("div",{class:q(Ye,"space-x-4")},e.actionsElement?f(s,null):null==(n=a.actions)?void 0:n.call(a))),f("main",{class:Fe},null==(o=a.default)?void 0:o.call(a)),f("footer",{class:Xe},e.footerButtonElement?f(r,null):null==(i=a.buttons)?void 0:i.call(a)))}}});var Ke=h({setup(){const e=i(""),t=H(),a=async()=>{const t=await fetch("https://v1.hitokoto.cn/?c=d"),a=await t.json(),n=Object.values(D(a,["from","from_who","creator"])).filter(Boolean)[0];e.value=a.hitokoto+(n?" —— "+n:"")};return $((()=>{a()})),()=>f(Ge,null,f(z,{class:"font-light"},"欢迎回来"),f(I,null,f(W,{align:"center",class:"min-h-[3rem]"},e.value?f(O,null,f(B,{class:"leading-normal"},e.value),f("div",{class:"space-x-2 flex items-center"},f(A,{text:!0,onClick:a,class:"ml-4 phone:ml-0 phone:float-right"},f(k,null,f(L,null))),f(A,{text:!0,onClick:()=>{navigator.clipboard.writeText(e.value),t.success("已复制"),t.info(e.value)}},f(k,null,f(M,null))))):f(B,null,"加载中..."))))}}),Qe=h({props:{title:{type:String,default:"Button"},type:{type:String,default:"normal",validator:e=>["normal","warning","danger"].includes(e)},forecolor:{type:String,default:"#fff"}},setup(e,{slots:t}){const a=i(),n=i();u((()=>{var e;a.value=null==(e=n.value)?void 0:e.style}));const l=d((()=>{var e;return null==(e=n.value)?void 0:e.getBoundingClientRect()}));return{parallaxBtn:n,btnStyle:a,boundingClientRect:l,down(e){a.value.setProperty("--tz","-25px")},leave(e){a.value.setProperty("--ty","0"),a.value.setProperty("--rx","0"),a.value.setProperty("--ry","0")},move(e){const t=e.clientX-l.value.left,n=e.clientY-l.value.top,s=t-l.value.width/2,r=n-l.value.height/2;a.value.setProperty("--rx",r/-1+"deg"),a.value.setProperty("--ry",s/10+"deg")},up(){a.value.setProperty("--tz","-12px")}}}});Qe.render=function(e,t,a,n,l,s){return _(),x("a",{ref:"parallaxBtn",class:["parallax-btn pr",e.type],"data-title":e.title,style:{color:e.forecolor},onMousemove:t[1]||(t[1]=(...t)=>e.move&&e.move(...t)),onMouseup:t[2]||(t[2]=(...t)=>e.up&&e.up(...t)),onMousedown:t[3]||(t[3]=(...t)=>e.down&&e.down(...t)),onMouseleave:t[4]||(t[4]=(...t)=>e.leave&&e.leave(...t)),onClick:t[5]||(t[5]=t=>e.$emit("click"))},null,46,["data-title"])};const Ze=ke,et=h({components:{Avatar:qe,ParallaxButtonVue:Qe},setup(){const e=i(!1),{user:t,updateToken:a}=we(bt),n=E(),l=i(null);u((()=>{const t=new Image;t.src=Ze,t.onload=t=>{e.value=!0},l.value.focus()}));const s=H(),r=i(""),o=i(""),c=we(bt);return{bgUrl:Ze,loaded:e,user:t,password:o,username:r,handleLogin:async e=>{e.stopPropagation();try{const e=await ht.api.auth.login.post({data:{username:r.value,password:o.value}});a(e.token),c.setUser(e),n.push("/dashboard"),s.success("欢迎回来")}catch(t){s.error("登陆失败")}},input:l}}});const tt=F();U("data-v-206fc1de");const at={class:"wrapper"},nt={class:"input-wrap"},lt=P("div",{class:"blur"},null,-1),st={class:"input-wrap !mt-0"},rt=P("div",{class:"blur"},null,-1);R();const ot=tt(((e,t,a,n,l,s)=>{var r;const o=T("Avatar"),i=T("ParallaxButtonVue");return _(),x("div",null,[P("div",{class:"bg transition-opacity duration-700",style:{backgroundImage:`url(${e.bgUrl})`,opacity:e.loaded?1:0}},null,4),P("div",at,[P(o,{src:null==(r=e.user)?void 0:r.avatar,size:80},null,8,["src"]),P("form",{action:"#",onSubmit:t[3]||(t[3]=V(((...t)=>e.handleLogin&&e.handleLogin(...t)),["prevent"]))},[P("div",nt,[N(P("input",{ref:"input","onUpdate:modelValue":t[1]||(t[1]=t=>e.username=t),autofocus:""},null,512),[[J,e.username]]),lt]),P("div",st,[N(P("input",{"onUpdate:modelValue":t[2]||(t[2]=t=>e.password=t),type:"password"},null,512),[[J,e.password]]),rt]),P(i,{title:"登陆",class:"p-button-raised p-button-rounded",onClick:e.handleLogin},null,8,["onClick"])],32)])])}));var it,ut;et.render=ot,et.__scopeId="data-v-206fc1de",(ut=it||(it={})).Dashboard="dashboard",ut.Login="login",ut.Home="home",ut.User="user",ut.Type="type",ut.Product="product";const ct=[{path:"/dashboard",component:Ke,name:it.Dashboard,meta:{title:"仪表盘",icon:f(k,null,f(G,null))}},{path:"/users",component:()=>_e((()=>import("./index.eeaaceb9.js")),["assets/index.eeaaceb9.js","assets/rounded-button.afd62da9.js","assets/rounded-button.3b87c98c.css","assets/vendor.031f8059.js"]),name:it.User,meta:{title:"用户管理",icon:f(k,null,f(K,null))}},{path:"/types",component:()=>_e((()=>import("./index.66ba15b1.js")),["assets/index.66ba15b1.js","assets/rounded-button.afd62da9.js","assets/rounded-button.3b87c98c.css","assets/vendor.031f8059.js"]),name:it.Type,meta:{title:"类别管理",icon:f(k,null,f(Q,null))}},{path:"/products",component:()=>_e((()=>import("./index.66991803.js")),["assets/index.66991803.js","assets/rounded-button.afd62da9.js","assets/rounded-button.3b87c98c.css","assets/vendor.031f8059.js"]),name:it.Product,meta:{title:"商品管理",icon:f(k,null,f(Z,null))}}],dt=X({history:Y(),routes:[{path:"/",component:Te,name:it.Home,redirect:"/dashboard",children:[...ct]},{path:"/login",name:it.Login,meta:{isPublic:!0,title:"登陆"},component:et},{path:"/:pathMatch(.*)*",name:"404",meta:{isPublic:!0},redirect:"/"}]});const pt=()=>{},mt=["get","post","delete","patch","put"],vt=["toString","valueOf","inspect","constructor",Symbol.toPrimitive,Symbol.for("util.inspect.custom")];const ht=new class{constructor(){this._$$instance=null,this._$$instance=ee({prefix:"",timeout:1e4,errorHandler:async e=>{var t;const a=window.message;if(e.request&&e.response,e.response){try{const t=await e.response.json();a.error(t.message||t.msg)}catch(n){a.error("出错了, 请查看控制台"),console.log(n)}return 401===(null==(t=null==e?void 0:e.response)?void 0:t.status)&&dt.push("/login"),Promise.reject(e)}}})}get instance(){return this._$$instance}request(e,t,a){return this._$$instance[e](t,a)}get api(){return function(e){const t=[""],a={get:(n,l)=>vt.includes(l)?()=>t.join("/"):mt.includes(l)?async a=>{const n=await e.request(l,t.join("/"),o({},a));return Array.isArray(n)||te(n)?ae(n,{deep:!0}):n}:(t.push(l),new Proxy(pt,a)),apply:(e,n,l)=>(t.push(...l.filter((e=>null!=e))),new Proxy(pt,a))};return new Proxy(pt,a)}(this)}};var ft,yt;ht.instance.interceptors.request.use(((e,n)=>{const l=he();return l&&(n.headers.Authorization="bearer "+l),{url:e+"?timestamp="+(new Date).getTime(),options:(s=o({},n),r={interceptors:!0},t(s,a(r)))};var s,r}),{}),(yt=ft||(ft={}))[yt["yyyy年M月d日"]=0]="yyyy年M月d日",yt[yt["yyyy年M月d日 HH:mm:ss"]=1]="yyyy年M月d日 HH:mm:ss",yt[yt["HH:mm"]=2]="HH:mm",yt[yt["H:mm:ss A"]=3]="H:mm:ss A",yt[yt["M-d HH:mm:ss"]=4]="M-d HH:mm:ss";const wt=(e,t="yyyy年M月d日")=>ne(new Date(e),t);function bt(){const e=i(null),t=i(""),a=he();async function n(t){var a;t.avatar=null!=(a=t.avatar)?a:le(t.email),e.value=t}return a&&(t.value=a),{user:e,token:t,setUser:n,async fetchUser(){n(await ht.api.users.me.get())},updateToken(e){e&&function(e,t){if(e)p.set("mx-admin-token",JSON.stringify(e),{expires:t})}(e,7),t.value=e}}}const gt=h({name:"Home",setup(){const{fetchUser:e}=we(bt);return u((()=>{window.message=H(),window.notification=se(),e()})),()=>f(b,null)}}),_t={common:{primaryColor:je.primary.default,primaryColorHover:je.primary.shallow,primaryColorPressed:je.primary.deep,primaryColorSuppl:je.primary.suppl}},xt=h({setup:()=>(function(...e){e.forEach((e=>{!e.token&&(e.token=Symbol("functional store")),m(e.token,e())}))}(ve,bt),()=>f(de,{locale:ue,dateLocale:ce,themeOverrides:_t},f(re,null,f(oe,null,f(ie,null,f(gt,null))))))});const Pt=new pe({colorful:!1,color:Ce}),kt=Pe;dt.beforeEach((async e=>{if(Pt.start(),!e.meta.isPublic){const{ok:e}=await ht.api("auth")("check_logged").get();if(!e)return"/login"}})),dt.afterEach(((e,t)=>{document.title=function(e){if(e)return`${e} - ${kt}`;return`${kt}`}(null==e?void 0:e.meta.title),Pt.finish()})),dt.onError((()=>{Pt.finish()}));const Ct=me(xt);Ct.use(dt),Ct.mount("#app");export{Ge as C,ht as R,ve as U,wt as p,we as u};

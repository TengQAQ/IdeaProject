import router,{ constantRoutes, adminRoutes ,enterpriseRoutes } from '@/router/index.js'
import store from '@/store/index.js'


const state = {
  // 默认路由状态
  routers: constantRoutes,
  // 根据当前登录用户对象，加载adminRoutes还是enterpriseRoutes
  addRouters: []
}

const  mutations = {
    SET_ROUTERS: (state, routers) => {
      state.addRouters = routers
      // 所有的路由=通用路由+ 商家还是管理路由  [].concat([])
      state.routers = constantRoutes.concat(routers)
    }
}

const  actions = {
    // 生成路由
    GenerateRoutes({ commit }) {
        // 异步编程模型
       return new Promise(resolve => {
         console.log('-------GenerateRoutes------')
         console.log(store.getters)
         const accountType = store.getters.accountType
         console.log(accountType)
         // 管理员
         if(accountType ===1){
            commit('SET_ROUTERS', adminRoutes)
         }else{
           //商家
            commit('SET_ROUTERS', enterpriseRoutes)
         }

         resolve()
        })

  }
}


export default {
  namespaced: true,
  state,
  mutations,
  actions
}

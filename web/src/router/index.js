import { createRouter, createWebHistory } from 'vue-router'
import SellBookView from "@/views/sellbook/SellBookIndexView"
import BuyBookView from "@/views/buybook/BuyBookIndexView"
import ErrorView from "@/views/error/ErrorIndexView"
import MyBuyView from "@/views/mybuy/MyBuyIndexView"
import UserView from "@/views/user/UserIndexView"
import UserAccountLoginView from "@/views/user/account/UserAccountLoginView"
import UserAccountRegisterView from "@/views/user/account/UserAccountRegisterView"
import store from '@/store/index'

const routes = [
  {
    path: "/",
    name: "home",
    redirect: "/buybook/",
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/buybook/",
    name: "buybook_index",
    component: BuyBookView,
    meta: {
      requestAuth: true,
    },
  },
  {
    path: "/sellbook/",
    name: "sellbook_index",
    component: SellBookView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/mybuy/",
    name: "mybuy_index",
    component: MyBuyView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/user/",
    name: "user_index",
    component: UserView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/user/account/login/",
    name: "user_account_login",
    component: UserAccountLoginView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/user/account/register",
    name: "user_account_register",
    component: UserAccountRegisterView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/404/",
    name: "404",
    component: ErrorView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/:catchAll(.*)",
    redirect: "/404/"
  }

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if(to.meta.requestAuth && !store.state.user.is_login) {
    next({name: "user_account_login"});
  } else {
    next();
  }
})


export default router

import { createRouter, createWebHistory } from 'vue-router'
import SellBookView from "@/views/sellbook/SellBookIndexView"
import BuyBookView from "@/views/buybook/BuyBookIndexView"
import ErrorView from "@/views/error/ErrorIndexView"
import MyBuyView from "@/views/mybuy/MyBuyIndexView"
import UserView from "@/views/user/UserIndexView"


const routes = [
  {
    path: "/",
    name: "home",
    redirect: "/buybook/"
  },
  {
    path: "/buybook/",
    name: "buybook_index",
    component: BuyBookView,
  },
  {
    path: "/sellbook/",
    name: "sellbook_index",
    component: SellBookView,
  },
  {
    path: "/mybuy/",
    name: "mybuy_index",
    component: MyBuyView,
  },
  {
    path: "/user/",
    name: "user_index",
    component: UserView,
  },
  {
    path: "/404/",
    name: "404",
    component: ErrorView,
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

export default router

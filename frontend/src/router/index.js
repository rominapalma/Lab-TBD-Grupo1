import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },

  {
    path: '/urgencyReport',
    name: 'urgencyReport',
    component: () => import('../views/UrgencyReport')
  },
  {
    path: '/urgencies',
    name: 'urgencies',
    component: () => import('../views/Urgencies')
  },
  {
    path: '/urgency/:id',
    name: 'urgency',
    component: () => import('../views/Urgency')
  },
  {
    path: '/UrgencyFinishedDetail/',
    name: 'UrgencyFinishedDetail',
    component: () => import('../views/UrgencyFinishedDetail')
  },
  {
    path: '/map/',
    name: 'map',
    component: () => import('../views/Map')
  },
  {
    path: '/map2/:id',
    name: 'map2',
    component: () => import('../views/Nvoluntarios')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

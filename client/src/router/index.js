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
    path: '/about',
    name: 'About',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
  },
  {
    path: '/principal',
    name: 'Principal',
    component: function () {
      return import('../views/Principal.vue')
    }
  },
  {
    path: '/carros',
    name: 'Carros',
    component: function () {
      return import('../views/Carros.vue')
    }
  },
  {
    path: '/buscarCarro',
    name: 'BuscarCarro',
    props: true,
    component: function () {
      return import('../views/BuscarCarro.vue')
    }
  },
  {
    path: '/filtros',
    name: 'Filtros',
    component: function () {
      return import('../views/Filtros.vue')
    }
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import StudentManage from '../views/StudentManage.vue'
import TeacherMenu from '@/views/TeacherMenu.vue'
import StudentMenu from '@/views/StudentMenu.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/students',
      name: 'students',
      component: StudentManage
    }
    ,
    {
      path: '/teachermain',
      name: 'teachermain',
      component: TeacherMenu
    }
    ,
    {
      path: '/studentmain',
      name: 'studentmain',
      component: StudentMenu
    },
    {
      path: '/teacher',
      name: 'teacher',
      component: () => import('../views/TeacherAuth.vue')
    }
  ]
})

export default router

//path는 주소창에 입력하는 경로
//name은 라우터의 이름
//component는 해당 경로에 매핑될 컴포넌트


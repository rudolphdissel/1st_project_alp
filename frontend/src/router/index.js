import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import StudentManage from '../views/StudentManage.vue'
import TeacherLogin from '../views/TeacherLogin.vue'
import TeacherMenu from '../views/TeacherMenu.vue'
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
    },
    {
      path: '/teacherlogin',
      name: 'teacherlogin',
      component: TeacherLogin
    },
    {
      path: '/teachermenu',
      name: 'teachermenu',
      component: TeacherMenu
    },
    {
      path: '/studentmain',
      name: 'studentmain',
      component: StudentMenu
    }
  ]
})

export default router

//path는 주소창에 입력하는 경로
//name은 라우터의 이름
//component는 해당 경로에 매핑될 컴포넌트


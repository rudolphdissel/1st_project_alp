<template>
  <div class="teacher-main">
    <div class="header">
      <h2>교사 메인 페이지</h2>
      <div class="teacher-info">
        <span>{{ teacherName }} 선생님</span>
        <button @click="handleLogout" class="logout-button">로그아웃</button>
      </div>
    </div>
    
    <div class="menu-buttons">
      <RouterLink to="/student" class="menu-button">학생 관리</RouterLink>
    </div>
  </div>
</template>

<script>
import { useRouter } from 'vue-router';

export default {
  name: 'TeacherMain',
  data() {
    return {
      teacherName: localStorage.getItem('teacher_name') || '알 수 없음'
    }
  },
  setup() {
    const router = useRouter();
    return { router }
  },
  created() {
    // 로그인 체크
    const teacherId = localStorage.getItem('teacher_id');
    if (!teacherId) {
      this.router.push('/teacher');
    }
  },
  methods: {
    handleLogout() {
      localStorage.removeItem('teacher_id');
      localStorage.removeItem('teacher_name');
      this.router.push('/');
    }
  }
}
</script>

<style scoped>
.teacher-main {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 30px;
}

.teacher-info {
  display: flex;
  align-items: center;
  gap: 15px;
}

.menu-buttons {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.menu-button {
  padding: 15px;
  font-size: 18px;
  color: white;
  background-color: #4CAF50;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  text-decoration: none;
  text-align: center;
  transition: all 0.3s ease;
}

.menu-button:hover {
  background-color: #45a049;
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0,0,0,0.2);
}

.logout-button {
  padding: 8px 16px;
  font-size: 14px;
  color: white;
  background-color: #f44336;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.logout-button:hover {
  background-color: #da190b;
}
</style> 
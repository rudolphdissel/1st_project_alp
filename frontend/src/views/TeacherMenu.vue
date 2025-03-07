<template>
  <div class="teacher-menu">
    <div class="teacher-info">
      현재 접속: {{ teacherName }} 선생님 (ID: {{ teacherId }})
      <button @click="logout" class="logout-button">로그아웃</button>
    </div>
    <h1>이곳은 교사 페이지입니다!</h1>
    <div class="button-container">
      <RouterLink to="/students" class="menu-button">학생 관리</RouterLink>
      <RouterLink to="/" class="menu-button">홈으로</RouterLink>
    </div>
  </div>
</template>

<script>
import { useRouter } from 'vue-router';

export default {
  data() {
    return {
      teacherId: localStorage.getItem('teacherId'),
      teacherName: localStorage.getItem('teacherName')
    }
  },
  setup() {
    const router = useRouter();
    return { router }
  },
  created() {
    // 로그인 상태가 아니면 홈으로 리다이렉트
    if (!this.teacherId) {
      this.router.push('/');
    }
  },
  methods: {
    logout() {
      // localStorage에서 교사 정보 삭제
      localStorage.removeItem('teacherId');
      localStorage.removeItem('teacherName');
      
      // 홈으로 리다이렉트
      this.router.push('/');
    }
  }
}
</script>

<style scoped>
.teacher-menu {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 80vh;
  padding: 20px;
  background-color: #f8f9fa;
  position: relative;
}

.teacher-info {
  position: absolute;
  top: 20px;
  right: 20px;
  padding: 10px;
  background-color: #4CAF50;
  color: white;
  border-radius: 8px;
  font-weight: bold;
  display: flex;
  align-items: center;
  gap: 10px;
}

.logout-button {
  padding: 5px 10px;
  background-color: #dc3545;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 0.9em;
  transition: background-color 0.3s;
}

.logout-button:hover {
  background-color: #c82333;
}

h1 {
  color: #2c3e50;
  font-size: 2.5rem;
  margin-bottom: 2rem;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
}

.button-container {
  display: flex;
  gap: 20px;
  margin-top: 1rem;
}

.menu-button {
  display: inline-block;
  padding: 12px 24px;
  color: white;
  background-color: #4CAF50;
  text-decoration: none;
  border-radius: 8px;
  font-weight: bold;
  transition: all 0.3s ease;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.menu-button:hover {
  background-color: #45a049;
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}
</style>
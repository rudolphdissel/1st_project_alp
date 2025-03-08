<template>
  <div class="teacher-menu">
    <h1>교사 메뉴</h1>
    <div class="menu-buttons">
      <router-link to="/students" class="menu-button">
        학생관리
      </router-link>
      <button class="menu-button disabled" disabled>
        성적보기 (준비중)
      </button>
      <router-link to="/" class="menu-button">
        홈으로
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'TeacherMenu',
  created() {
    const teacherId = localStorage.getItem('teacherId');
    if (!teacherId) {
      this.$router.push('/teacherlogin');
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
  min-height: 100vh;
  padding: 20px;
  background-color: #f5f5f5;
}

h1 {
  color: #333;
  margin-bottom: 40px;
  font-size: 2.5em;
}

.menu-buttons {
  display: flex;
  flex-direction: column;
  gap: 20px;
  width: 100%;
  max-width: 300px;
}

.menu-button {
  padding: 15px 30px;
  font-size: 1.2em;
  color: white;
  background-color: #4CAF50;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  text-decoration: none;
  text-align: center;
  transition: background-color 0.3s;
}

.menu-button:hover {
  background-color: #45a049;
}

.menu-button.disabled {
  background-color: #cccccc;
  cursor: not-allowed;
}

.menu-button.disabled:hover {
  background-color: #cccccc;
}
</style>
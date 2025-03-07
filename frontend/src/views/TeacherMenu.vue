<template>
  <div class="teacher-menu">
    <h1>이곳은 교사 페이지입니다!</h1>
    <div class="button-container">
      <RouterLink to="/students" class="menu-button">학생 관리</RouterLink>
      <RouterLink to="/" class="menu-button">홈으로</RouterLink>
    </div>
  </div>
</template>

<style scoped>
.teacher-menu {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 80vh;
  padding: 20px;
  background-color: #f8f9fa;
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
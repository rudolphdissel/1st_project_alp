<template>
  <div class="home">
    <h1 class="title">LMS 관리 프로그램</h1>
    <img src="https://blog.kakaocdn.net/dn/bT4f9F/btqwMJHBvjt/Wl7hSDXr9G94XP3pLqloy0/img.jpg" alt="LMS Logo"/>
    
    <div class="button-container">
      <RouterLink to="/teacher" class="nav-link">교사 페이지</RouterLink>
      <RouterLink to="/studentmain" class="nav-link">학생 페이지</RouterLink>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeView'
}
</script>

<style scoped>
.home {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 80vh;
  padding: 20px;
}

img {
  width: 100px;
  height: 100px;
  margin: 20px 0;
}

.title {
  color: #2c3e50;
  font-size: 2.5rem;
  margin-bottom: 2rem;
  text-align: center;
}

.button-container {
  display: flex;
  gap: 20px;
  margin-top: 2rem;
}

.nav-link {
  display: inline-block;
  padding: 15px 30px;
  font-size: 1.2rem;
  color: white;
  background-color: #4CAF50;
  text-decoration: none;
  border-radius: 8px;
  font-weight: bold;
  transition: all 0.3s ease;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.nav-link:hover {
  background-color: #45a049;
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}
</style>
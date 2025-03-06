<template>
  <div class="home">
    <h1>Hello World!</h1>
    <RouterLink to="/students" class="nav-link">학생 관리 페이지로 이동</RouterLink>
  </div>
</template>

<style scoped>
.home {
  text-align: center;
  padding: 20px;
}

.nav-link {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #4CAF50;
  color: white;
  text-decoration: none;
  border-radius: 3px;
}

.nav-link:hover {
  background-color: #45a049;
}
</style>
  
  